package com.dan323.geometry.objects.material.objects;

import com.dan323.geometry.Point;
import com.dan323.geometry.Vector;
import com.dan323.geometry.objects.Plane;
import com.dan323.geometry.objects.material.Color;
import com.dan323.geometry.objects.material.Matte;

public class MattePlane extends Plane implements GeometricTexturedObject {

    private Matte mateColor;

    public MattePlane(Point p, Vector v, Color c) {
        super(p, v);
        mateColor = new Matte(c);
    }

    public Color getColor(Point p) {
        return mateColor.getColor();
    }

}
