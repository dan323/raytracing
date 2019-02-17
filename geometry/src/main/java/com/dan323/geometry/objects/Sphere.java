package com.dan323.geometry.objects;

import com.dan323.geometry.Point;
import com.dan323.geometry.Ray;

import com.dan323.geometry.Vector;

public class Sphere implements GeometricObject {

    private Point or;
    private double rad;

    private HitInfo hitInfo;

    public Point getOr() {
        return or;
    }

    public void setOr(Point or) {
        this.or = or;
        hitInfo=new HitInfo();
    }

    public double getRad() {
        return rad;
    }

    public void setRad(double rad) {
        this.rad = rad;
        hitInfo=new HitInfo();
    }

    private class HitInfo {

        private double a, b, c;
        private Ray hittingRay;

        public HitInfo(){
            hittingRay=null;
        }

        public HitInfo(Ray ray,double a,double b,double c){
            setHittingRay(ray);
            setValues(a,b,c);
        }

        public Ray getHittingRay() {
            return hittingRay;
        }

        public void setHittingRay(Ray hittingRay) {
            this.hittingRay = hittingRay;
        }

        public void setValues(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public boolean isHit(){
            return b*b-4*c>=0;
        }

        public double getDistance(){
            return (-b - Math.sqrt(b * b - 4 * c)) / (2 * a);
        }

    }

    public Sphere(Point or, double rad) {
        super();
        this.or = or;
        this.rad = rad;
        hitInfo = new HitInfo();
    }

    @Override
    public boolean hits(Ray ray) {
        Vector v = or.toPoint(ray.getOrigin());
        hitInfo=new HitInfo(ray,ray.getDirection().dot(ray.getDirection()),2 * v.dot(ray.getDirection()),v.dot(v) - rad * rad);
        return hitInfo.isHit();
    }

    @Override
    public double distance(Ray ray) {
        if (hitInfo.getHittingRay()==null || !hitInfo.getHittingRay().equals(ray)) {
            Vector v = or.toPoint(ray.getOrigin());
            hitInfo=new HitInfo(ray,ray.getDirection().dot(ray.getDirection()),2 * v.dot(ray.getDirection()), v.dot(v) - rad * rad);
        }
        return hitInfo.getDistance();
    }

    @Override
    public Vector getNormalAt(Point p) {
        Vector v = or.toPoint(p);
        v = v.normalize();
        return v;
    }

}
