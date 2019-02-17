package com.dan323.geometry;

public class Vector {

	private double x,y,z;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}
	
	public Vector(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double dot(Vector v) {
		return x*v.x+y*v.y+z*v.z;
	}
	
	public Vector cross(Vector v) {
		return new Vector(y*v.z-z*v.y,v.x*z-x*v.z,x*v.y-y*v.x);
	}
	
	public double norm() {
		return Math.sqrt(x*x+y*y+z*z);
	}
	
	public Vector normalize() {
		return scale(1/norm());
	}

	public Vector add(Vector c) {
		return new Vector(x+c.x,y+c.y,z+c.z);
	}
	
	public Vector scale(double e) {
		return new Vector(x*e,y*e,z*e);
	}
	
	public String toString() {
		return "{"+x+","+y+","+z+"}";
	}
}
