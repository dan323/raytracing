package  com.dan323.geometry.light;

import com.dan323.geometry.utils.Point;
import com.dan323.geometry.utils.Vector;
import com.dan323.geometry.objects.GeometricObject;

public class PointLight extends Light {
	
	private Point p;
	
	public PointLight(Point pp,double inte) {
		setP(pp);
		setIntensity(inte);
	}

	@Override
	public Vector getDirectionToPoint(Point p, GeometricObject ob) {
		Vector sol= p.toPoint(getP());
		return sol.normalize();
	}

	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

}
