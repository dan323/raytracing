package com.dan.geometry.hit;

import com.dan.geometry.objects.GeometricObject;
import com.dan.geometry.utils.Ray;

/**
 * This abstract class implements the expected behaviour of a geometric object by the use of a {@link HitInfo}
 */
public abstract class HitInfoGeometricObject implements GeometricObject {

    private HitInfo hitInfo;

    protected HitInfo getHitInfo() {
        return hitInfo;
    }

    protected void setHitInfo(HitInfo hitInfo) {
        this.hitInfo = hitInfo;
    }

    public boolean hits(Ray ray) {
        updateHitInfo(ray);
        return hitInfo.isHit();
    }

    public double distance(Ray ray) {
        updateHitInfo(ray);
        return hitInfo.getDistance();
    }

    protected abstract void updateHitInfo(Ray ray);
}
