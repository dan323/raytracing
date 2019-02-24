package com.dan323.geometry.objects.test;

import com.dan323.geometry.objects.GeometricObject;
import com.dan323.geometry.utils.Point;
import com.dan323.geometry.utils.Ray;
import com.dan323.geometry.utils.Vector;
import org.junit.jupiter.api.Assertions;

import java.util.Optional;
import java.util.Random;

public abstract class ObjectHitDistanceTest {

    private static final Random random = new Random();
    private static GeometricObject object;

    protected static GeometricObject getObject() {
        return object;
    }

    protected static void setObject(GeometricObject plane) {
        object = plane;
    }

    protected Optional<Point> hitObject() throws AssertionError {
        Point or = new Point(random.nextDouble(), random.nextDouble(), random.nextDouble());
        Vector dir = new Vector(random.nextDouble(), random.nextDouble(), random.nextDouble());
        Ray ray = new Ray(or, dir);
        Optional<Point> returnPoint=Optional.empty();

        if (object.hits(ray)) {
            double t = object.distance(ray);
            Point hit = ray.getOrigin().translate(ray.getDirection().scale(t));
            returnPoint=Optional.of(hit);
        }
        return returnPoint;
    }

    protected void assertHit(Point hit) {
        Assertions.assertTrue(isInObject(hit));
    }

    protected abstract boolean isInObject(Point hit);

}
