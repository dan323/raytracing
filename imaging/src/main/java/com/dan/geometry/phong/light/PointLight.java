package com.dan.geometry.phong.light;

import com.dan.geometry.phong.material.Color;
import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.PointUtils;
import com.dan.geometry.utils.Vector;
import com.dan.geometry.objects.GeometricObject;

public class PointLight extends Light {
	
	private Point point;
	
	public PointLight(Point p, Color inte) {
		point=p;
		setIntensity(inte);
	}

	@Override
	public Vector getDirectionToPoint(Point p, GeometricObject ob) {
		Vector sol= PointUtils.toPoint(point, p);
		return sol.normalize();
	}

}
