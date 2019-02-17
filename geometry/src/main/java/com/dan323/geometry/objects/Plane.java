package com.dan323.geometry.objects;

import com.dan323.geometry.Ray;
import com.dan323.geometry.Vector;
import com.dan323.geometry.Point;

public class Plane implements GeometricObject {
	
	private Point p;
	private Vector v;
	
	public Plane(Point p,Vector v) {
		this.p=p;
		this.v=v.normalize();
	}
	
	@Override
	public boolean hits(Ray ray) {
		return ray.getDirection().dot(v)>10E-9;
	}
	
	@Override
	public double distance(Ray ray) {
		Vector aux=ray.getOrigin().toPoint(p);
		double D=aux.dot(v);
		double E=ray.getDirection().dot(v);
		return D/E;
	}

	@Override
	public Vector getNormalAt(Point p) {
		return v;
	}
	
	

}
