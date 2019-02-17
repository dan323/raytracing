package  com.dan323.geometry.light;


import com.dan323.geometry.Point;
import com.dan323.geometry.Vector;
import com.dan323.geometry.objects.GeometricObject;

public class Ambient extends Light {
	
	public Ambient(double intensity) {
		setIntensity(intensity);
	}

	@Override
	public Vector getDirectionToPoint(Point p, GeometricObject ob) {
		return ob.getNormalAt(p);
	}

}
