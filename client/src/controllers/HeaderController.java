package controllers;

import common.User;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import views.View;

import java.net.URL;
import java.util.ResourceBundle;

public class HeaderController implements Initializable {

    public Label championship;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Controllers.hcal.add(this);
    }

    public void back() {
        View.getInstance().stack.pop().hide();
        View.getInstance().stack.peek().show();
    }

    public static void open(Stage stage) {
        View.getInstance().stack.peek().hide();
        View.getInstance().stack.push(stage).show();
    }

    public void logout() {
        do {
            back();
        } while (!View.getInstance().stack.peek().equals(View.getInstance().auth_stage));
        User.user = null;
        View.getInstance().auth_stage.show();
    }
}
