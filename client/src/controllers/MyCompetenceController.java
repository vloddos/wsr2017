package controllers;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class MyCompetenceController {

    public Label competence;

    public VBox competitors;
    public VBox experts;

    public void setPeople(ArrayList<String[]> people, VBox v) {
        v.getChildren().clear();
        int i, j;
        for (i = 0; i < people.size(); i = j) {
            HBox hBox = new HBox(30);
            hBox.setAlignment(Pos.CENTER);
            hBox.setMinHeight(350);

            for (j = i; j < i + 4 && j < people.size(); ++j) {
                VBox vBox = new VBox();
                vBox.setAlignment(Pos.TOP_CENTER);

                ImageView imageView = new ImageView();//people's photo
                imageView.setFitWidth(150);
                imageView.setFitHeight(150);
                Label name = new Label(people.get(j)[0] + " " + people.get(j)[1]);
                name.setMaxWidth(100);
                name.setWrapText(true);
                Label region = new Label("(" + people.get(j)[2] + ")");
                region.setMaxWidth(100);
                region.setWrapText(true);

                vBox.getChildren().addAll(imageView, name, region);
                hBox.getChildren().add(vBox);
            }
            v.getChildren().add(hBox);
        }
    }
}
