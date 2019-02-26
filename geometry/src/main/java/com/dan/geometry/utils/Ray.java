package com.dan.geometry.utils;

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

    public Vector getDirection() {
        return direction;
    }

    public String toString() {
        return "[" + origin + " -> " + direction + "]";
    }

}
