package com.dan.geometry.phong.texture;

import com.dan.geometry.phong.material.Material;
import com.dan.geometry.phong.material.Mirror;
import com.dan.geometry.objects.Sphere;
import com.dan.geometry.utils.Point;

public class MirrorSphere extends Sphere implements GeometricTexturedObject {

    public MirrorSphere(Point origin, double radious) {
        super(origin, radious);
    }

    @Override
    public Material getMaterial(Point p) {
        return Mirror.MIRROR;
    }
}
