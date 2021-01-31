package com.dan.geometry.camera;

import com.dan.geometry.camera.utils.PhongModelComputations;
import com.dan.geometry.phong.light.Light;
import com.dan.geometry.phong.material.Color;
import com.dan.geometry.phong.texture.GeometricTexturedObject;
import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.Ray;
import com.dan.geometry.utils.Vector;
import com.dan.geometry.utils.VectorUtils;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Class that contains the staged picture and renders it
 *
 * @author danconsa
 */
public class Scene {

    private Camera camera;
    private final Set<GeometricTexturedObject> elements;
    private final Set<Light> lights;

    public Scene(Camera camera) {
        this.camera = camera;
        this.lights = new HashSet<>();
        this.elements = new HashSet<>();
    }


    public void addElement(GeometricTexturedObject go) {
        elements.add(go);
    }

    public void addLight(Light go) {
        lights.add(go);
    }

    public void clearLights() {
        lights.clear();
    }

    public void clearElements() {
        elements.clear();
    }

    public Color[][] render() {
        Color[][] im = new Color[camera.getWidth()][camera.getHeight()];
        for (int x = 0; x < camera.getWidth(); x++) {
            for (int y = 0; y < camera.getHeight(); y++) {
                Vector q = getDirectionVector(x, y);
                Ray r = new Ray(camera.getOrigin(), q);
                Optional<GeometricTexturedObject> inter = PhongModelComputations.getIntersection(r, elements);
                Optional<Point> opt = inter.flatMap(g -> g.getHitPoint(r));
                im[y][x] = inter
                        .map(g -> PhongModelComputations.computeColor(1, 1, g, opt.orElseThrow(), r.getDirection(), elements, lights))
                        .orElse(PhongModelComputations.getBackground());
            }
        }
        return im;
    }

    public Vector getDirectionVector(int x, int y) {
        Vector vz = camera.getDirection().scale(camera.getDistance());
        Vector vx = camera.getUp().scale(camera.getHeight() / 2.0 - y);
        Vector vy = VectorUtils.cross(camera.getUp(), camera.getDirection()).scale(camera.getWidth() / 2.0 - x);
        return VectorUtils.add(VectorUtils.add(vx, vy), vz);
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

}
