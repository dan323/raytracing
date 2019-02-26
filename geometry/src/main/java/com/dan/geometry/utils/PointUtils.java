package com.dan.geometry.utils;

public final class PointUtils {

    private PointUtils(){}

    public static Point translate(Point o,Vector t){
        return o.translate(t);
    }

    public static Vector toPoint(Point o,Point d){
        return o.toPoint(d);
    }

    public static double distance(Point origin, Point hit) {
        return toPoint(origin,hit).norm();
    }
}
