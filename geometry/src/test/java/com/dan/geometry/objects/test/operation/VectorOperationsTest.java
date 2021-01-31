package com.dan.geometry.objects.test.operation;

import com.dan.geometry.utils.Vector;
import org.junit.jupiter.api.Test;

import static com.dan.geometry.utils.VectorUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VectorOperationsTest {

    @Test
    public void vectorSumTest() {
        Vector v1 = new Vector(1, 1, 1);
        Vector v2 = new Vector(2, 3, 4);
        assertEquals(add(v1, v2), new Vector(3, 4, 5));
    }

    @Test
    public void vectorDotTest() {
        Vector v1 = new Vector(-1, 5, 2);
        Vector v2 = new Vector(1, -5, 0);
        assertEquals(dot(v1, v2), -26);
    }

    @Test
    public void vectorCrossTest() {
        Vector v1 = new Vector(2, -1, 4);
        Vector v2 = new Vector(1, 0, 1);
        assertEquals(cross(v1, v2), new Vector(-1, 2, 1));
    }

}
