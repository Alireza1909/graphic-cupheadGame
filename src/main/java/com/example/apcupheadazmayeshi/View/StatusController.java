package com.example.apcupheadazmayeshi.View;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class StatusController {
    public static int score;

    @FXML
    public Text scoreText = new Text();

    public StatusController(int sc){
        score = sc;
    }

    public void setScoreText(){
        Integer sc = score;
        this.scoreText.setText(sc.toString());
    }



}
