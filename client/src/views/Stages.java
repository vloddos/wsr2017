package views;

import controllers.Controllers;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Stages {

    private static Stages Instance = new Stages();

    public static Stages getInstance() {
        return Instance;
    }

    private FXMLLoader loader;

    public InitializedStage main_stage = new InitializedStage();
    public InitializedStage auth_stage = new InitializedStage();
    public InitializedStage competitor_menu_stage = new InitializedStage();
    public InitializedStage coordinator_menu_stage = new InitializedStage();
    public InitializedStage administrator_menu_stage = new InitializedStage();
    public InitializedStage expert_menu_stage = new InitializedStage();
    public InitializedStage my_profile_stage = new InitializedStage();
    public InitializedStage my_competence_stage = new InitializedStage();
    public InitializedStage my_results_stage = new InitializedStage();
    public InitializedStage about_world_skills_stage = new InitializedStage();
    public InitializedStage history_of_world_skills_stage = new InitializedStage();

    private Parent main_form;
    private Parent auth_form;
    private Parent competitor_menu_form;
    private Parent coordinator_menu_form;
    private Parent administrator_menu_form;
    private Parent expert_menu_form;
    private Parent my_profile_form;
    private Parent my_competence_form;
    private Parent my_results_form;
    private Parent about_world_skills_fxml;
    private Parent history_of_world_skills_fxml;

    private Stages() {
        try {
            loader = new FXMLLoader(getClass().getResource("/forms/main.fxml"));
            main_form = loader.load();
            Controllers.main = loader.getController();

            loader = new FXMLLoader(getClass().getResource("/forms/auth.fxml"));
            auth_form = loader.load();
            Controllers.auth = loader.getController();

            loader = new FXMLLoader(getClass().getResource("/forms/competitor_menu.fxml"));
            competitor_menu_form = loader.load();
            Controllers.competitor = loader.getController();

            loader = new FXMLLoader(getClass().getResource("/forms/coordinator_menu.fxml"));
            coordinator_menu_form = loader.load();
            Controllers.coordinator = loader.getController();

            loader = new FXMLLoader(getClass().getResource("/forms/administrator_menu.fxml"));
            administrator_menu_form = loader.load();
            Controllers.administrator = loader.getController();

            loader = new FXMLLoader(getClass().getResource("/forms/expert_menu.fxml"));
            expert_menu_form = loader.load();
            Controllers.expert = loader.getController();

            loader = new FXMLLoader(getClass().getResource("/forms/my_profile.fxml"));
            my_profile_form = loader.load();
            Controllers.myProfile = loader.getController();

            loader = new FXMLLoader(getClass().getResource("/forms/my_competence.fxml"));
            my_competence_form = loader.load();
            Controllers.myCompetence = loader.getController();

            loader = new FXMLLoader(getClass().getResource("/forms/my_results.fxml"));
            my_results_form = loader.load();
            Controllers.myResults = loader.getController();

            about_world_skills_fxml = FXMLLoader.load(getClass().getResource("/forms/about_world_skills.fxml"));

            history_of_world_skills_fxml = FXMLLoader.load(getClass().getResource("/forms/history_of_world_skills.fxml"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        main_stage.setTitle("WSR 2017");
        main_stage.setScene(new Scene(main_form));

        auth_stage.setTitle("WSR 2017 - Авторизация");
        auth_stage.setScene(new Scene(auth_form));
        auth_stage.setOnShown(e -> {
                    if (!Controllers.auth.remember_me.isSelected())
                        Controllers.auth.cancel();
                    Controllers.auth.updateCaptcha();
                }
        );

        competitor_menu_stage.setScene(new Scene(competitor_menu_form));
        coordinator_menu_stage.setScene(new Scene(coordinator_menu_form));
        administrator_menu_stage.setScene(new Scene(administrator_menu_form));
        expert_menu_stage.setScene(new Scene(expert_menu_form));

        my_profile_stage.setScene(new Scene(my_profile_form));
        my_profile_stage.setOnShown(e -> Controllers.myProfile.onShown());

        my_competence_stage.setScene(new Scene(my_competence_form));

        my_results_stage.setScene(new Scene(my_results_form));
        my_results_stage.setOnShown(e -> Controllers.myResults.onShown());

        about_world_skills_stage.setScene(new Scene(about_world_skills_fxml));

        history_of_world_skills_stage.setScene(new Scene(history_of_world_skills_fxml));
    }
}
