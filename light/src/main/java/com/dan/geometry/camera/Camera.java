package com.dan.geometry.camera;

import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.Vector;
import com.dan.geometry.utils.VectorUtils;

public class Camera {

    private Point origin;
    private Vector up;
    private Vector direction;

    private double distance;
    private int width;
    private int height;

    public Camera(Point or, Vector up, Vector dir, double d) {
        setOrigin(or);
        setDirection(dir.normalize());
        Vector aux = getDirection();
        aux = aux.scale(-VectorUtils.dot(up,dir));
        aux = VectorUtils.add(aux,up);
        setUp(aux.normalize());
        setDistance(d);
    }

    public Point getOrigin() {
        return origin;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }

    public Vector getUp() {
        return up;
    }

    public void setUp(Vector up) {
        this.up = up;
    }

    public Vector getDirection() {
        return direction;
    }

    public void setDirection(Vector direction) {
        this.direction = direction;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


}
