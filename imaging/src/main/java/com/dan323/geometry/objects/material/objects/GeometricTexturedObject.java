package com.dan323.geometry.objects.material.objects;

import com.dan323.geometry.Point;
import com.dan323.geometry.objects.GeometricObject;
import com.dan323.geometry.objects.material.Color;

public interface GeometricTexturedObject extends GeometricObject {

    Color getColor(Point p);

}
