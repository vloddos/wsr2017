package views;

import controllers.Controllers;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Stack;

public class View {

    private static View Instance = new View();

    public static View getInstance() {
        return Instance;
    }

    private FXMLLoader loader;
    public Stack<Stage> stack = new Stack<>();

    public Stage main_stage = new Stage();
    public Stage auth_stage = new Stage();
    public Stage competitor_menu_stage = new Stage();
    public Stage coordinator_menu_stage = new Stage();
    public Stage administrator_menu_stage = new Stage();
    public Stage expert_menu_stage = new Stage();
    public Stage my_profile_stage = new Stage();
    public Stage my_competence_stage = new Stage();
    public Stage my_results_stage = new Stage();

    private Parent main_form;
    private Parent auth_form;
    private Parent competitor_menu_form;
    private Parent coordinator_menu_form;
    private Parent administrator_menu_form;
    private Parent expert_menu_form;
    private Parent my_profile_form;
    private Parent my_competence_form;
    private Parent my_results_form;

    private View() {
        try {
            loader = new FXMLLoader(getClass().getResource("/forms/main.fxml"));
            main_form = loader.load();
            Controllers.mainController = loader.getController();

            loader = new FXMLLoader(getClass().getResource("/forms/auth.fxml"));
            auth_form = loader.load();
            Controllers.authController = loader.getController();

            loader = new FXMLLoader(getClass().getResource("/forms/competitor_menu.fxml"));
            competitor_menu_form = loader.load();
            Controllers.competitorController = loader.getController();

            loader = new FXMLLoader(getClass().getResource("/forms/coordinator_menu.fxml"));
            coordinator_menu_form = loader.load();
            Controllers.coordinatorController = loader.getController();

            loader = new FXMLLoader(getClass().getResource("/forms/administrator_menu.fxml"));
            administrator_menu_form = loader.load();
            Controllers.administratorController = loader.getController();

            loader = new FXMLLoader(getClass().getResource("/forms/expert_menu.fxml"));
            expert_menu_form = loader.load();
            Controllers.expertController = loader.getController();

            loader = new FXMLLoader(getClass().getResource("/forms/my_profile.fxml"));
            my_profile_form = loader.load();
            Controllers.myProfileController = loader.getController();

            loader = new FXMLLoader(getClass().getResource("/forms/my_competence.fxml"));
            my_competence_form = loader.load();
            Controllers.myCompetenceController = loader.getController();

            loader = new FXMLLoader(getClass().getResource("/forms/my_results.fxml"));
            my_results_form = loader.load();
            Controllers.myResultsController = loader.getController();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        main_stage.setTitle("WSR 2017");
        main_stage.setScene(new Scene(main_form));
        main_stage.setOnCloseRequest(e -> Controllers.authController.setEP());

        auth_stage.setTitle("WSR 2017 - Авторизация");
        auth_stage.setScene(new Scene(auth_form));
        auth_stage.setOnShown(e -> {
                    if (!Controllers.authController.remember_me.isSelected())
                        Controllers.authController.cancel();
                    Controllers.authController.updateCaptcha();
                }
        );

        competitor_menu_stage.setScene(new Scene(competitor_menu_form));
        coordinator_menu_stage.setScene(new Scene(coordinator_menu_form));
        administrator_menu_stage.setScene(new Scene(administrator_menu_form));
        expert_menu_stage.setScene(new Scene(expert_menu_form));

        my_profile_stage.setScene(new Scene(my_profile_form));
        my_profile_stage.setOnShown(e -> Controllers.myProfileController.onShown());

        my_competence_stage.setScene(new Scene(my_competence_form));

        my_results_stage.setScene(new Scene(my_results_form));
        my_results_stage.setOnShown(e -> Controllers.myResultsController.onShown());

        stack.push(main_stage);
    }
}
