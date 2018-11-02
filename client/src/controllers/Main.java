package controllers;

import javafx.scene.control.Label;
import views.Stages;

public class Main {

    public Label championship;
    public Label address;

    public void openAuth() {
        Header.open(Stages.getInstance().auth_stage);
    }

    public void openAboutWorldSkills() {
        Header.open(Stages.getInstance().about_world_skills_stage);
    }
}
