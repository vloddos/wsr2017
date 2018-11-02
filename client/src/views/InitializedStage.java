package views;

import controllers.Controllers;
import javafx.stage.Stage;

public class InitializedStage extends Stage {

    public InitializedStage() {//title???
        super();
        setOnCloseRequest(e -> Controllers.auth.setEP());
    }
}
