package com.dan323.geometry.utils;

import com.dan323.geometry.utils.abstraction.XYZElement;

public class Point extends XYZElement {

	public Point(double x, double y, double z) {
		super(x,y,z);
	}
	
	public Vector toPoint(Point p) {
		return new Vector(p.getX()-getX(),p.getY()-getY(),p.getZ()-getZ());
	}

	@Override
	public boolean equals(Object ob){
		return (ob instanceof Point) && super.equals(ob);
	}

	@Override
	public int hashCode(){
		return super.hashCode()*2;
	}

	public Point translate(Vector v) {
		return new Point(getX()+v.getX(),getY()+v.getY(),getZ()+v.getZ());
	}
}
