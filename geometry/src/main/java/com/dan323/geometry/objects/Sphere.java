package com.dan323.geometry.objects;

import com.dan323.geometry.hit.HitInfo;
import com.dan323.geometry.hit.HitInfoGeometricObject;
import com.dan323.geometry.utils.Ray;
import com.dan323.geometry.hit.SphereHitInfo;
import com.dan323.geometry.utils.Point;
import com.dan323.geometry.utils.Vector;

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
            Vector v = origin.toPoint(ray.getOrigin());
            setHitInfo(new SphereHitInfo(ray, 2 * v.dot(ray.getDirection()), v.dot(v) - radious * radious));
        }
    }

    public Vector getNormalAt(Point p) {
        Vector v = origin.toPoint(p);
        v = v.normalize();
        return v;
    }

}
