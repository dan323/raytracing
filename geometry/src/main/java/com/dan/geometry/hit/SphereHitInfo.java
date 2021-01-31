package com.dan.geometry.hit;

import com.dan.geometry.utils.Ray;

import static java.lang.Math.sqrt;

/**
 * Implementation of the helper class for hit calculations for the sphere
 */
public class SphereHitInfo extends HitInfo {

    private double distance;
    private double radical;

    private SphereHitInfo(Ray ray) {
        super(ray);
    }

    public SphereHitInfo(Ray ray, double b, double c) {
        this(ray);
        setValues(b, c);
    }

    private void setValues(double b, double c) {
        this.radical = b * b - 4 * c;
        if (radical < 0){
            this.radical = -1;
            this.distance = -1;
        } else {
            double min = (-b - sqrt(radical)) / 2;
            this.distance = min > 0 ? min : (-b + sqrt(radical)) / 2;
        }
    }

    public boolean isHit() {
        return radical >= 0 && distance >= 0;
    }

    public double getDistance() {
        return distance;
    }
}
