package com.example.apcupheadazmayeshi.View;

import com.example.apcupheadazmayeshi.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfileMenu {

    private static Stage stage;
    private static Scene profileMenu;
    private static Scene sth;

    public void start(Stage stage1) throws IOException {
        stage = stage1;
        createAllScenes();
        showMenu();
    }

    public void createAllScenes() throws IOException {//change them motherfuckers
        profileMenu = sceneCreator("fxml/signup-view.fxml");
        sth = sceneCreator("fxml/invalidSignup-view.fxml");
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


    public static void showMenu(){
        stage.setScene(profileMenu);
        stage.show();
    }
}
