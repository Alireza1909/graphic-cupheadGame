package com.example.apcupheadazmayeshi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginMenu{

    public static Scene loginPage;
    public static Scene invalidLogin;

    public static void showLoginMenu() {
        Main.stage.setScene(loginPage);
        Main.stage.show();
    }

    public void start(Stage sth) throws IOException{
        createAllScenes();
        Main.stage = sth;
        Main.stage.setTitle("Login Page");
        Main.stage.setScene(loginPage);
        Main.stage.show();
    }

    private static void createAllScenes() throws IOException{
        loginPage = sceneCreator("fxml/Login-view.fxml");
        invalidLogin = sceneCreator("fxml/InvalidLogin-view.fxml");
    }

    public static Scene sceneCreator(String resource) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(LoginMenu.class.getResource(resource));
        Scene scene = new Scene(fxmlLoader.load(),1200,800);
        setSize(scene);
        return scene;
    }

    public static void setSize(Scene scene) {
        double height = Screen.getPrimary().getVisualBounds().getHeight() - 20;
        ((BorderPane) scene.getRoot()).setPrefHeight(800.0);
        ((BorderPane) scene.getRoot()).setPrefWidth(600.0);
    }


    public static void showInvalidLogin() throws IOException{

        Main.stage.setScene(invalidLogin);
        Main.stage.show();
    }


}