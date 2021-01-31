package com.dan.geometry.hit;

import com.dan.geometry.utils.Ray;

import static java.lang.Math.abs;

public class PlaneHitInfo extends HitInfo {

    private boolean isParallelNot;
    private double distance;

    private PlaneHitInfo(Ray ray) {
        super(ray);
    }

    public PlaneHitInfo(Ray ray, double d, double e) {
        this(ray);
        setValues(d, e);
    }

    @Override
    public boolean isHit() {
        return isParallelNot && distance >= 0;
    }

    private void setValues(double d, double e) {
        this.distance = d / e;
        this.isParallelNot = (abs(e) > 10E-9);
    }

    @Override
    public double getDistance() {
        return distance;
    }
}
