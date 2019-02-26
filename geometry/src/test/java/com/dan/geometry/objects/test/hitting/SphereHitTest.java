package com.dan.geometry.objects.test.hitting;

import com.dan.geometry.objects.Sphere;
import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.PointUtils;
import com.dan.geometry.utils.Ray;
import com.dan.geometry.utils.Vector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class SphereHitTest extends ObjectHitDistanceTest {

    private static final Point origin = new Point(2, 1, 2);
    private static final double radious = 5;

    @BeforeAll
    public static void init() {
        setObject(new Sphere(origin, radious));
    }

    @RepeatedTest(value = 3)
    public void hitSphere() {
        hitObject().ifPresent(this::assertHit);
    }

    @Test
    public void wrongDirectionRay(){
        Ray ray=new Ray(new Point(2,1,10),new Vector(0,0,1));
        Assertions.assertFalse(getObject().hits(ray));
    }

    @Test
    public void notHittingRay(){
        Ray ray=new Ray(new Point(-10,-10,0),new Vector(-1,0,0));
        Assertions.assertFalse(getObject().hits(ray));
    }

    @Test
    public void insideSphere(){
        Ray ray=new Ray(new Point(2,1,3),new Vector(1,0,0));
        Assertions.assertTrue(getObject().hits(ray));
    }

    @Test
    public void twoHitSphere(){
        Point p=new Point(-100,1,3);
        Ray ray=new Ray(p, PointUtils.toPoint(p,origin));
        Assertions.assertTrue(getObject().hits(ray));
    }

    @Override
    protected boolean isInObject(Point hit) {
        return Math.abs(PointUtils.distance(origin,hit) - radious) < 10E-5;
    }
}
