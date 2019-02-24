package com.dan323.geometry.objects.test;

import com.dan323.geometry.objects.Sphere;
import com.dan323.geometry.objects.Triangle;
import com.dan323.geometry.utils.Point;
import com.dan323.geometry.utils.Ray;
import com.dan323.geometry.utils.Vector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TriangleHitTest{

    private static Point pointA = new Point(2, 1, 2);
    private static Point pointB = new Point(3, 1, 2);
    private static Point pointC = new Point(1, 0, 2);
    private Triangle triangle;

    @Test
    public void hitTriangleDistance() {
        Ray ray=new Ray(new Point(2.5,0.75,0),new Vector(0,0,1));
        Assertions.assertTrue(triangle.hits(ray));
        Assertions.assertTrue(isInObject(ray.getOrigin().translate(ray.getDirection().scale(triangle.distance(ray)))));
    }

    @BeforeEach
    public void initTriangle() {
        triangle= new Triangle(pointA, pointB, pointC);
    }

    @Test
    public void hitTrianglePlane() {
        Ray ray=new Ray(new Point(0,0,0),new Vector(0,0,1));
        Assertions.assertFalse(triangle.hits(ray));
    }

    @Test
    public void hitTriangleNoPlane() {
        Ray ray=new Ray(new Point(0,0,0),new Vector(0,1,0));
        Assertions.assertFalse(triangle.hits(ray));
    }

    @Test
    public void hitTriangleOutside() {
        Ray ray=new Ray(new Point(2,2,0),new Vector(0,0,1));
        Assertions.assertFalse(triangle.hits(ray));
    }

    @Test
    public void hitTriangleOutside2() {
        Ray ray=new Ray(pointB.translate(pointA.toPoint(pointC)),new Vector(0,0,1));
        Assertions.assertFalse(triangle.hits(ray));
    }

    protected boolean isInObject(Point hit) {
        return Triangle.isPointInSimplex(hit,pointA,pointB,pointC);
    }
}