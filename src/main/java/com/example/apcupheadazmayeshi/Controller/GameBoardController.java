package com.example.apcupheadazmayeshi.Controller;

import com.example.apcupheadazmayeshi.Model.Bomb;
import com.example.apcupheadazmayeshi.Model.Bullet;
import com.example.apcupheadazmayeshi.Model.GameBoard;
import com.example.apcupheadazmayeshi.Model.MiniBoss;

import java.util.ArrayList;
import java.util.Random;

public class GameBoardController {

    public static GameBoard gameBoard;
    public GameBoardController(GameBoard gameBoard){
        setGameBoard(gameBoard);
    }
    public static void setGameBoard(GameBoard gameBoard1){
        gameBoard = gameBoard1;
    }

    public void addBullet(){
        gameBoard.addBullet();
    }


    public void updateBullets() {
        //TODO colition
        for (int i=0;i<gameBoard.getBullets().size();i++){
            if (gameBoard.getBullets().get(i).getX() >= 1000){
                gameBoard.removeBulletByIndex(i);
            }
        }
    }

    public void addBomb() {
        gameBoard.addBomb();
    }

    public void updateBombs() {

        //TODO colition
        for (int i=0;i<gameBoard.getBombs().size();i++){
            if (gameBoard.getBombs().get(i).getY() >= 800){
                gameBoard.removeBombByIndex(i);
            }
        }
    }

    public void updateBoss() {
        gameBoard.getBoss().getSprites().get(0).update(1/60.0);
        for (int i=0;i<gameBoard.getBoss().getSprites().size();i++){
            gameBoard.getBoss().getSprites().get(i).update(1/60.0);
            gameBoard.getBoss().getSprites().get(i).mirrorMove();
        }
    }

    public void updateMiniBoss(){
        ArrayList<MiniBoss> miniBossArrayList = gameBoard.getMiniBoss();
        for (int i=0;i<gameBoard.getMiniBoss().size();i++){
            //TODO colition
            if (gameBoard.getMiniBoss().get(i).getX()  < 0){
                gameBoard.removeMiniBossByIndex(i);
            }
        }
    }

    public void addMiniBoss(){
        Random random = new Random();
        int y = random.nextInt(200,600);
        MiniBoss miniBoss = new MiniBoss(1000,y,0,0);
        gameBoard.addMiniBoss(miniBoss);
    }
}
