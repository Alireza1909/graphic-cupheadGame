package com.example.apcupheadazmayeshi.Model;

import com.example.apcupheadazmayeshi.Sprite;
import javafx.scene.shape.Rectangle;

public class Bullet extends Rectangle {

    private Sprite sprite;

    public Bullet(double x, double y) {
        super(x, y, 30, 20);
        sprite = new Sprite("C:\\Users\\Asus\\IdeaProjects\\APCUPHEADAzmayeshi\\src\\main\\resources\\com\\example\\apcupheadazmayeshi\\Pictures\\bullet.png", 300, 0);
        sprite.setCoordinate(this);
        sprite.setMoving(true);
        sprite.setImage(30, 20);
    }

    public Sprite getSprite() {
        return this.sprite;
    }

    public boolean intersects(Rectangle rectangle) {
        if (getX() - 15 > rectangle.getX() + rectangle.getWidth() / 2
                || getX() + 15 < rectangle.getX() - rectangle.getWidth() / 2) {
            return false;
        }
        if (getY() - 25.0 / 2 > rectangle.getY() + rectangle.getHeight() / 2
                || getY() + 25.0 / 2 < rectangle.getY() - rectangle.getHeight() / 2) {
            return false;
        }
        return true;
    }
}
