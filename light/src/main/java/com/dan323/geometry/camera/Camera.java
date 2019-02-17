package com.dan323.geometry.camera;


import com.dan323.geometry.Point;
import com.dan323.geometry.Vector;

public class Camera {
	
	private Point origin;
	private Vector up;
	private Vector direction;
	
	private double distance;
	private int width,height;
	
	public Camera(Point or,Vector up,Vector dir,double d) {
		setOrigin(or);
		setDirection(dir.normalize());
		setUp(up.normalize());
		Vector aux=new Vector(getDirection().getX(),getDirection().getY(),getDirection().getZ());
		aux=aux.scale(-this.up.dot(dir));
		aux=aux.add(getUp());
		setUp(aux.normalize());
		setDistance(d);
	}
	
	public Point getOrigin() {
		return origin;
	}
	public void setOrigin(Point origin) {
		this.origin = origin;
	}
	public Vector getUp() {
		return up;
	}
	public void setUp(Vector up) {
		this.up = up;
	}
	public Vector getDirection() {
		return direction;
	}
	public void setDirection(Vector direction) {
		this.direction = direction;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	

}
