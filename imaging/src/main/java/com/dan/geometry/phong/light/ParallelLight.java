package com.dan.geometry.phong.light;

import com.dan.geometry.objects.GeometricObject;
import com.dan.geometry.phong.material.Color;
import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.Vector;

public class ParallelLight extends Light {

    private final Vector direction;

    public ParallelLight(Color intensity, Vector direction, int watt) {
        this.direction = direction.normalize();
        setIntensity(intensity);
        setWatt(watt);
    }

    @Override
    public Vector getDirectionFromPoint(Point p, GeometricObject ob) {
        return direction.scale(-1);
    }
}
