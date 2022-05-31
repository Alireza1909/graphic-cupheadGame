package com.example.apcupheadazmayeshi.Model;

import com.example.apcupheadazmayeshi.View.Sprite;
import javafx.scene.shape.Rectangle;

public class BirdBullet extends Rectangle {

    private Sprite sprite;

    public BirdBullet(double x, double y) {
        super(x, y, 60, 40);
        sprite = new Sprite("C:\\Users\\Asus\\IdeaProjects\\APCUPHEADAzmayeshi\\src\\main\\resources\\com\\example\\apcupheadazmayeshi\\Pictures\\bird_bullet_0002.png", -300, 0);
        sprite.setCoordinate(this);
        sprite.setMoving(true);
        sprite.setImage(30, 20);
    }

    public Sprite getSprite() {
        return this.sprite;
    }

    public boolean intersects(Rectangle rectangle) {
        if (getX() - 30 > rectangle.getX() + rectangle.getWidth() / 2
                || getX() + 30 < rectangle.getX() - rectangle.getWidth() / 2) {
            return false;
        }
        if (getY() - 20 > rectangle.getY() + rectangle.getHeight() / 2
                || getY() + 20 < rectangle.getY() - rectangle.getHeight() / 2) {
            return false;
        }
        return true;
    }
}
