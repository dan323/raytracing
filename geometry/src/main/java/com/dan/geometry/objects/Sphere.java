package com.dan.geometry.objects;

import com.dan.geometry.hit.HitInfoGeometricObject;
import com.dan.geometry.hit.SphereHitInfo;
import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.Ray;
import com.dan.geometry.utils.Vector;

import static com.dan.geometry.hit.HitInfo.checkHitInfoActual;
import static com.dan.geometry.utils.PointUtils.toPoint;
import static com.dan.geometry.utils.VectorUtils.dot;

/**
 * Class to define the behaviour of a sphere
 */
public class Sphere extends HitInfoGeometricObject {

    private final Point origin;
    private final double radious;

    public Sphere(Point origin, double radious) {
        this.origin = origin;
        this.radious = radious;
    }

    protected void updateHitInfo(Ray ray) {
        if (checkHitInfoActual(getHitInfo(), ray)) {
            Vector v = toPoint(origin, ray.getOrigin());
            setHitInfo(new SphereHitInfo(ray, 2 * dot(v, ray.getDirection()), dot(v, v) - radious * radious));
        }
    }

    public Vector getNormalAt(Point p) {
        Vector v = toPoint(origin, p);
        v = v.normalize();
        return v;
    }

}
