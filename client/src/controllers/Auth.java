package controllers;

import client.Client;
import common.*;

import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import views.Stages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.*;

public class Auth implements Initializable {

    public Canvas canvas;
    private GraphicsContext graphicsContext;

    private String[] l = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private String[] u = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private String[] d = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private String[][] lud = {l, u, d};
    private String current_code;

    private Random random = new Random();

    public TextField email;
    public PasswordField password;
    public TextField captcha;
    public CheckBox remember_me;
    public Label message;
    public Button login;

    private int failed = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setStroke(Color.BLACK);
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.setFont(Font.font("Calibri", FontPosture.ITALIC, 12));
        graphicsContext.save();
        getEP();
    }

    public void getEP() {
        try (var scanner = new Scanner(new File("remember_me.txt"))) {
            email.setText(scanner.nextLine());
            password.setText(scanner.nextLine());
            remember_me.setSelected(true);
        } catch (NoSuchElementException e1) {
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            try {
                new File("remember_me.txt").createNewFile();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    public void setEP() {
        try (var printWriter = new PrintWriter(new File("remember_me.txt"))) {
            if (remember_me.isSelected()) {
                printWriter.println(email.getText());
                printWriter.println(password.getText());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void cancel() {
        email.setText("");
        password.setText("");
        captcha.setText("");
    }

    private void setCode() {
        String[] tmp = lud[random.nextInt(3)];
        current_code = String.join("", l[random.nextInt(26)], u[random.nextInt(26)], d[random.nextInt(10)], tmp[random.nextInt(tmp.length)]);
    }

    public void updateCaptcha() {
        graphicsContext.restore();
        graphicsContext.save();
        graphicsContext.clearRect(0, 0, 128, 40);
        setCode();
        graphicsContext.strokeText(current_code, 50, 25);
        graphicsContext.setStroke(Color.RED);
        graphicsContext.strokeLine(0, 22, 128, 22);
        graphicsContext.setStroke(Color.GREEN);
        graphicsContext.strokeLine(0, 0, 128, 40);
        graphicsContext.setStroke(Color.BLUE);
        graphicsContext.strokeLine(0, 40, 128, 0);
    }

    public void login() {
        Answer answer = captcha.getText().equals(current_code) ?
                Client.request(Query.createLOGIN(email.getText(), password.getText())) :
                new Answer(Answer.Status.ERROR, "Wrong code");

        if (answer.status == Answer.Status.ERROR) {
            message.setText(answer.message);
            ++failed;
            if (failed == 3) {
                cancel();
                login.setDisable(true);
            }
            updateCaptcha();
            return;
        }
        message.setText("");
        failed = 0;
        User.user = answer.user;

        int h = new GregorianCalendar().get(Calendar.HOUR);
        String tmp;
        if (h >= 6 && h < 12)
            tmp = "Доброе утро ";
        else if (h >= 12 && h < 18)
            tmp = "Добрый день ";
        else
            tmp = "Добрый вечер ";
        tmp += (User.user.gender == 'M' ? "Mr " : "Mrs ") + User.user.firstname;

        switch (User.user.role) {
            case 'C':
                Controllers.competitor.greeting.setText(tmp);

                Controllers.myProfile.name.setText(User.user.firstname + " " + User.user.lastname);
                Controllers.myProfile.gender.setText(User.user.gender == 'M' ? "Male" : "Female");
                Controllers.myProfile.dateofbirth.setText(User.user.dateofbirth);
                Controllers.myProfile.region.setText(User.user.region);
                Controllers.myProfile.email.setText(User.user.email);

                Controllers.myCompetence.competence.setText(
                        User.user.competencenumber == null ?
                                "No competence" :
                                User.user.competencenumber + " - " + User.user.competencename
                );

                Controllers.myResults.name.setText(User.user.firstname + " " + User.user.lastname);
                Controllers.myResults.gender.setText(User.user.gender == 'M' ? "Male" : "Female");
                Controllers.myResults.dateofbirth.setText(User.user.dateofbirth);
                Controllers.myResults.region.setText(User.user.region);
                Controllers.myResults.email.setText(User.user.email);
                Controllers.myResults.competence.setText(
                        User.user.competencenumber == null ?
                                "No competence" :
                                User.user.competencenumber + " - " + User.user.competencename
                );

                Header.open(Stages.getInstance().competitor_menu_stage);
                break;
            case 'O':
                Controllers.coordinator.greeting.setText(tmp);
                Header.open(Stages.getInstance().coordinator_menu_stage);
                break;
            case 'A':
                Controllers.administrator.greeting.setText(tmp);
                Header.open(Stages.getInstance().administrator_menu_stage);
                break;
            case 'E':
                Controllers.expert.greeting.setText(tmp);
                Header.open(Stages.getInstance().expert_menu_stage);
                break;
        }
    }
}
