package com.dan.geometry.phong.light;

import com.dan.geometry.phong.material.Color;
import com.dan.geometry.objects.GeometricObject;
import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.Vector;

public class ParallelLight extends Light {

    private Vector direction;

    public ParallelLight(Color intensity, Vector direction){
        this.direction=direction.normalize();
        setIntensity(intensity);
    }

    @Override
    public Vector getDirectionToPoint(Point p, GeometricObject ob) {
        return direction;
    }
}
