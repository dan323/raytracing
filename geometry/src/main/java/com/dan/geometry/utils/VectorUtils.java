package com.dan.geometry.utils;

public final class VectorUtils {

    private VectorUtils(){}

    public static Vector reflect(Vector incidence, Vector normal){
        return incidence.add(normal.scale(-2*incidence.dot(normal)));
    }

    public static Vector refract(Vector incidence, Vector normal, double incidenceCoef,double reflactCoef){
        double etar=incidenceCoef/reflactCoef;
        double dot=normal.dot(incidence);
        double radical=1-(1-dot*dot)*etar*etar;
        if (radical<0){
            return Vector.ZERO;
        }
        return normal.scale(-etar*dot+Math.sqrt(radical)).add(incidence.scale(etar)).normalize();
    }

    public static double dot(Vector v1,Vector v2){
        return v1.dot(v2);
    }

    public static Vector cross(Vector v1,Vector v2){
        return v1.cross(v2);
    }

    public static Vector add(Vector v1,Vector v2){
        return v1.add(v2);
    }

}
