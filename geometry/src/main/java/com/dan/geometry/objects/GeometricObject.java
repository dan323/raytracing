package com.dan.geometry.objects;

import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.Ray;
import com.dan.geometry.utils.Vector;

import java.util.Optional;

import static com.dan.geometry.utils.PointUtils.translate;

/**
 * This interface must be implemented by every geometrical object defined.
 * We are interested in rays hitting objects and the normal at a point in the object.
 */
public interface GeometricObject {

    /**
     * A method that checks if a ray hits the object
     *
     * @param ray to be checked
     * @return true iff the ray hits the object
     */
    boolean hits(Ray ray);

    /**
     * A method that computes the distance the ray had to travel to hit the object
     *
     * @param ray that hits the object
     * @return the distance from the origin of the ray to the hitting point
     */
    double distance(Ray ray);

    /**
     * Normal of the object at a point in it.
     *
     * @param p a point in the object
     * @return the normal at that point
     */
    Vector getNormalAt(Point p);

    /**
     * Computation of the hit {@link Point} from {@code ray} into the geometric shape
     *
     * @param ray the hitting ray
     * @return the hitting point
     */
    default Optional<Point> getHitPoint(Ray ray) {
        double dist = distance(ray);
        if (dist>=0){
            return Optional.of(translate(ray.getOrigin(), ray.getDirection().scale(distance(ray))));
        } else {
            return Optional.empty();
        }
    }
}
