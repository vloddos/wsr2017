package client;

import controllers.Footer;
import controllers.Header;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        //Stages.getInstance();//???
        Header.openMain();
        Footer.startThread();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
