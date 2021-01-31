package com.dan.geometry.objects;

import com.dan.geometry.hit.HitInfo;
import com.dan.geometry.utils.*;

import java.util.Optional;

/**
 * This class represents a triangle, a very simple object used for constructed complicated more complicated 3D objects.
 * <p>
 * We do not make use of the helper class {@link HitInfo} as the distance is computed from the {@link Plane},
 * which already has one such class.
 */
public class Triangle implements GeometricObject {

    private Plane containingPlane;
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        containingPlane = new Plane(a, VectorUtils.cross(PointUtils.toPoint(a, b), PointUtils.toPoint(a, c)));
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean hits(Ray ray) {
        if (containingPlane.hits(ray)) {
            Optional<Point> hitOpt = getHitPoint(ray);
            if (hitOpt.isPresent()) {
                Point hit = hitOpt.get();
                return isPointInSimplex(hit, a, b, c);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean isPointInSimplex(Point hit, Point a, Point b, Point c) {
        Vector pa = PointUtils.toPoint(a, hit);
        Vector ba = PointUtils.toPoint(a, b);
        Vector ca = PointUtils.toPoint(a, c);
        double caca = VectorUtils.dot(ca, ca);
        double baba = VectorUtils.dot(ba, ba);
        double baca = VectorUtils.dot(ba, ca);
        double bapa = VectorUtils.dot(ba, pa);
        double capa = VectorUtils.dot(pa, ca);
        double inv = caca * baba - baca * baca;
        double x = (baba * capa - bapa * baca) / inv;
        double y = (caca * bapa - capa * baca) / inv;
        return x >= 0 && y >= 0 && x + y <= 1;
    }

    public double distance(Ray ray) {
        return containingPlane.distance(ray);
    }

    public Vector getNormalAt(Point p) {
        return containingPlane.getNormalAt(p);
    }
}
