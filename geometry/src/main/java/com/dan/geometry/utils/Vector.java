package com.dan.geometry.utils;

import com.dan.geometry.utils.abstraction.XYZElement;

public class Vector extends XYZElement {

    public Vector(double x, double y, double z) {
        super(x, y, z);
    }

    /**
     * Computes the scalar product of two vectors
     *
     * @param v second vector
     * @return the scalar product {@code this*v}
     */
    double dot(Vector v) {
        return getX() * v.getX() + getY() * v.getY() + getZ() * v.getZ();
    }

    /**
     * Computes the vector product of two vectors
     *
     * @param v second vector
     * @return the vector product {@code this^v}
     */
    Vector cross(Vector v) {
        return new Vector(getY() * v.getZ() - getZ() * v.getY(), v.getX() * getZ() - getX() * v.getZ(), getX() * v.getY() - getY() * v.getX());
    }

    /**
     * The norm of the vector
     *
     * @return the norm {@code Math.sqrt(x*x+y*y+z*z)}
     */
    public double norm() {
        return Math.sqrt(getX() * getX() + getY() * getY() + getZ() * getZ());
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 3;
    }

    /**
     * @param ob object to compare with
     * @see XYZElement#equals(Object)
     */
    @Override
    public boolean equals(Object ob) {
        return (ob instanceof Vector) && super.equals(ob);
    }

    public Vector normalize() {
        return scale(1 / norm());
    }

    Vector add(Vector c) {
        return new Vector(getX() + c.getX(), getY() + c.getY(), getZ() + c.getZ());
    }

    public Vector scale(double e) {
        return new Vector(getX() * e, getY() * e, getZ() * e);
    }

    public static final Vector ZERO = new Vector(0, 0, 0);
    public static final Vector X = new Vector(1, 0, 0);
    public static final Vector Y = new Vector(0, 1, 0);
    public static final Vector Z = new Vector(0, 0, 1);
}
