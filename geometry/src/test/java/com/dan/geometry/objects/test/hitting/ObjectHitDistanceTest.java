package com.dan.geometry.objects.test.hitting;

import com.dan.geometry.objects.GeometricObject;
import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.Ray;
import com.dan.geometry.utils.Vector;

import java.util.Optional;
import java.util.Random;

import static com.dan.geometry.utils.PointUtils.translate;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class ObjectHitDistanceTest {

    private static final Random random = new Random();
    private static GeometricObject object;

    static GeometricObject getObject() {
        return object;
    }

    static void setObject(GeometricObject object) {
        ObjectHitDistanceTest.object = object;
    }

    Optional<Point> hitObject() throws AssertionError {
        Point or = new Point(random.nextDouble(), random.nextDouble(), random.nextDouble());
        Vector dir = new Vector(random.nextDouble(), random.nextDouble(), random.nextDouble());
        return hitObject(or, dir);
    }

    Optional<Point> hitObject(Point or, Vector dir) throws AssertionError {
        Ray ray = new Ray(or, dir);
        Optional<Point> returnPoint = empty();

        if (object.hits(ray)) {
            double t = object.distance(ray);
            Point hit = translate(ray.getOrigin(), ray.getDirection().scale(t));
            returnPoint = of(hit);
        }
        return returnPoint;
    }

    void assertHit(Point hit) {
        assertTrue(isInObject(hit));
    }

    protected abstract boolean isInObject(Point hit);

}
