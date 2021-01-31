package com.dan.geometry.camera.utils;

import com.dan.geometry.phong.material.Color;
import com.dan.geometry.utils.Point;

public class Photon {

    private Color color;
    private Point point;

    public Photon(Color color, Point point) {
        this.color = color;
        this.point = point;
    }

    public void absorbColor(Color color){
        this.color=this.color.multiply(color);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

}
