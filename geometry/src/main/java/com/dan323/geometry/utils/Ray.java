package com.dan323.geometry.utils;

public class Ray {

    private Point origin;
    private Vector direction;

    public Ray(Point origin, Vector direction) {
        super();
        this.origin = origin;
        this.direction = direction.normalize();
    }

    public Point getOrigin() {
        return origin;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }

    public Vector getDirection() {
        return direction;
    }

    public void setDirection(Vector direction) {
        this.direction = direction.normalize();
    }

    public String toString() {
        return "[" + origin + " -> " + direction + "]";
    }

}
