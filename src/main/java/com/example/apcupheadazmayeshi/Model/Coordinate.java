package com.example.apcupheadazmayeshi.Model;

import com.example.apcupheadazmayeshi.View.Sprite;

abstract public class Coordinate {
    protected double x;
    protected double y;
    protected double vX;
    protected double vY;
    protected Sprite sprite;
    protected boolean isMoving;

    public Coordinate(double x,double y,double vX,double vY){
        this.x = x;
        this.y = y;
        this.vX = vX;
        this.vY = vY;
        this.isMoving = false;
    }

    public void setMoving(boolean isMoving){
        this.isMoving = isMoving;
    }


    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public Sprite getSprite(){
        return this.sprite;
    }

    public void changeCoordinate(double dx,double dy){
        this.x += dx;
        this.y += dy;
    }

    public void update(){
        if (isMoving) changeCoordinate(vX,vY);
    }

}
