package com.dan.geometry.camera.utils;

import com.dan.geometry.phong.light.Ambient;
import com.dan.geometry.phong.light.Light;
import com.dan.geometry.phong.material.Color;
import com.dan.geometry.phong.material.Material;
import com.dan.geometry.phong.texture.GeometricTexturedObject;
import com.dan.geometry.utils.*;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public final class PhongModelComputations {

    private static final int MAX_RECURSION = 10;
    private static Color background = Color.BLACK;

    private PhongModelComputations() {
    }

    /**
     * @param ray to intersect
     * @return an {@link Optional} containing the geometric shape hit of type {@link GeometricTexturedObject} if it exists
     */
    public static Optional<GeometricTexturedObject> getIntersection(Ray ray, Collection<GeometricTexturedObject> elements) {
        double dist = Double.MAX_VALUE;
        GeometricTexturedObject hitedObj = null;
        for (GeometricTexturedObject gto : elements) {
            if (gto.hits(ray) && dist > gto.distance(ray)) {
                dist = gto.distance(ray);
                hitedObj = gto;
            }
        }
        if (hitedObj != null) {
            return Optional.of(hitedObj);
        }
        return Optional.empty();
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
    public static Color applyReflexion(double eta, int recursion, Point hit, Vector incidence, Material mat, Vector normal, Color color, Collection<GeometricTexturedObject> elements, Collection<Light> lights) {
        return applyAction(eta, recursion, hit, mat, color, Material::isReflexive, VectorUtils.reflect(incidence, normal), elements, lights);
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
    public static Color applyRefraction(double eta, int recursion, Point hit, Vector incidence, Material mat, Vector normal, Color color, Collection<GeometricTexturedObject> elements, Collection<Light> lights) {
        return applyAction(mat.getEta(), recursion, hit, mat, color, Material::isTransparent, VectorUtils.refract(incidence, normal, eta, mat.getEta()), elements, lights);
    }

    /**
     * Method to not duplicate code with reflexion and refraction
     *
     * @param eta
     * @param recursion
     * @param hit
     * @param mat
     * @param color
     * @param check
     * @param direction
     * @return
     */
    private static Color applyAction(double eta, int recursion, Point hit, Material mat, Color color, Predicate<Material> check, Vector direction, Collection<GeometricTexturedObject> elements, Collection<Light> lights) {
        if (check.test(mat) && !direction.equals(Vector.ZERO)) {
            Ray ray = new Ray(PointUtils.translate(hit, direction.scale(10E-4)), direction);
            Optional<GeometricTexturedObject> hitt = getIntersection(ray, elements);
            var opt=hitt.flatMap(g -> g.getHitPoint(ray));
            color = color.add(hitt.map(g -> mat.getSpecularColor().multiply(computeColor(eta, recursion + 1, g, opt.orElseThrow(), direction, elements, lights))).orElse(background));
        }
        return color;
    }

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
    public static Color computeColor(double eta, int recursion, GeometricTexturedObject object, Point hit, Vector incidence, Collection<GeometricTexturedObject> elements, Collection<Light> lights) {

        Material mat = object.getMaterial(hit);
        Vector normal = object.getNormalAt(hit);

        //Add light action
        Color color = getColorLight(object, hit, mat, normal, lights);

        if (recursion >= MAX_RECURSION) {
            return color;
        }

        //Recursive calls for reflexion and refraction
        color = applyRefraction(eta, recursion, hit, incidence, mat, normal, color, elements, lights);
        color = applyReflexion(eta, recursion, hit, incidence, mat, normal, color, elements, lights);

        return color;
    }

    private static Color getColorLight(GeometricTexturedObject object, Point hit, Material mat, Vector normal, Collection<Light> lights) {
        Color color = Color.BLACK;
        for (Light light : lights) {
            if (light instanceof Ambient) {
                color = color.add(mat.getAmbientColor().multiply(light.getIntensity().scale(light.getWatt())));
            } else {
                color = color.add(mat.getDiffuseColor().multiply(light.getIntensity()).scale(VectorUtils.dot(normal, light.getDirectionFromPoint(hit, object))));
                color = color.add(mat.getSpecularColor().multiply(light.getIntensity()).scale(Math.pow(VectorUtils.dot(normal, light.getDirectionFromPoint(hit, object)), mat.getShininess())));
            }
        }
        return color;
    }

    public static Color getBackground() {
        return background;
    }

    public static void setBackground(Color color) {
        background = color;
    }

}
