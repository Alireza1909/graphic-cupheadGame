package com.example.apcupheadazmayeshi;

import com.example.apcupheadazmayeshi.View.LoginMenu;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.net.URL;

import static javafx.application.Application.launch;

public class Main extends Application {
    public static Stage stage;
    public static MediaPlayer mediaPlayer;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        stage = new Stage();
        URL address = new URL(Main.class.getResource("Audio/Alfred-Hitchcock-Presents-Theme.mp3").toString());
        Media media = new Media(address.toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        LoginMenu loginMenu = new LoginMenu();
        loginMenu.start(stage);
    }
}