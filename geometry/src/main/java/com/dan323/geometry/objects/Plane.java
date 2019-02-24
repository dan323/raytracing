package com.dan323.geometry.objects;

import com.dan323.geometry.hit.HitInfo;
import com.dan323.geometry.hit.HitInfoGeometricObject;
import com.dan323.geometry.hit.PlaneHitInfo;
import com.dan323.geometry.utils.Ray;
import com.dan323.geometry.utils.Vector;
import com.dan323.geometry.utils.Point;

/**
 * Class to define the behaviour of a plane
 */
public class Plane extends HitInfoGeometricObject {
	
	private Point p;
	private Vector v;
	
	public Plane(Point p,Vector v) {
		this.p=p;
		this.v=v.normalize();
	}

	protected void updateHitInfo(Ray ray) {
		if (HitInfo.checkHitInfoActual(getHitInfo(),ray)) {
			setHitInfo(new PlaneHitInfo(ray, ray.getOrigin().toPoint(p).dot(v),ray.getDirection().dot(v)));
		}
	}

	public Vector getNormalAt(Point p) {
		return v;
	}
	
	

}
