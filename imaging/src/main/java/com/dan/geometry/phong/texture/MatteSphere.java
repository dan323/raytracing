package com.dan.geometry.phong.texture;

import com.dan.geometry.phong.material.Color;
import com.dan.geometry.phong.material.Material;
import com.dan.geometry.phong.material.Matte;
import com.dan.geometry.objects.Sphere;
import com.dan.geometry.utils.Point;

public class MatteSphere extends Sphere implements GeometricTexturedObject {

    private Matte material;

    public MatteSphere(Point or, double rad, Color c) {
        super(or, rad);
        material = new Matte(c);
    }


    @Override
    public Material getMaterial(Point p) {
        return material;
    }
}
