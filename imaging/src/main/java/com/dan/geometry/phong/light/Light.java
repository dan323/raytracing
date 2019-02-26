package com.dan.geometry.phong.light;


import com.dan.geometry.phong.material.Color;
import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.Vector;
import com.dan.geometry.objects.GeometricObject;


public abstract class Light {
	
	private Color intensity;
	
	public abstract Vector getDirectionToPoint(Point p, GeometricObject ob);

	public Color getIntensity() {
		return intensity;
	}

	void setIntensity(Color intensity) {
		this.intensity = intensity;
	}

}
