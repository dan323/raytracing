package com.dan.geometry.objects;

import com.dan.geometry.hit.HitInfo;
import com.dan.geometry.hit.HitInfoGeometricObject;
import com.dan.geometry.hit.SphereHitInfo;
import com.dan.geometry.utils.*;

/**
 * Class to define the behaviour of a sphere
 */
public class Sphere extends HitInfoGeometricObject {

    private Point origin;
    private double radious;

    public Sphere(Point origin, double radious) {
        this.origin = origin;
        this.radious = radious;
    }

    protected void updateHitInfo(Ray ray) {
        if (HitInfo.checkHitInfoActual(getHitInfo(),ray)) {
            Vector v = PointUtils.toPoint(origin,ray.getOrigin());
            setHitInfo(new SphereHitInfo(ray, 2 * VectorUtils.dot(v,ray.getDirection()), VectorUtils.dot(v,v) - radious * radious));
        }
    }

    public Vector getNormalAt(Point p) {
        Vector v = PointUtils.toPoint(origin,p);
        v = v.normalize();
        return v;
    }

}
