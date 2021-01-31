package com.dan.geometry.hit;

import com.dan.geometry.utils.Ray;

/**
 * Helper class to avoid unnecessary recalculations
 */
public abstract class HitInfo {

    private final Ray hittingRay;

    protected HitInfo(Ray ray) {
        hittingRay = ray;
    }

    private Ray getHittingRay() {
        return hittingRay;
    }

    public static boolean checkHitInfoActual(HitInfo hitInfo, Ray ray) {
        return hitInfo == null || hitInfo.getHittingRay() == null || !hitInfo.getHittingRay().equals(ray);
    }

    public abstract boolean isHit();

    public abstract double getDistance();

}
