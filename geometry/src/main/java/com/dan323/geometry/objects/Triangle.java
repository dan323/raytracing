package com.dan323.geometry.objects;

import com.dan323.geometry.Point;
import com.dan323.geometry.Ray;
import com.dan323.geometry.Vector;

public class Triangle implements GeometricObject {
    @Override
    public boolean hits(Ray ray) {
        return false;
    }

    @Override
    public double distance(Ray ray) {
        return 0;
    }

    @Override
    public Vector getNormalAt(Point p) {
        return null;
    }
}
