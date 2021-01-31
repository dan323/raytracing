package com.dan.geometry.objects;

import com.dan.geometry.hit.HitInfoGeometricObject;
import com.dan.geometry.hit.PlaneHitInfo;
import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.Ray;
import com.dan.geometry.utils.Vector;

import static com.dan.geometry.hit.HitInfo.checkHitInfoActual;
import static com.dan.geometry.utils.PointUtils.toPoint;
import static com.dan.geometry.utils.VectorUtils.dot;

/**
 * Class to define the behaviour of a plane
 */
public class Plane extends HitInfoGeometricObject {

    private final Point p;
    private final Vector v;

    public Plane(Point p, Vector v) {
        this.p = p;
        this.v = v.normalize();
    }

    protected void updateHitInfo(Ray ray) {
        if (checkHitInfoActual(getHitInfo(), ray)) {
            setHitInfo(new PlaneHitInfo(ray, dot(toPoint(ray.getOrigin(), p), v), dot(ray.getDirection(), v)));
        }
    }

    public Vector getNormalAt(Point p) {
        return v;
    }

}
