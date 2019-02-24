package com.dan323.geometry.camera;

import com.dan323.geometry.utils.Ray;
import com.dan323.geometry.light.Ambient;
import com.dan323.geometry.light.Light;
import com.dan323.geometry.objects.material.Color;
import com.dan323.geometry.objects.material.objects.GeometricTexturedObject;
import com.dan323.geometry.utils.Point;
import com.dan323.geometry.utils.Vector;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Scene {

    private Camera cam;
    private Set<GeometricTexturedObject> elements;
    private Set<Light> lights;

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

    public Color[][] render() {

        Color[][] im = new Color[cam.getWidth()][cam.getHeight()];
        for (int x = 0; x < cam.getWidth(); x++) {
            for (int y = 0; y < cam.getHeight(); y++) {
                Vector q = cam.getDirection().scale(cam.getDistance()).add(cam.getUp().scale(cam.getHeight() / 2 - y)).add(cam.getUp().cross(cam.getDirection()).scale(cam.getWidth() / 2 - x));
                q = q.normalize();
                Ray r = new Ray(cam.getOrigin(), q);
                List<Object> l = getIntersection(r);
                GeometricTexturedObject inter = (GeometricTexturedObject) l.get(0);
                double dist = (Double) l.get(1);
                Vector v = new Vector(r.getDirection().getX(), r.getDirection().getY(), r.getDirection().getZ());
                v = v.scale(dist);
                if (inter != null) {
                    im[x][y] = getColor(inter, r.getOrigin().translate(v), r.getDirection());
                } else {
                    im[x][y] = new Color(0, 0, 0);
                }
            }
        }
        return im;
    }

    private List<Object> getIntersection(Ray r) {
        double t = Double.MAX_VALUE;
        GeometricTexturedObject sol = null;
        List<Object> solList = new ArrayList<>();
        for (GeometricTexturedObject geom : elements) {
            if (geom.hits(r)) {
                double t2 = geom.distance(r);
                if (t2 < t) {
                    t = t2;
                    sol = geom;
                }
            }
        }
        solList.add(sol);
        solList.add(t);
        return solList;
    }

    private Color getColor(GeometricTexturedObject geom, Point p, Vector incidence) {
        Color c = new Color(0, 0, 0);
        for (Light li : lights) {
            Color aux = geom.getColor(p);
            if (li instanceof Ambient) {
                //TODO
                incidence.getX();
            } else {
                Vector v1 = li.getDirectionToPoint(p, geom);
                Vector n = geom.getNormalAt(p);
                if (Math.abs(v1.dot(n) - 1) < 10E-4) {
                    aux.scale(li.getIntensity());
                } else {
                    aux.scale(v1.dot(n) * li.getIntensity());
                }
            }
            c.add(aux);
        }
        return c;
    }

    public Camera getCam() {
        return cam;
    }

    public void setCam(Camera cam) {
        this.cam = cam;
    }

}
