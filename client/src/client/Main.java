package client;

import controllers.FooterController;
import javafx.application.Application;
import javafx.stage.Stage;
import views.View;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        View.getInstance().main_stage.show();
        FooterController.startThread();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
