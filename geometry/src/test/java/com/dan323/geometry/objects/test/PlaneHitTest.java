package com.dan323.geometry.objects.test;

import com.dan323.geometry.objects.Plane;
import com.dan323.geometry.utils.Point;
import com.dan323.geometry.utils.Ray;
import com.dan323.geometry.utils.Vector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class PlaneHitTest extends ObjectHitDistanceTest {

    private final static Vector v=(new Vector(1, 1, 1)).normalize();
    private final static Point p=new Point(1, 1, 1);

    @BeforeAll
    public static void init() {
        setObject(new Plane(p, v));
    }

    @RepeatedTest(value = 3)
    public void hitPlane() {
        hitObject().ifPresent(this::assertHit);
    }

    @Test
    public void parallelRay(){
        Ray ray=new Ray(new Point(0,0,0),new Vector(1,-1,0));
        Assertions.assertFalse(getObject().hits(ray));
    }

    @Test
    public void notHittingRay(){
        Ray ray=new Ray(new Point(0,0,0),new Vector(-1,0,0));
        Assertions.assertFalse(getObject().hits(ray));
    }

    @Override
    protected boolean isInObject(Point hit) {
        Vector w=p.toPoint(hit);
        return Math.abs(v.dot(w))<10E-5;
    }
}
