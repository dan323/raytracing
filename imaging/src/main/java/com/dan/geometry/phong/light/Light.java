package com.dan.geometry.phong.light;


import com.dan.geometry.phong.material.Color;
import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.Vector;
import com.dan.geometry.objects.GeometricObject;


public abstract class Light {
	
	private Color intensity;
	private double watt=10;
	
	public abstract Vector getDirectionFromPoint(Point p, GeometricObject ob);

	public Color getIntensity() {
		return intensity;
	}

	public double getWatt(){
		return watt;
	}

	void setWatt(double watt){
		this.watt=watt;
	}

	void setIntensity(Color intensity) {
		this.intensity = intensity;
	}

}
