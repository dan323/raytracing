package com.dan.geometry.phong.light;

import com.dan.geometry.phong.material.Color;
import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.PointUtils;
import com.dan.geometry.utils.Vector;
import com.dan.geometry.objects.GeometricObject;

public class PointLight extends Light {
	
	private Point point;
	
	public PointLight(Point p, Color inte,double watt) {
		point=p;
		setIntensity(inte);
		setWatt(watt);
	}

	@Override
	public Vector getDirectionFromPoint(Point p, GeometricObject ob) {
		Vector sol= PointUtils.toPoint(p, point);
		return sol.normalize();
	}

}
