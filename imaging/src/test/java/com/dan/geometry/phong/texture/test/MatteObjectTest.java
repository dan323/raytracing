package com.dan.geometry.phong.texture.test;

import com.dan.geometry.objects.Sphere;
import com.dan.geometry.phong.material.Color;
import com.dan.geometry.phong.material.Material;
import com.dan.geometry.phong.material.Matte;
import com.dan.geometry.phong.texture.GeometricTexturedObject;
import com.dan.geometry.phong.texture.MatteSphere;
import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.Vector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatteObjectTest {

    private final static Point ORIGIN = new Point(0, 0, 0);
    private final static Point POINT_IN_SPHERE = new Point(1, 1, 1);

    @Test
    public void matteColor() {
        GeometricTexturedObject sphere = new MatteSphere(ORIGIN, Math.sqrt(3), Color.BLACK);
        Material mat = sphere.getMaterial(POINT_IN_SPHERE);
        Assertions.assertEquals(Color.BLACK,mat.getSpecularColor());
        Assertions.assertEquals(Color.BLACK,mat.getDiffuseColor());
        Assertions.assertEquals(Color.BLACK,mat.getAmbientColor());
        Assertions.assertEquals(0,mat.getShininess());
        Assertions.assertFalse(mat.isReflexive());
        Assertions.assertFalse(mat.isTransparent());
    }
}
