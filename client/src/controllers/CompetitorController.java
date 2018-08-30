package controllers;

import client.Client;
import common.MyCompetenceData;
import common.Query;
import common.User;

import javafx.scene.control.Label;

import views.View;

public class CompetitorController {

    public Label greeting;

    public void openMyProfile() {
        HeaderController.open(View.getInstance().my_profile_stage);
    }

    public void openMyCompetence() {
        //setOnShown begin
        //...clear???

        if (User.user.competencenumber != null) {
            MyCompetenceData data = Client.request(Query.createLOAD_MY_COMPETENCE(User.user.competencenumber)).data;
            Controllers.myCompetenceController.setPeople(data.competitor, Controllers.myCompetenceController.competitors);
            Controllers.myCompetenceController.setPeople(data.expert, Controllers.myCompetenceController.experts);
        }

        HeaderController.open(View.getInstance().my_competence_stage);
    }

    public void openMyResults() {
        HeaderController.open(View.getInstance().my_results_stage);
    }
}
