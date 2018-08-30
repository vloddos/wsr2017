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
import views.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AuthController implements Initializable {

    public Canvas canvas;
    private GraphicsContext graphicsContext;

    private String[] l = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private String[] u = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private String[] d = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private String[][] lud = new String[][]{l, u, d};
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
        try (var scanner = new Scanner(new File("src\\remember_me.txt"))) {
            email.setText(scanner.nextLine());
            password.setText(scanner.nextLine());
            remember_me.setSelected(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setEP() {
        try (var printWriter = new PrintWriter(new File("src\\remember_me.txt"))) {
            if (remember_me.isSelected()) {
                printWriter.println(email.getText());
                printWriter.println(password.getText());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
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
        //View.getInstance().parseAnswer???
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
        String tmp =
                (User.user.gender == 'M' ? "Mr " : "Mrs ") + User.user.firstname;
        switch (User.user.role) {
            case 'C':
                Controllers.competitorController.greeting.setText(tmp);

                Controllers.myProfileController.name.setText(User.user.firstname + " " + User.user.lastname);
                Controllers.myProfileController.gender.setText(User.user.gender == 'M' ? "Male" : "Female");
                Controllers.myProfileController.dateofbirth.setText(User.user.dateofbirth);
                Controllers.myProfileController.region.setText(User.user.region);
                Controllers.myProfileController.email.setText(User.user.email);

                Controllers.myCompetenceController.competence.setText(
                        User.user.competencenumber == null ?
                                "No competence" :
                                User.user.competencenumber + " - " + User.user.competencename
                );

                Controllers.myResultsController.name.setText(User.user.firstname + " " + User.user.lastname);
                Controllers.myResultsController.gender.setText(User.user.gender == 'M' ? "Male" : "Female");
                Controllers.myResultsController.dateofbirth.setText(User.user.dateofbirth);
                Controllers.myResultsController.region.setText(User.user.region);
                Controllers.myResultsController.email.setText(User.user.email);
                Controllers.myResultsController.competence.setText(
                        User.user.competencenumber == null ?
                                "No competence" :
                                User.user.competencenumber + " - " + User.user.competencename
                );

                HeaderController.open(View.getInstance().competitor_menu_stage);
                break;
            case 'O':
                Controllers.coordinatorController.greeting.setText(tmp);
                HeaderController.open(View.getInstance().coordinator_menu_stage);
                break;
            case 'A':
                Controllers.administratorController.greeting.setText(tmp);
                HeaderController.open(View.getInstance().administrator_menu_stage);
                break;
            case 'E':
                Controllers.expertController.greeting.setText(tmp);
                HeaderController.open(View.getInstance().expert_menu_stage);
                break;
        }
    }
}
