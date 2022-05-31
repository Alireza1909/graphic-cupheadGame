package com.example.apcupheadazmayeshi.Model;

import com.example.apcupheadazmayeshi.View.Sprite;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class MiniBoss extends Rectangle {
    private ArrayList<Sprite> sprites;
    private double HP;

    public MiniBoss(int x, int y, int vX, int vY) {
        super(x, y, 30, 30);
        sprites = new ArrayList<>();
        HP = 2;
        Sprite newSprite1 = new Sprite("C:\\Users\\Asus\\IdeaProjects\\APCUPHEADAzmayeshi\\src\\main\\resources\\com\\example\\apcupheadazmayeshi\\Pictures\\miniboss1.png", -200, 0);
        Sprite newSprite2 = new Sprite("C:\\Users\\Asus\\IdeaProjects\\APCUPHEADAzmayeshi\\src\\main\\resources\\com\\example\\apcupheadazmayeshi\\Pictures\\miniboss2.png", -200, 0);
        Sprite newSprite3 = new Sprite("C:\\Users\\Asus\\IdeaProjects\\APCUPHEADAzmayeshi\\src\\main\\resources\\com\\example\\apcupheadazmayeshi\\Pictures\\miniboss3.png", -200, 0);
        Sprite newSprite4 = new Sprite("C:\\Users\\Asus\\IdeaProjects\\APCUPHEADAzmayeshi\\src\\main\\resources\\com\\example\\apcupheadazmayeshi\\Pictures\\miniboss4.png", -200, 0);
        newSprite1.setCoordinate(this);
        newSprite2.setCoordinate(this);
        newSprite3.setCoordinate(this);
        newSprite4.setCoordinate(this);
        newSprite1.setMoving(true);
        newSprite2.setMoving(true);
        newSprite3.setMoving(true);
        newSprite4.setMoving(true);
        sprites.add(newSprite1);
        sprites.add(newSprite2);
        sprites.add(newSprite3);
        sprites.add(newSprite4);
        sprites.add(newSprite3);
        sprites.add(newSprite2);
    }

    public ArrayList<Sprite> getSprites() {
        return this.sprites;
    }

    public void reduceHP() {
        this.HP--;
    }

    public double getHP() {
        return this.HP;
    }
}
