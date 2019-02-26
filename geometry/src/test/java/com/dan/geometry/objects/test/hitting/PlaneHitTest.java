package com.dan.geometry.objects.test.hitting;

import com.dan.geometry.objects.Plane;
import com.dan.geometry.utils.*;
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
        Vector w= PointUtils.toPoint(p,hit);
        return Math.abs(VectorUtils.dot(v,w))<10E-5;
    }
}
