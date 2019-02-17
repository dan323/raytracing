package com.dan323.geometry.objects;

//import com.dan323.coloring.Color;

import com.dan323.geometry.Ray;
import com.dan323.geometry.Vector;
import com.dan323.geometry.Point;

public interface GeometricObject {

    boolean hits(Ray ray);

    double distance(Ray ray);

    Vector getNormalAt(Point p);

}
