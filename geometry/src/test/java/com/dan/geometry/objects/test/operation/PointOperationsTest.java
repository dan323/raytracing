package com.dan.geometry.objects.test.operation;

import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.Vector;
import org.junit.jupiter.api.Test;

import static com.dan.geometry.utils.PointUtils.*;
import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointOperationsTest {
    @Test
    public void pointToPoint() {
        Point v1 = new Point(1, 1, 1);
        Point v2 = new Point(2, 3, 4);
        assertEquals(toPoint(v1, v2), new Vector(1, 2, 3));
    }

    @Test
    public void pointTranslate() {
        Point v1 = new Point(-1, 5, 2);
        Vector v2 = new Vector(1, -5, 0);
        assertEquals(translate(v1, v2), new Point(0, 0, 2));
    }

    @Test
    public void pointsDistance() {
        Point v1 = new Point(2, -1, 4);
        Point v2 = new Point(1, 0, 1);
        assertEquals(distance(v1, v2), sqrt(11), 10E-5);
    }
}
