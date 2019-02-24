package com.dan323.geometry.utils;

import com.dan323.geometry.utils.abstraction.XYZElement;

public class Vector extends XYZElement {
	
	public Vector(double x, double y, double z) {
		super(x,y,z);
	}
	
	public double dot(Vector v) {
		return getX()*v.getX()+getY()*v.getY()+getZ()*v.getZ();
	}
	
	public Vector cross(Vector v) {
		return new Vector(getY()*v.getZ()-getZ()*v.getY(),v.getX()*getZ()-getX()*v.getZ(),getX()*v.getY()-getY()*v.getX());
	}
	
	public double norm() {
		return Math.sqrt(getX()*getX()+getY()*getY()+getZ()*getZ());
	}

	@Override
	public int hashCode(){
		return super.hashCode()*3;
	}

	@Override
	public boolean equals(Object ob){
		return (ob instanceof Vector) && super.equals(ob);
	}
	
	public Vector normalize() {
		return scale(1/norm());
	}

	public Vector add(Vector c) {
		return new Vector(getX()+c.getX(),getY()+c.getY(),getZ()+c.getZ());
	}
	
	public Vector scale(double e) {
		return new Vector(getX()*e,getY()*e,getZ()*e);
	}
}
