package com.dan.geometry.objects.test.hitting;

import com.dan.geometry.objects.Triangle;
import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.PointUtils;
import com.dan.geometry.utils.Ray;
import com.dan.geometry.utils.Vector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.dan.geometry.objects.Triangle.isPointInSimplex;
import static com.dan.geometry.utils.PointUtils.toPoint;
import static com.dan.geometry.utils.PointUtils.translate;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TriangleHitTest {

    private static Point pointA = new Point(2, 1, 2);
    private static Point pointB = new Point(3, 1, 2);
    private static Point pointC = new Point(1, 0, 2);
    private Triangle triangle;

    @Test
    public void hitTriangleDistance() {
        Ray ray = new Ray(new Point(2.5, 0.75, 0), new Vector(0, 0, 1));
        assertTrue(triangle.hits(ray));
        assertTrue(isInObject(translate(ray.getOrigin(), ray.getDirection().scale(triangle.distance(ray)))));
    }

    @BeforeEach
    public void initTriangle() {
        triangle = new Triangle(pointA, pointB, pointC);
    }

    @Test
    public void hitTrianglePlane() {
        Ray ray = new Ray(new Point(0, 0, 0), new Vector(0, 0, 1));
        assertFalse(triangle.hits(ray));
    }

    @Test
    public void hitTriangleNoPlane() {
        Ray ray = new Ray(new Point(0, 0, 0), new Vector(0, 1, 0));
        assertFalse(triangle.hits(ray));
    }

    @Test
    public void hitTriangleOutside() {
        Ray ray = new Ray(new Point(2, 2, 0), new Vector(0, 0, 1));
        assertFalse(triangle.hits(ray));
    }

    @Test
    public void hitTriangleOutside2() {
        Ray ray = new Ray(translate(pointB, toPoint(pointA, pointC)), new Vector(0, 0, 1));
        assertFalse(triangle.hits(ray));
    }

    private boolean isInObject(Point hit) {
        return isPointInSimplex(hit, pointA, pointB, pointC);
    }
}