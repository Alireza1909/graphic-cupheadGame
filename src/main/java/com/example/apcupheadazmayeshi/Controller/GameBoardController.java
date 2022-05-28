package com.example.apcupheadazmayeshi.Controller;

import com.example.apcupheadazmayeshi.Model.Bomb;
import com.example.apcupheadazmayeshi.Model.Bullet;
import com.example.apcupheadazmayeshi.Model.GameBoard;
import com.example.apcupheadazmayeshi.Model.MiniBoss;

import java.util.ArrayList;
import java.util.Random;

public class GameBoardController {

    public static GameBoard gameBoard;

    public GameBoardController(GameBoard gameBoard) {
        setGameBoard(gameBoard);
    }

    public static void setGameBoard(GameBoard gameBoard1) {
        gameBoard = gameBoard1;
    }

    public void addBullet() {
        gameBoard.addBullet();
    }


    public void updateBullets() {
        //TODO colition
        for (int i = 0; i < gameBoard.getBullets().size(); i++) {
            if (gameBoard.getBullets().get(i).intersects(gameBoard.getBoss())) {
                gameBoard.removeBulletByIndex(i);
                gameBoard.getBoss().reduceHP(gameBoard.getCupHead().getDestructionRate());
                gameBoard.getCupHead().addScore(15);
                continue;
            }
            if (gameBoard.getBullets().get(i).getX() >= 1000) {
                gameBoard.removeBulletByIndex(i);
                continue;
            }
            for (int j = 0; j < gameBoard.getMiniBoss().size(); j++) {
                if (gameBoard.getBullets().get(i).intersects(gameBoard.getMiniBoss().get(j))) {
                    gameBoard.getMiniBoss().get(j).reduceHP();
                    gameBoard.removeBulletByIndex(i);
                    break;
                }
            }
        }
    }

    public void addBomb() {
        gameBoard.addBomb();
    }

    public void updateBombs() {
        //TODO colition
        for (int i = 0; i < gameBoard.getBombs().size(); i++) {
            //intersect boss and miniboss
            if (gameBoard.getBombs().get(i).intersects(gameBoard.getBoss())) {
                gameBoard.removeBombByIndex(i);
                gameBoard.getBoss().reduceHP(2 * gameBoard.getCupHead().getDestructionRate());
                gameBoard.getCupHead().addScore(20);
                continue;
            }
            if (gameBoard.getBombs().get(i).getY() >= 800) {
                gameBoard.removeBombByIndex(i);
                continue;
            }
            for (int j = 0; j < gameBoard.getMiniBoss().size(); j++) {
                if (gameBoard.getBombs().get(i).intersects(gameBoard.getMiniBoss().get(j))) {
                    gameBoard.removeMiniBossByIndex(j);
                    gameBoard.removeBombByIndex(i);
                    gameBoard.getCupHead().addScore(10);
                    break;
                }
            }
        }
    }

    public void updateBoss() {
        gameBoard.getBoss().getSprites().get(0).update(1 / 60.0);
        for (int i = 0; i < gameBoard.getBoss().getSprites().size(); i++) {
            gameBoard.getBoss().getSprites().get(i).update(1 / 60.0);
            gameBoard.getBoss().getSprites().get(i).mirrorMove();
        }
    }

    public void updateMiniBoss() {
        for (int i = 0; i < gameBoard.getMiniBoss().size(); i++) {
            if (gameBoard.getMiniBoss().get(i).getHP() <= 0) {
                gameBoard.removeMiniBossByIndex(i);
                gameBoard.getCupHead().addScore(10);
            } else if (gameBoard.getMiniBoss().get(i).getX() < 0) {
                gameBoard.removeMiniBossByIndex(i);
            }
        }
    }

    public void addMiniBoss() {
        Random random = new Random();
        int y = random.nextInt(200, 600);
        MiniBoss miniBoss = new MiniBoss(1000, y, 0, 0);
        gameBoard.addMiniBoss(miniBoss);
    }

    public boolean updateCupHead(){
        boolean answer = false;
        if (gameBoard.getCupHead().intersects(gameBoard.getBoss())){
            gameBoard.getCupHead().costHP();
            answer = true;
        }
        for (int i=0;i<gameBoard.getMiniBoss().size();i++){
            if (gameBoard.getCupHead().intersects(gameBoard.getMiniBoss().get(i))){
                if (!answer) gameBoard.getCupHead().costHP();
                answer = true;
                gameBoard.removeMiniBossByIndex(i);
            }
        }
        return answer;
    }
//    public void overlapChecking() {
//        for
//    }


}
