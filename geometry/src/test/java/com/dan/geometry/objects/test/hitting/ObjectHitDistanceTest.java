package com.dan.geometry.objects.test.hitting;

import com.dan.geometry.objects.GeometricObject;
import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.PointUtils;
import com.dan.geometry.utils.Ray;
import com.dan.geometry.utils.Vector;
import org.junit.jupiter.api.Assertions;

import java.util.Optional;
import java.util.Random;

public abstract class ObjectHitDistanceTest {

    private static final Random random = new Random();
    private static GeometricObject object;

    static GeometricObject getObject() {
        return object;
    }

    static void setObject(GeometricObject plane) {
        object = plane;
    }

    Optional<Point> hitObject() throws AssertionError {
        Point or = new Point(random.nextDouble(), random.nextDouble(), random.nextDouble());
        Vector dir = new Vector(random.nextDouble(), random.nextDouble(), random.nextDouble());
        Ray ray = new Ray(or, dir);
        Optional<Point> returnPoint=Optional.empty();

        if (object.hits(ray)) {
            double t = object.distance(ray);
            Point hit = PointUtils.translate( ray.getOrigin(),ray.getDirection().scale(t));
            returnPoint=Optional.of(hit);
        }
        return returnPoint;
    }

    void assertHit(Point hit) {
        Assertions.assertTrue(isInObject(hit));
    }

    protected abstract boolean isInObject(Point hit);

}
