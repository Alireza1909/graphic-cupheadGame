package com.example.apcupheadazmayeshi;

import com.example.apcupheadazmayeshi.Model.Coordinate;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Sprite extends ImageView {


    private Image image;
    private ArrayList<Image> images;


    private Rectangle rectangle;
    private double vX;
    private double vY;
    private boolean isMoving;

    public Sprite(String URL) {
        image = new Image(URL);
    }

    public Sprite(String URL, int vX, int vY) {
        image = new Image(URL);
        this.vX = vX;
        this.vY = vY;
    }

    public void setImages(ArrayList<Image> images){
        this.images = images;
    }


    public void setMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }

    public void setCoordinate(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public void update(double deltaT) {
        if (isMoving) {
            rectangle.setX(deltaT * vX + rectangle.getX());
            rectangle.setY(deltaT * vY + rectangle.getY());
        }
    }

    public void setImage(double width,double height){
        setFitHeight(height);
        setFitWidth(width);
    }

    public void render(GraphicsContext context) {
        context.save();

        context.translate(rectangle.getX(), rectangle.getY());
        context.rotate(0);
        context.translate(-this.image.getWidth() / 2, -this.image.getHeight() / 2);
        context.drawImage(this.image, 0, 0);
        context.restore();
    }

    public void updateUp(double deltaT) {
        rectangle.setY(rectangle.getY() - deltaT * vY);
        if (rectangle.getY() > 800) rectangle.setY(799);
        if (rectangle.getY() < 0) rectangle.setY(0);
    }

    public void updateDown(double deltaT) {
        rectangle.setY(rectangle.getY() + deltaT * vY);
        if (rectangle.getY() > 800) rectangle.setY(799);
        if (rectangle.getY() < 0) rectangle.setY(0);
    }

    public void updateRight(double deltaT) {
        rectangle.setX(rectangle.getX() + deltaT * vX);
        if (rectangle.getX() > 1000) rectangle.setX(999);
        if (rectangle.getX() < 0) rectangle.setY(0);
    }

    public void updateLeft(double deltaT) {
        rectangle.setX(rectangle.getX() - deltaT * vX);
        if (rectangle.getX() > 1000) rectangle.setX(999);
        if (rectangle.getX() < 0) rectangle.setX(0);
    }

    public void mirrorMove(){
        if (rectangle.getX() >= 1000 && this.vX > 0){
            this.vX = - this.vX;
        }
        else if (rectangle.getX() < 0 && this.vX < 0){
            this.vX = - this.vX;
        }

        if (rectangle.getY() >= 800 && this.vY > 0){
            this.vY = - this.vY;
        }
        else if (rectangle.getY() < 0 && this.vY < 0){
            this.vY = - this.vY;
        }
    }
}
