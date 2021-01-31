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

    public Camera(Point origin, Vector up, Vector direction, double distance) {
        this.origin = origin;
        this.direction = direction.normalize();
        this.up = VectorUtils.add(direction.scale(-VectorUtils.dot(up, direction)), up).normalize();
        this.distance = distance;
    }

    public double getFOVV() {
        if (height > 0) {
            return 2 * Math.atan2(height / 2.0, distance);
        } else {
            return 0;
        }
    }

    public double getFOVH() {
        if (width > 0) {
            return 2 * Math.atan2(width / 2.0, distance);
        } else {
            return 0;
        }
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
        this.up = VectorUtils.add(getDirection().scale(-VectorUtils.dot(up, direction)), up).normalize();
    }

    public Vector getDirection() {
        return direction;
    }

    public void setDirection(Vector direction) {
        this.direction = direction.normalize();
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
