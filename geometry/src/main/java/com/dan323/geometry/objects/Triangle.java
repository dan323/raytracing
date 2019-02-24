package com.dan323.geometry.objects;

import com.dan323.geometry.utils.Point;
import com.dan323.geometry.utils.Ray;
import com.dan323.geometry.utils.Vector;

/**
 * This class represents a triangle, a very simple object used for constructed complicated more complicated 3D objects.
 *
 * We do not make use of the helper class {@link com.dan323.geometry.hit.HitInfo} as the distance is computed from the {@link Plane},
 * which already has one such class.
 */
public class Triangle implements GeometricObject {

    private Plane containingPlane;
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c){
        containingPlane=new Plane(a,a.toPoint(b).cross(a.toPoint(c)));
        this.a=a;
        this.b=b;
        this.c=c;
    }

    public boolean hits(Ray ray) {
        if (containingPlane.hits(ray)){
            double d=containingPlane.distance(ray);
            Point hit=ray.getOrigin().translate(ray.getDirection().scale(d));
            return isPointInSimplex(hit,a,b,c);
        }
        return false;
    }

    public static boolean isPointInSimplex(Point hit,Point a,Point b,Point c) {
        Vector pa=a.toPoint(hit);
        Vector ba=a.toPoint(b);
        Vector ca=a.toPoint(c);
        double inv=ca.dot(ca)*ba.dot(ba)-ba.dot(ca)*ba.dot(ca);
        double x=(ba.dot(ba)*ca.dot(pa)-ba.dot(pa)*ba.dot(ca))/inv;
        double y=(ca.dot(ca)*ba.dot(pa)-ca.dot(pa)*ca.dot(ba))/inv;
        return x>=0 && y>=0 && x+y<=1;
    }

    public double distance(Ray ray) {
        return containingPlane.distance(ray);
    }

    public Vector getNormalAt(Point p) {
        return containingPlane.getNormalAt(p);
    }
}
