package com.dan.geometry.objects;

import com.dan.geometry.hit.HitInfo;
import com.dan.geometry.hit.HitInfoGeometricObject;
import com.dan.geometry.hit.PlaneHitInfo;
import com.dan.geometry.utils.*;

/**
 * Class to define the behaviour of a plane
 */
public class Plane extends HitInfoGeometricObject {

    private Point p;
    private Vector v;

    public Plane(Point p, Vector v) {
        this.p = p;
        this.v = v.normalize();
    }

    protected void updateHitInfo(Ray ray) {
        if (HitInfo.checkHitInfoActual(getHitInfo(), ray)) {
            setHitInfo(new PlaneHitInfo(ray, VectorUtils.dot(PointUtils.toPoint(ray.getOrigin(), p), v), VectorUtils.dot(ray.getDirection(), v)));
        }
    }

    public Vector getNormalAt(Point p) {
        return v;
    }

}
