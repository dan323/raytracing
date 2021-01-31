package com.dan.geometry.camera.test;

import com.dan.geometry.camera.Camera;
import com.dan.geometry.camera.Scene;
import com.dan.geometry.camera.utils.PhongModelComputations;
import com.dan.geometry.phong.light.Light;
import com.dan.geometry.phong.light.ParallelLight;
import com.dan.geometry.phong.material.Color;
import com.dan.geometry.phong.texture.GeometricTexturedObject;
import com.dan.geometry.phong.texture.MatteSphere;
import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.Ray;
import com.dan.geometry.utils.Vector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Set;

public class SceneTest {

    @Test
    public void applyReflexionTest() throws NoSuchFieldException, IllegalAccessException {
        Camera camera = new Camera(new Point(0, 0, 400), new Vector(1, 0, 0), new Vector(0, 0, -1), 550);
        camera.setHeight(800);
        camera.setWidth(800);
        Scene testScene = new Scene(camera);

        System.out.println(camera.getFOVH()*180/3.1415 + ":" + camera.getFOVV()*180/3.1415);

        GeometricTexturedObject greenSphere = new MatteSphere(new Point(0, 0, 0), 150, Color.GREEN);
        //testScene.addElement(greenSphere);
        GeometricTexturedObject blueSphere = new MatteSphere(new Point(0, 100, 0), 200, Color.BLUE);
        testScene.addElement(blueSphere);
        //testScene.addElement(new MattePlane(new Point(0, 0, 0), new Vector(0, 0, 1), Color.RED));
        Light parallelLight = new ParallelLight(Color.WHITE, new Vector(1, 1, -1), 5);
        Light parallelLight2 = new ParallelLight(Color.WHITE, new Vector(-1, -1, -1), 5);
        //Light ambient = new Ambient(Color.WHITE, 0.0005);
        testScene.addLight(parallelLight);
        //testScene.addLight(parallelLight2);

        Color[][] colors = testScene.render();

        writeImageFromMatrix(colors);

        // TEST

        Ray ray = new Ray(camera.getOrigin(), camera.getDirection());
        var opt = blueSphere.getHitPoint(ray);
        opt.ifPresent(System.out::println);
        var optCol = opt.map(p -> PhongModelComputations.computeColor(1, 1, blueSphere, p, ray.getDirection(), Collections.emptySet(), Collections.singleton(parallelLight)));
        optCol.ifPresent(color -> Assertions.assertEquals(color, colors[300][300]));

        Assertions.assertEquals(camera, testScene.getCamera());

        Field lightsF = Scene.class.getDeclaredField("lights");
        lightsF.setAccessible(true);
        Field elementsF = Scene.class.getDeclaredField("elements");
        elementsF.setAccessible(true);

        Assertions.assertNotEquals(0, ((Set<Light>) lightsF.get(testScene)).size());
        Assertions.assertNotEquals(0, ((Set<GeometricTexturedObject>) elementsF.get(testScene)).size());

        testScene.clearElements();
        Assertions.assertEquals(0, ((Set<GeometricTexturedObject>) elementsF.get(testScene)).size());

        testScene.clearLights();
        Assertions.assertEquals(0, ((Set<Light>) lightsF.get(testScene)).size());
    }

    private void writeImageFromMatrix(Color[][] colors) {
        int width = colors.length;
        int height = colors[0].length;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                image.setRGB(x, y, colors[x][y].toInteger());
            }
        }

        File outputFile = new File("output.bmp");
        try {
            ImageIO.write(image, "bmp", outputFile);
            System.out.println("Success");
            System.out.println(outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("HOLA");
        }
    }
}
