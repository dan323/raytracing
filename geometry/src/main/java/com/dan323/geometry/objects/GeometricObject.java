package com.dan323.geometry.objects;

import com.dan323.geometry.utils.Ray;
import com.dan323.geometry.utils.Vector;
import com.dan323.geometry.utils.Point;

/**
 * This interface must be implemented by every geometrical object defined.
 * We are interested in rays hitting objects and the normal at a point in the object.
 */
public interface GeometricObject {

    /**
     * A method that checks if a ray hits the object
     * @param ray to be checked
     * @return true iff the ray hits the object
     */
    boolean hits(Ray ray);

    /**
     * A method that computes the distance the ray had to travel to hit the object
     * @param ray that hits the object
     * @return the distance from the origin of the ray to the hitting point
     */
    double distance(Ray ray);

    /**
     * Normal of the object at a point in it.
     * @param p a point in the object
     * @return the normal at that point
     */
    Vector getNormalAt(Point p);

}
