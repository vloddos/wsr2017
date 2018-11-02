package controllers;

import client.Client;
import common.MyCompetenceData;
import common.Query;
import common.User;

import javafx.scene.control.Label;

import views.Stages;

public class Competitor {

    public Label greeting;

    public void openMyProfile() {
        Header.open(Stages.getInstance().my_profile_stage);
    }

    public void openMyCompetence() {
        //setOnShown begin
        //...clear???

        if (User.user.competencenumber != null) {
            MyCompetenceData data = Client.request(Query.createLOAD_MY_COMPETENCE(User.user.competencenumber)).data;
            Controllers.myCompetence.setPeople(data.competitor, Controllers.myCompetence.competitors);
            Controllers.myCompetence.setPeople(data.expert, Controllers.myCompetence.experts);
        }

        Header.open(Stages.getInstance().my_competence_stage);
    }

    public void openMyResults() {
        Header.open(Stages.getInstance().my_results_stage);
    }
}
