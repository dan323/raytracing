package com.dan.geometry.utils;

public class Ray {

    private final Point origin;
    private final Vector direction;

    public Ray(Point origin, Vector direction) {
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
