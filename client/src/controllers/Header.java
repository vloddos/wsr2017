package controllers;

import common.User;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import views.InitializedStage;
import views.Stages;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

public class Header implements Initializable {

    private static Stack<InitializedStage> stack = new Stack<>();

    public Label championship;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Controllers.hcal.add(this);
    }

    public void back() {
        stack.pop().hide();
        stack.peek().show();
    }

    static void open(InitializedStage stage) {
        stack.peek().hide();
        stack.push(stage).show();
    }

    public static void openMain() {
        stack.push(Stages.getInstance().main_stage).show();
    }

    public void logout() {
        do {
            back();
        } while (!stack.peek().equals(Stages.getInstance().auth_stage));
        User.user = null;
        Stages.getInstance().auth_stage.show();
    }
}
