package com.dan.geometry.utils;

/**
 * Utility class to use vectors
 *
 * @author danco
 */
public final class VectorUtils {

    private VectorUtils() {
        throw new UnsupportedOperationException();
    }

    /**
     * Reflects the vector according to the plane defined by the normal
     * @param incidence vector to reflect
     * @param normal vector perpendicular to the reflection plane
     * @return reflected vector
     */
    public static Vector reflect(Vector incidence, Vector normal) {
        Vector normalNorm = normal.normalize();
        return incidence.add(normalNorm.scale(-2 * incidence.dot(normalNorm)));
    }

    /**
     * Refracts the vector according to a plane, given the coefficients of the materiasl
     * @param incidence vector to refract
     * @param normal vector perpendicular to the relfection plane
     * @param incidenceCoef coefficient of the incidence material
     * @param reflactCoef coefficient of the refracting material
     * @return refracted vector
     */
    public static Vector refract(Vector incidence, Vector normal, double incidenceCoef, double reflactCoef) {
        double etar = incidenceCoef / reflactCoef;
        double dot = normal.dot(incidence);
        double radical = 1 - (1 - dot * dot) * etar * etar;
        if (radical < 0) {
            return Vector.ZERO;
        }
        return normal.scale(-etar * dot + Math.sqrt(radical)).add(incidence.scale(etar)).normalize();
    }

    /**
     * Dot product of 2 vectors
     * @param v1 first input
     * @param v2 second input
     * @return (x1.x2)+(y1.y2)+(z1.z2)
     */
    public static double dot(Vector v1, Vector v2) {
        return v1.dot(v2);
    }

    /**
     * Cross product of 2 vectors
     * @param v1 first input
     * @param v2 second input
     * @return vector perpendicular to both inputs, and a norm product of their norms
     */
    public static Vector cross(Vector v1, Vector v2) {
        return v1.cross(v2);
    }

    /**
     * Add 2 vectors
     * @param v1 first input
     * @param v2 second input
     * @return sum of the inputs
     */
    public static Vector add(Vector v1, Vector v2) {
        return v1.add(v2);
    }

}