package com.dan.geometry.utils;

public final class PointUtils {

    private PointUtils() {
    }

    /**
     * @see Point#translate(Vector)
     */
    public static Point translate(Point o, Vector t) {
        return o.translate(t);
    }

    /**
     * @see Point#toPoint(Point)
     */
    public static Vector toPoint(Point o, Point d) {
        return o.toPoint(d);
    }

    /**
     * Computes the distance between two points
     *
     * @param p1 one of the points
     * @param p2 one of the points
     * @return the distance between {@code p1} and {@code p2}
     */
    public static double distance(Point p1, Point p2) {
        return toPoint(p1, p2).norm();
    }
}
