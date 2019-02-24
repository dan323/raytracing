package com.dan323.geometry.hit;

import com.dan323.geometry.utils.Ray;

/**
 * Implementation of the helper class for hit calculations for the sphere
 */
public class SphereHitInfo extends HitInfo {

    private double distance;
    private double radical;

    protected SphereHitInfo(Ray ray) {
        super(ray);
    }

    public SphereHitInfo(Ray ray, double b, double c) {
        this(ray);
        setValues(b, c);
    }

    private void setValues(double b, double c) {
        this.radical = b * b - 4 * c;
        double min = (-b - Math.sqrt(radical))/2;
        this.distance = min > 0 ? min : (-b + Math.sqrt(radical))/2;
    }

    public boolean isHit() {
        return radical >= 0 && distance >= 0;
    }

    public double getDistance() {
        return distance;
    }
}
