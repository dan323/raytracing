package com.dan.geometry.camera.utils;

import com.dan.geometry.objects.GeometricObject;
import com.dan.geometry.phong.light.Light;
import com.dan.geometry.phong.material.Color;
import com.dan.geometry.phong.texture.GeometricTexturedObject;
import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.PointUtils;
import com.dan.geometry.utils.Ray;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Stream;

public class PhotonMapping {

    private Map<GeometricObject, Set<Photon>> photonsOnObjects;
    private static final BigInteger PHOTON_NUMBER = BigInteger.valueOf(100000000);

    private void put(GeometricObject go, Photon photon) {
        if (photonsOnObjects.containsKey(go)) {
            photonsOnObjects.get(go).add(photon);
        } else {
            Set<Photon> set = new HashSet<>();
            set.add(photon);
            photonsOnObjects.put(go, set);
        }
    }

    public void computeMap(Collection<Light> lights, Collection<GeometricTexturedObject> elements) {
        BigDecimal total = lights.stream().mapToDouble(Light::getWatt).mapToObj(BigDecimal::valueOf).reduce(BigDecimal.ZERO, BigDecimal::add);
        for (Light light : lights) {
            int photons = (new BigDecimal(PHOTON_NUMBER)).multiply(BigDecimal.valueOf(light.getWatt()).divide(total, RoundingMode.CEILING)).intValue();
            for (int i = 0; i < photons; i++) {
                Ray ray = getRandomRay(light);
                computeMapFromRay(ray);
            }
        }
    }

    private void computeMapFromRay(Ray ray) {
    }

    private Ray getRandomRay(Light light) {
        return null;
    }

    private static Stream<Photon> getRelevantPhotons(Stream<Photon> photons, Point point) {
        return photons.filter(photon -> PointUtils.distance(point, photon.getPoint()) < 10E-2);
    }

    public Color getPhotonMappingColor(Point point, GeometricObject go) {
        Stream<Photon> stream = getRelevantPhotons(photonsOnObjects.get(go).stream(), point);
        return stream
                .map(Photon::getColor)
                .map(c -> new AbstractMap.SimpleEntry<>(1, c))
                .collect(new ColorReduceMean());
    }

}
