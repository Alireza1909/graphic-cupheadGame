package com.example.apcupheadazmayeshi.Model;

import com.example.apcupheadazmayeshi.View.Sprite;
import javafx.scene.shape.Rectangle;

public class CupHeadPlane extends Rectangle {

    private double HP;
    private double damageRate;
    private double destructionRate;
    private Sprite sprite;
    private boolean isBlinking;
    private int score;

    public CupHeadPlane(int x, int y, int vX, int vY, int level) {
        super(x, y, vX, vY);
        switch (level) {
            case 1:
                HP = 10;
                damageRate = 0.5;
                destructionRate = 1.5;
                break;
            case 3:
                HP = 2;
                damageRate = 1.5;
                destructionRate = 0.5;
                break;
            default:
                HP = 5;
                damageRate = 1;
                destructionRate = 1;
                break;
        }
        sprite = new Sprite("C:\\Users\\Asus\\IdeaProjects\\APCUPHEADAzmayeshi\\src\\main\\resources\\com\\example\\apcupheadazmayeshi\\Pictures\\mugman_plane_idle_straight_0001.png", 300, 200);
        //setWidth(50);setHeight(30);
        sprite.setCoordinate(this);
    }

    public void changePosition(int dx, int dy) {
        this.setX(getX() + dx);
        this.setY(getY() + dy);
    }

    public Sprite getSprite() {
        return this.sprite;
    }

    public double getHP() {
        return HP;
    }

    public Integer getXP() {
        return score;
    }

    public double getDestructionRate() {
        return this.destructionRate;
    }

    public void addScore(int addingScore) {
        this.score += addingScore;
    }

    public void costHP() {
        this.HP--;
    }

    public boolean intersects(Rectangle rectangle) {
        if (getX() - getWidth()/2 > rectangle.getX() + rectangle.getWidth() / 2
                || getX() + getWidth() / 2 < rectangle.getX() - rectangle.getWidth() / 2) {
            return false;
        }
        if (getY() - getHeight() / 2 > rectangle.getY() + rectangle.getHeight() / 2
                || getY() + getHeight()/2 < rectangle.getY() - rectangle.getHeight() / 2) {
            return false;
        }
        return true;
    }
}
