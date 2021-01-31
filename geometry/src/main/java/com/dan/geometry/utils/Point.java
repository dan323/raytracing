package com.dan.geometry.utils;

import com.dan.geometry.utils.abstraction.XYZElement;

public class Point extends XYZElement {

    public Point(double x, double y, double z) {
        super(x, y, z);
    }

    /**
     * Constructs the vector between two points
     *
     * @param p final point
     * @return v=this->p
     */
    Vector toPoint(Point p) {
        return new Vector(p.getX() - getX(), p.getY() - getY(), p.getZ() - getZ());
    }

    @Override
    public boolean equals(Object ob) {
        return (ob instanceof Point) && super.equals(ob);
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 2;
    }

    /**
     * Translate this {@link Point} through a {@link Vector}
     *
     * @param v vector of translation
     * @return the resulting point {@code q=this+v}
     */
    Point translate(Vector v) {
        return new Point(getX() + v.getX(), getY() + v.getY(), getZ() + v.getZ());
    }
}
