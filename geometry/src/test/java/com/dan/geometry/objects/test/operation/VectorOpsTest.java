package com.dan.geometry.objects.test.operation;

import com.dan.geometry.utils.Vector;
import org.junit.jupiter.api.Test;

import static com.dan.geometry.utils.VectorUtils.reflect;
import static com.dan.geometry.utils.VectorUtils.refract;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VectorOpsTest {

    @Test
    public void reflectTest() {
        Vector v = new Vector(1, 1, 0);
        Vector n = new Vector(0, 1, 0);
        assertEquals(new Vector(1, -1, 0), reflect(v, n));
    }

    @Test
    public void refractTest() {
        Vector v = new Vector(1, 1, 0);
        Vector n = new Vector(0, 1, 0);
        assertEquals(v.normalize(), refract(v, n, 1, 1));
    }
}
