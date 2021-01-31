package com.dan.geometry.objects.test.hitting;

import com.dan.geometry.objects.Sphere;
import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.PointUtils;
import com.dan.geometry.utils.Ray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BigSphereHitTest extends ObjectHitDistanceTest {

    private static final Point origin = new Point(0, 500, 0);
    private static final double radious = 150;

    @BeforeAll
    public static void init() {
        setObject(new Sphere(origin, radious));
    }

    @Test
    public void twoHitSphere() {
        Point p = new Point(0, 0, 200);
        Ray ray = new Ray(p, PointUtils.toPoint(p, origin));
        Assertions.assertTrue(getObject().hits(ray));
    }

    @Override
    protected boolean isInObject(Point hit) {
        return Math.abs(PointUtils.distance(origin, hit) - radious) < 10E-5;
    }
}