package com.dan.geometry.phong.texture.test;

import com.dan.geometry.phong.material.Color;
import com.dan.geometry.phong.material.Material;
import com.dan.geometry.phong.material.Mirror;
import com.dan.geometry.phong.texture.GeometricTexturedObject;
import com.dan.geometry.phong.texture.MatteSphere;
import com.dan.geometry.phong.texture.MirrorSphere;
import com.dan.geometry.utils.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MirrorObjectTest {
    private final static Point ORIGIN = new Point(0, 0, 0);
    private final static Point POINT_IN_SPHERE = new Point(1, 1, 1);

    @Test
    public void mirrorTest() {
        GeometricTexturedObject sphere = new MirrorSphere(ORIGIN, Math.sqrt(3));
        Material mat = sphere.getMaterial(POINT_IN_SPHERE);
        Assertions.assertEquals(Color.WHITE, mat.getSpecularColor());
        Assertions.assertEquals(Color.BLACK, mat.getDiffuseColor());
        Assertions.assertEquals(Color.BLACK, mat.getAmbientColor());
        Assertions.assertEquals(10, mat.getShininess());
        Assertions.assertTrue(mat.isReflexive());
        Assertions.assertFalse(mat.isTransparent());
    }
}
