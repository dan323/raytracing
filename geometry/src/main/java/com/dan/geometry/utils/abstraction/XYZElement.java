package com.dan.geometry.utils.abstraction;

public abstract class XYZElement {
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

    @Override
    public boolean equals(Object ob){
        return (ob instanceof XYZElement) && ((XYZElement)ob).equalsElements(x,y,z);
    }

    private boolean equalsElements(double x, double y, double z){
        return this.x==x && this.y==y && this.z==z;
    }

    @Override
    public int hashCode(){
        return (int)(x*100+y*10+z);
    }
}
