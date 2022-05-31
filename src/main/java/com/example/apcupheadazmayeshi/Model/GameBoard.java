package com.example.apcupheadazmayeshi.Model;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class GameBoard {


    private int level;
    private Boss boss;
    private CupHeadPlane cupHeadPlane;
    private ArrayList<Bullet> bullets;
    private ArrayList<Bomb> bombs;
    private ArrayList<MiniBoss> miniBossArrayList;
    private ArrayList<BirdBullet> eggs;


    public GameBoard(int level) {
        this.level = level;
        cupHeadPlane = new CupHeadPlane(300,100,30,20,level);
        boss = new Boss(800,300,30,50);
        bullets = new ArrayList<>();
        bombs = new ArrayList<>();
        miniBossArrayList = new ArrayList<>();
        eggs = new ArrayList<>();
    }


    public CupHeadPlane getCupHead() {
        return this.cupHeadPlane;
    }

    public void addBullet() {
        Bullet bullet = new Bullet(cupHeadPlane.getX(),cupHeadPlane.getY());
        bullets.add(bullet);
    }

    public ArrayList<Bullet> getBullets() {
        return this.bullets;
    }

    public void removeBullet(Bullet bullet) {
        this.bullets.remove(bullet);
    }

    public void addBomb() {
        Bomb bomb = new Bomb(cupHeadPlane.getX(),cupHeadPlane.getY());
        this.bombs.add(bomb);
    }

    public ArrayList<Bomb> getBombs() {
        return this.bombs;
    }

    public void removeBomb(Bomb bomb) {
        this.bombs.remove(bomb);
    }

    public Boss getBoss() {
        return this.boss;
    }

    public void removeBombByIndex(int index) {
        this.bombs.remove(index);
    }

    public void removeBulletByIndex(int index){
        this.bullets.remove(index);
    }

    public ArrayList<MiniBoss> getMiniBoss() {
        return this.miniBossArrayList;
    }

    public void addMiniBoss(MiniBoss miniBoss){
        this.miniBossArrayList.add(miniBoss);
    }

    public void removeMiniBossByIndex(int i) {
        this.miniBossArrayList.remove(i);
    }

    public void addEgg(BirdBullet birdBullet){
        this.eggs.add(birdBullet);
    }

    public void removeEggByIndex(int i){
        this.eggs.remove(i);
    }

    public ArrayList<BirdBullet> getEggs() {
        return eggs;
    }
}
