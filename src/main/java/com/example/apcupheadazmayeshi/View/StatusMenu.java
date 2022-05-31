package com.example.apcupheadazmayeshi.View;

import com.example.apcupheadazmayeshi.Main;
import com.example.apcupheadazmayeshi.Model.GameBoard;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class StatusMenu {


    public static Scene victory;
    public static Scene loss;
    public static StatusController statusController;


    public static void showVictory() {
        Main.stage.setScene(victory);
        Main.stage.show();
    }

    public void start(GameBoard gameBoard) throws IOException {
        createAllScenes();
        Main.stage.setTitle("Status Menu");
        statusController = new StatusController(gameBoard.getCupHead().getXP());
        statusController.setScoreText();
        if (gameBoard.getCupHead().getHP() <= 0)
            showLose();
        else if (gameBoard.getBoss().getHP() <=0)
            showVictory();
        System.out.println("amat dishab inja bood");
    }

    private void showLose() {
        Main.stage.setScene(loss);
        Main.stage.show();
    }

    private static void createAllScenes() throws IOException {
        victory = sceneCreator("fxml/victory-view.fxml");
        loss = sceneCreator("fxml/defeat-view.fxml");
    }

    public static Scene sceneCreator(String resource) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(resource));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 800);
        setSize(scene);
        return scene;
    }

    public static void setSize(Scene scene) {
        double height = Screen.getPrimary().getVisualBounds().getHeight() - 20;
        ((BorderPane) scene.getRoot()).setPrefHeight(800.0);
        ((BorderPane) scene.getRoot()).setPrefWidth(600.0);
    }


//    public static void showInvalidLogin() throws IOException {
//
//        Main.stage.setScene(invalidLogin);
//        Main.stage.show();
//    }
}
