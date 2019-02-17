package com.dan323.geometry;

public class Point {

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

	public Point(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector toPoint(Point p) {
		return new Vector(p.x-x,p.y-y,p.z-z);
	}
	
	public Point translate(Vector v) {
		return new Point(x+v.getX(),y+v.getY(),z+v.getZ());
	}
	
	public String toString() {
		return "{"+x+","+y+","+z+"}";
	}
}
