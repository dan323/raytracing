package com.dan323.geometry.objects.material.objects;


import com.dan323.geometry.utils.Point;
import com.dan323.geometry.objects.Sphere;
import com.dan323.geometry.objects.material.Color;
import com.dan323.geometry.objects.material.Matte;

public class MatteSphere extends Sphere implements GeometricTexturedObject {

	private Matte material;
	
	public MatteSphere(Point or, double rad, Color c) {
		super(or, rad);
		material=new Matte(c);
	}

	public Color getColor(Point p) {
		return material.getColor();
	}

}
