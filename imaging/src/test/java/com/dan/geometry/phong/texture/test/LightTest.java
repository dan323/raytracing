package com.dan.geometry.phong.texture.test;

import com.dan.geometry.objects.Sphere;
import com.dan.geometry.phong.light.Ambient;
import com.dan.geometry.phong.light.ParallelLight;
import com.dan.geometry.phong.light.PointLight;
import com.dan.geometry.phong.material.Color;
import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.Vector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LightTest {

    private final static Point ORIGIN = new Point(0, 0, 0);
    private final static Sphere SPHERE = new Sphere(ORIGIN, Math.sqrt(3));
    private final static Point POINT_IN_SPHERE = new Point(1, 1, 1);
    private final static Vector vector = new Vector(1, 1, 1);

    @Test
    public void lightPointTest() {
        PointLight pointLight = new PointLight(ORIGIN, Color.RED);
        Vector vec = pointLight.getDirectionToPoint(POINT_IN_SPHERE, SPHERE);
        Assertions.assertEquals(vector.normalize(), vec);
    }

    @Test
    public void lightParallelTest() {
        ParallelLight parallelLight = new ParallelLight(Color.ORANGE, vector);
        Vector vec = parallelLight.getDirectionToPoint(POINT_IN_SPHERE, SPHERE);
        Assertions.assertEquals(vector.normalize(),vec);
    }

    @Test
    public void ambientTest() {
        Ambient ambient = new Ambient(Color.BLUE);
        Vector vec = ambient.getDirectionToPoint(POINT_IN_SPHERE, SPHERE);
        Assertions.assertEquals(vector.normalize(),vec);
    }

}
