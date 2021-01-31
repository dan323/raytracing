package com.dan.geometry.utils.abstraction;

/**
 * Abstract class for a (x,y,z) tuple
 */
public abstract class XYZElement {

    private static final double DELTA = 10E-5;
    private double x;
    private double y;
    private double z;

    public XYZElement(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "{" + x + "," + y + "," + z + "}";
    }

    /**
     * Check of equality considering rounding errors
     * @param ob object to compare with
     * @return true if the object is an {@link XYZElement} with each component near the value of each component of the current object
     */
    @Override
    public boolean equals(Object ob){
        return (ob instanceof XYZElement) && ((XYZElement)ob).equalsElements(x,y,z);
    }

    private boolean equalsElements(double x, double y, double z){
        return Math.abs(this.x-x)<DELTA && Math.abs(this.y-y)<DELTA && Math.abs(this.z-z)<DELTA;
    }

    @Override
    public int hashCode(){
        return (int)(x*100+y*10+z);
    }
}
