package com.dan.geometry.phong.texture;

import com.dan.geometry.phong.material.Material;
import com.dan.geometry.objects.Plane;
import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.Vector;
import com.dan.geometry.phong.material.Color;
import com.dan.geometry.phong.material.Matte;

public class MattePlane extends Plane implements GeometricTexturedObject {

    private Matte mateColor;

    public MattePlane(Point p, Vector v, Color c) {
        super(p, v);
        mateColor = new Matte(c);
    }

    @Override
    public Material getMaterial(Point p) {
        return mateColor;
    }
}
