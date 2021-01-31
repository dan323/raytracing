package com.dan.geometry.phong.texture.test;

import com.dan.geometry.phong.material.Color;
import com.dan.geometry.phong.material.Material;
import com.dan.geometry.phong.texture.GeometricTexturedObject;
import com.dan.geometry.phong.texture.MattePlane;
import com.dan.geometry.phong.texture.MatteSphere;
import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.Vector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class MatteObjectTest {

    private final static Point ORIGIN = new Point(0, 0, 0);
    private final static Point POINT_IN_SPHERE = new Point(1, 1, 1);

    @Test
    public void matteSphereColor() {
        testObjectMate(color -> new MatteSphere(ORIGIN, Math.sqrt(3), color), POINT_IN_SPHERE, Color.BLACK);
    }

    @Test
    public void mattePlaneColor() {
        testObjectMate(color -> new MattePlane(ORIGIN, Vector.Z, color), new Point(3, 4, 0), Color.RED);
    }

    private void testObjectMate(Function<Color, GeometricTexturedObject> colorGeometricTexturedObjectSupplier, Point hit, Color color) {
        GeometricTexturedObject obj = colorGeometricTexturedObjectSupplier.apply(color);
        Material mat = obj.getMaterial(hit);
        Assertions.assertEquals(Color.BLACK, mat.getSpecularColor());
        Assertions.assertEquals(color, mat.getDiffuseColor());
        Assertions.assertEquals(color, mat.getAmbientColor());
        Assertions.assertEquals(0, mat.getShininess());
        Assertions.assertFalse(mat.isReflexive());
        Assertions.assertFalse(mat.isTransparent());
    }
}
