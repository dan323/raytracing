package com.dan.geometry.camera.test;

import com.dan.geometry.camera.Camera;
import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.Vector;
import com.dan.geometry.utils.VectorUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CameraTest {

    private static final Point ORIGIN = new Point(0, 0, 0);

    @Test
    public void cameraConstructorAlreadyPerpendicularTest() {
        Camera camera = new Camera(ORIGIN, Vector.Z, Vector.X, 100);
        testCameraVectors(camera);
    }

    @Test
    public void cameraConstructorNotPerpendicularTest() {
        Camera camera = new Camera(ORIGIN, new Vector(1, 0, 1), Vector.X, 100);
        testCameraVectors(camera);
    }

    private void testCameraVectors(Camera camera) {
        testPerpendicular(camera.getDirection(), camera.getUp());
        testUnitary(camera.getUp());
        testUnitary(camera.getDirection());
    }

    private void testUnitary(Vector up) {
        Assertions.assertEquals(1, up.norm(), 10E-5);
    }

    private void testPerpendicular(Vector direction, Vector up) {
        Assertions.assertEquals(0, VectorUtils.dot(direction, up));
    }
}
