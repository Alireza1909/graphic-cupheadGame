package com.example.apcupheadazmayeshi.View;

import com.example.apcupheadazmayeshi.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupMenu {
    public static Scene invalidSignup;
    private static Scene signup;
//    public static Stage stage;
    private static String errorMessage;

    public void start(Stage stage1) throws IOException {
        createAllScenes();
        showSignUp();
    }

    public void createAllScenes() throws IOException {
        signup = sceneCreator("fxml/signup-view.fxml");
        invalidSignup = sceneCreator("fxml/invalidSignup-view.fxml");
    }

    public static Scene sceneCreator(String resource) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(resource));
        Scene scene = new Scene(fxmlLoader.load(),1200,800);
        setSize(scene);
        return scene;
    }

    public static void setSize(Scene scene) {
        double height = Screen.getPrimary().getVisualBounds().getHeight() - 20;
        ((BorderPane) scene.getRoot()).setPrefHeight(600.0);
        ((BorderPane) scene.getRoot()).setPrefWidth(800.0);
    }


    public static void showSignUp() {
        Main.stage.setScene(signup);
        Main.stage.show();
    }

    public static void showError(){
        Main.stage.setScene(invalidSignup);
        Main.stage.show();
    }

    public static void setErrorMessage(String errorMessage) {
        SignupMenu.errorMessage = errorMessage;
    }

    public static String getErrorMessage() {
        return errorMessage;
    }
}
