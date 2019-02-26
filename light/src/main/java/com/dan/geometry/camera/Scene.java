package com.dan.geometry.camera;

import com.dan.geometry.phong.light.Ambient;
import com.dan.geometry.phong.light.Light;
import com.dan.geometry.phong.material.Color;
import com.dan.geometry.phong.material.Material;
import com.dan.geometry.phong.texture.GeometricTexturedObject;
import com.dan.geometry.utils.*;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Class that contains the staged picture
 */
public class Scene {

    private static final int MAX_RECURSION = 10;
    private Camera cam;
    private Set<GeometricTexturedObject> elements;
    private Set<Light> lights;

    /**
     * Computes the color at the {@link Point} {@code hit}
     *
     * @param eta       ration of light velocity in actual medium
     * @param recursion number of times applied recursively
     * @param object    hit geometric shape
     * @param hit       hitting point
     * @param incidence vector of incidence in {@code hit}
     * @return the color of {@code hit}
     */
    private Color computeColor(double eta, int recursion, GeometricTexturedObject object, Point hit, Vector incidence) {
        //Initicalize to black
        Material mat = object.getMaterial(hit);
        Vector normal = object.getNormalAt(hit);
        Color color = Color.BLACK;
        //Add light action
        for (Light light : lights) {
            if (light instanceof Ambient) {
                color = color.add(mat.getAmbientColor().multiply(light.getIntensity()));
            } else {
                color = color.add(mat.getDiffuseColor().multiply(light.getIntensity()).scale(VectorUtils.dot(normal, light.getDirectionToPoint(hit, object))));
                color = color.add(mat.getSpecularColor().multiply(light.getIntensity()).scale(Math.pow(VectorUtils.dot(normal, light.getDirectionToPoint(hit, object)), mat.getShininess())));
            }
        }

        if (recursion >= MAX_RECURSION) {
            return color;
        }

        color = applyRefraction(eta, recursion, hit, incidence, mat, normal, color);
        color = applyReflexion(eta, recursion, hit, incidence, mat, normal, color);

        return color;
    }

    /**
     * Applies the reflexion
     *
     * @param eta
     * @param recursion
     * @param hit
     * @param incidence
     * @param mat
     * @param normal
     * @param color
     * @return color of point reached by the reflected ray
     */
    private Color applyReflexion(double eta, int recursion, Point hit, Vector incidence, Material mat, Vector normal, Color color) {
        return applyAction(eta, recursion, hit, mat, color, Material::isReflexive, VectorUtils.reflect(incidence, normal));
    }

    /**
     * @param eta
     * @param recursion
     * @param hit
     * @param incidence
     * @param mat
     * @param normal
     * @param color
     * @return color of point reached by the refracted ray
     */
    private Color applyRefraction(double eta, int recursion, Point hit, Vector incidence, Material mat, Vector normal, Color color) {
        return applyAction(mat.getEta(), recursion, hit, mat, color, Material::isTransparent, VectorUtils.refract(incidence, normal, eta, mat.getEta()));
    }

    /**
     * @param eta
     * @param recursion
     * @param hit
     * @param mat
     * @param color
     * @param check
     * @param direction
     * @return
     */
    private Color applyAction(double eta, int recursion, Point hit, Material mat, Color color, Predicate<Material> check, Vector direction) {
        if (check.test(mat) && !direction.equals(Vector.ZERO)) {
            Ray ray = new Ray(hit, direction);
            Object[] hitt = getIntersection(ray);
            if (hitt.length > 0) {
                Point hittingPoint = PointUtils.translate(ray.getOrigin(), ray.getDirection().scale((Double) hitt[1]));
                color = color.add(mat.getSpecularColor().multiply(computeColor(eta, recursion + 1, (GeometricTexturedObject) hitt[0], hittingPoint, direction)));

            }
        }
        return color;
    }

    public void addElement(GeometricTexturedObject go) {
        if (elements == null) {
            elements = new HashSet<>();
        }
        elements.add(go);
    }

    public void addLight(Light go) {
        if (lights == null) {
            lights = new HashSet<>();
        }
        lights.add(go);
    }

    /**
     * @param ray
     * @return {geom,dist} where {@code geom} is the geometric shape hit and {@code dist} is the
     * distance travelled by the ray to hit it.
     */
    private Object[] getIntersection(Ray ray) {
        double dist = Double.MAX_VALUE;
        GeometricTexturedObject hitedObj = null;
        for (GeometricTexturedObject gto : elements) {
            if (gto.hits(ray) && dist > gto.distance(ray)) {
                dist = gto.distance(ray);
                hitedObj = gto;
            }
        }
        if (hitedObj != null) {
            return new Object[]{hitedObj, dist};
        }
        return new Object[]{};
    }

    public Color[][] render() {

        Color[][] im = new Color[cam.getWidth()][cam.getHeight()];
        for (int x = 0; x < cam.getWidth(); x++) {
            for (int y = 0; y < cam.getHeight(); y++) {
                Vector q = VectorUtils.add(VectorUtils.add(cam.getDirection().scale(cam.getDistance()), cam.getUp().scale(cam.getHeight() / 2.0 - y)), VectorUtils.cross(cam.getUp(), cam.getDirection()).scale(cam.getWidth() / 2.0 - x));
                q = q.normalize();
                Ray r = new Ray(cam.getOrigin(), q);
                Object[] l = getIntersection(r);
                if (l.length != 0) {
                    GeometricTexturedObject inter = (GeometricTexturedObject) l[0];
                    double dist = (Double) l[1];
                    Vector v = new Vector(r.getDirection().getX(), r.getDirection().getY(), r.getDirection().getZ());
                    v = v.scale(dist);
                    if (inter != null) {
                        im[x][y] = computeColor(1, 1, inter, PointUtils.translate(r.getOrigin(), v), r.getDirection());
                    } else {
                        im[x][y] = Color.BLACK;
                    }
                }
            }
        }
        return im;
    }

    public Camera getCam() {
        return cam;
    }

    public void setCam(Camera cam) {
        this.cam = cam;
    }

}
