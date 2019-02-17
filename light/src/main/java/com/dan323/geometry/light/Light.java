package com.dan323.geometry.light;


import com.dan323.geometry.Point;
import com.dan323.geometry.Vector;
import com.dan323.geometry.objects.GeometricObject;


public abstract class Light {
	
	private double intensity;
	
	public abstract Vector getDirectionToPoint(Point p, GeometricObject ob);

	public double getIntensity() {
		return intensity;
	}

	public void setIntensity(double intensity) {
		this.intensity = intensity;
	}

}
