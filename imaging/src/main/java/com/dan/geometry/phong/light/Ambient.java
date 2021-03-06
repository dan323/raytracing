package com.dan.geometry.phong.light;


import com.dan.geometry.phong.material.Color;
import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.Vector;
import com.dan.geometry.objects.GeometricObject;

public class Ambient extends Light {
	
	public Ambient(Color intensity,double watt) {
		setIntensity(intensity);
		setWatt(watt);
	}

	@Override
	public Vector getDirectionFromPoint(Point p, GeometricObject ob) {
		return ob.getNormalAt(p);
	}

}
