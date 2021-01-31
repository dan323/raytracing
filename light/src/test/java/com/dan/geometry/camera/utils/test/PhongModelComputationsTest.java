package com.dan.geometry.camera.utils.test;

import com.dan.geometry.camera.utils.PhongModelComputations;
import com.dan.geometry.phong.light.Light;
import com.dan.geometry.phong.light.ParallelLight;
import com.dan.geometry.phong.material.Color;
import com.dan.geometry.phong.texture.GeometricTexturedObject;
import com.dan.geometry.phong.texture.MattePlane;
import com.dan.geometry.phong.texture.MirrorSphere;
import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.Vector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class PhongModelComputationsTest {

    private static Set<GeometricTexturedObject> elements;
    private static Set<Light> lights;

    @BeforeEach
    public void clearLists() {
        elements = new HashSet<>();
        lights = new HashSet<>();
    }

    @Test
    public void applyReflexionNoHitTest() {

        PhongModelComputations.setBackground(Color.BLUE);

        final Point origin = new Point(0, 0, 0);
        Vector normalPlane = new Vector(0, 0, 1);
        Point hitPoint = new Point(0, 5, Math.sqrt(75));
        Vector incidence = (new Vector(-1, -1, 0)).normalize();

        //Mocked green matte plane (z=0)
        MattePlane mockedPlane = new MattePlane(origin, normalPlane, Color.GREEN);

        //Mocked mirror sphere (x^2+y^2+z^2=100)
        MirrorSphere mockedSphere = new MirrorSphere(origin, 10);

        elements.add(mockedPlane);
        elements.add(mockedSphere);

        Color color = PhongModelComputations.applyReflexion(1, 1, hitPoint, incidence, mockedSphere.getMaterial(hitPoint), mockedSphere.getNormalAt(hitPoint), Color.BLACK, elements, lights);

        Assertions.assertEquals(PhongModelComputations.getBackground(), color);
    }

    @Test
    public void applyReflexionHitTest() {

        PhongModelComputations.setBackground(Color.BLUE);

        final Point origin = new Point(0, 0, 0);
        Vector normalPlane = new Vector(0, 0, 1);
        Point hitPoint = new Point(0, 5, Math.sqrt(75));
        Vector incidence = (new Vector(0, 10, -10)).normalize();

        //Mocked green matte plane (z=0)
        MattePlane mockedPlane = new MattePlane(origin, normalPlane, Color.GREEN);

        //Mocked mirror sphere (x^2+y^2+z^2=100)
        MirrorSphere mockedSphere = new MirrorSphere(origin, 10);

        elements.add(mockedPlane);
        elements.add(mockedSphere);

        lights.add(new ParallelLight(Color.WHITE, new Vector(0, 0.5, -0.5), 4));

        Color color = PhongModelComputations.applyReflexion(1, 1, hitPoint, incidence, mockedSphere.getMaterial(hitPoint), mockedSphere.getNormalAt(hitPoint), Color.BLACK, elements, lights);

        Assertions.assertNotEquals(PhongModelComputations.getBackground(), color);
    }
}
