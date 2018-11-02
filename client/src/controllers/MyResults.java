package controllers;

import client.Client;
import common.Answer;
import common.Query;
import common.User;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MyResults {

    public Label name;
    public Label gender;
    public Label dateofbirth;
    public Label region;
    public Label email;

    public Label championship;
    public Label competence;
    public Label number;

    public VBox modul;
    public VBox value;

    public Label mark;

    public void onShown() {
        modul.getChildren().clear();
        value.getChildren().clear();

        if (User.user.competencenumber == null) {
            championship.setText("");
            number.setText("");
            mark.setText("");
            return;
        }

        Answer answer = Client.request(Query.createLOAD_MY_RESULTS(User.user.email, User.user.competencenumber));
        championship.setText(answer.championship);
        number.setText(answer.number);
        var v = answer.modules.split(", ");
        for (var i = 0; i < v.length; ++i) {
            modul.getChildren().add(new Label("Модуль " + (i + 1) + ":"));
            value.getChildren().add(new Label(v[i]));
        }
        mark.setText(answer.mark);
    }
}
