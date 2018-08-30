package controllers;

import javafx.scene.control.Label;
import views.View;

public class MainController {

    public Label championship;
    public Label address;

    public void openAuth() {
        HeaderController.open(View.getInstance().auth_stage);
    }
}
