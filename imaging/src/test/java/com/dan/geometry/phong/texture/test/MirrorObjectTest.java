package com.dan.geometry.phong.texture.test;

import com.dan.geometry.phong.material.Color;
import com.dan.geometry.phong.material.Material;
import com.dan.geometry.phong.material.Mirror;
import com.dan.geometry.phong.texture.GeometricTexturedObject;
import com.dan.geometry.phong.texture.MatteSphere;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MirrorObjectTest {

    @Test
    public void mirrorTest() {
        Material mat= Mirror.MIRROR;
        Assertions.assertEquals(Color.WHITE, mat.getSpecularColor());
        Assertions.assertEquals(Color.BLACK, mat.getDiffuseColor());
        Assertions.assertEquals(Color.BLACK, mat.getAmbientColor());
        Assertions.assertEquals(10, mat.getShininess());
        Assertions.assertTrue(mat.isReflexive());
        Assertions.assertFalse(mat.isTransparent());
    }
}
