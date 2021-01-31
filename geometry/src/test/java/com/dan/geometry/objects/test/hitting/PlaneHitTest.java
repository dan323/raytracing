package com.dan.geometry.objects.test.hitting;

import com.dan.geometry.objects.Plane;
import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.Ray;
import com.dan.geometry.utils.Vector;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static com.dan.geometry.utils.PointUtils.toPoint;
import static com.dan.geometry.utils.VectorUtils.dot;
import static java.lang.Math.abs;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PlaneHitTest extends ObjectHitDistanceTest {

    private final static Vector v = (new Vector(1, 1, 1)).normalize();
    private final static Point p = new Point(1, 1, 1);

    @BeforeAll
    public static void init() {
        setObject(new Plane(p, v));
    }

    @RepeatedTest(value = 10)
    public void hitPlane() {
        hitObject().ifPresent(this::assertHit);
    }

    @Test
    public void parallelRay() {
        Ray ray = new Ray(new Point(0, 0, 0), new Vector(1, -1, 0));
        assertFalse(getObject().hits(ray));
    }

    @Test
    public void notHittingRay() {
        Ray ray = new Ray(new Point(0, 0, 0), new Vector(-1, 0, 0));
        assertFalse(getObject().hits(ray));
    }

    @Override
    protected boolean isInObject(Point hit) {
        Vector w = toPoint(p, hit);
        return abs(dot(v, w)) < 10E-5;
    }
}
