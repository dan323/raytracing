package com.dan.geometry.phong.texture;

import com.dan.geometry.phong.material.Material;
import com.dan.geometry.objects.GeometricObject;
import com.dan.geometry.utils.Point;

public interface GeometricTexturedObject extends GeometricObject {

    Material getMaterial(Point p);

}
