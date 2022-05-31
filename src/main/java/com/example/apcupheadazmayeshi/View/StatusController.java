package com.example.apcupheadazmayeshi.View;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class StatusController {
    public int score;

    @FXML
    public Text scoreText = new Text();

    public StatusController(int sc){
        score = sc;
    }

    public void setScoreText(){
        Integer sc = score;
        this.scoreText.setText(sc.toString());
    }


    public void gameLevel(MouseEvent mouseEvent) {
        LoginMenu.showGameLevel();
    }

    public void backToLoginMenu(MouseEvent mouseEvent) {
        LoginMenu.showLoginMenu();
    }
}
