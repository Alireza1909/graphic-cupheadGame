package com.example.apcupheadazmayeshi.Model;

import com.example.apcupheadazmayeshi.View.Sprite;
import javafx.scene.shape.Rectangle;

public class Bomb extends Rectangle {
    private Sprite sprite;

    public Bomb(double x, double y) {
        super(x, y, 25, 25);
        sprite = new Sprite("C:\\Users\\Asus\\IdeaProjects\\APCUPHEADAzmayeshi\\src\\main\\resources\\com\\example\\apcupheadazmayeshi\\Pictures\\mm_shmup_ex_bullet_0001.png", 0, 200);
        sprite.setCoordinate(this);
        sprite.setMoving(true);
        sprite.setImage(30, 20);
    }

    public Sprite getSprite() {
        return this.sprite;
    }

    public boolean intersects(Rectangle rectangle) {
        if (getX() - 59.0 / 2 > rectangle.getX() + rectangle.getWidth() / 2
                || getX() + 59.0 / 2 < rectangle.getX() - rectangle.getWidth() / 2) {
            return false;
        }
        if (getY() - 35.0 > rectangle.getY() + rectangle.getHeight() / 2
                || getY() + 35.0 < rectangle.getY() - rectangle.getHeight() / 2) {
            return false;
        }
        return true;
    }
}
