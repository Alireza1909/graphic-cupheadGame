package com.example.apcupheadazmayeshi.Model;

import com.example.apcupheadazmayeshi.View.Sprite;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Boss extends Rectangle {

    private ArrayList<BossesKid> kids;
    private ArrayList<BirdBullet> eggs;
    private ArrayList<Sprite> sprites;
    private double HP;

    public Boss(int x, int y, int vX, int vY) {
        super(x, y, 60, 60);
        kids = new ArrayList<>();
        sprites = new ArrayList<>();
        eggs = new ArrayList<>();
        HP = 100.0;
        Sprite newSprite1 = new Sprite("C:\\Users\\Asus\\IdeaProjects\\APCUPHEADAzmayeshi\\src\\main\\resources\\com\\example\\apcupheadazmayeshi\\Pictures\\boss1.png", 0, 30);
        Sprite newSprite2 = new Sprite("C:\\Users\\Asus\\IdeaProjects\\APCUPHEADAzmayeshi\\src\\main\\resources\\com\\example\\apcupheadazmayeshi\\Pictures\\boss2.png", 0, 30);
        Sprite newSprite3 = new Sprite("C:\\Users\\Asus\\IdeaProjects\\APCUPHEADAzmayeshi\\src\\main\\resources\\com\\example\\apcupheadazmayeshi\\Pictures\\boss3.png", 0, 30);
        Sprite newSprite4 = new Sprite("C:\\Users\\Asus\\IdeaProjects\\APCUPHEADAzmayeshi\\src\\main\\resources\\com\\example\\apcupheadazmayeshi\\Pictures\\boss4.png", 0, 30);
        Sprite newSprite5 = new Sprite("C:\\Users\\Asus\\IdeaProjects\\APCUPHEADAzmayeshi\\src\\main\\resources\\com\\example\\apcupheadazmayeshi\\Pictures\\boss5.png", 0, 30);
        Sprite newSprite6 = new Sprite("C:\\Users\\Asus\\IdeaProjects\\APCUPHEADAzmayeshi\\src\\main\\resources\\com\\example\\apcupheadazmayeshi\\Pictures\\boss6.png", 0, 30);
        newSprite1.setCoordinate(this);
        newSprite2.setCoordinate(this);
        newSprite3.setCoordinate(this);
        newSprite4.setCoordinate(this);
        newSprite5.setCoordinate(this);
        newSprite6.setCoordinate(this);
        newSprite1.setMoving(true);
        newSprite2.setMoving(true);
        newSprite3.setMoving(true);
        newSprite4.setMoving(true);
        newSprite5.setMoving(true);
        newSprite6.setMoving(true);
        sprites.add(newSprite1);
        sprites.add(newSprite2);
        sprites.add(newSprite3);
        sprites.add(newSprite4);
        sprites.add(newSprite5);
        sprites.add(newSprite6);
        sprites.add(newSprite5);
        sprites.add(newSprite4);
        sprites.add(newSprite3);
        sprites.add(newSprite2);
    }

    public void addKid(BossesKid bossesKid) {
        this.kids.add(bossesKid);
    }

    public void removeKid(BossesKid bossesKid) {
        this.kids.remove(bossesKid);
    }

    public ArrayList<Sprite> getSprites() {
        return this.sprites;
    }

    public double getHP() {
        return HP;
    }

    public void reduceHP(double destructionRate) {
        this.HP -= destructionRate;
    }
}
