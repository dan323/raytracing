package com.dan.geometry.objects.test.operation;

import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.PointUtils;
import com.dan.geometry.utils.Vector;
import com.dan.geometry.utils.VectorUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PointOperationsTest {
    @Test
    public void pointToPoint() {
        Point v1=new Point(1,1,1);
        Point v2=new Point(2,3,4);
        Assertions.assertEquals(PointUtils.toPoint(v1,v2),new Vector(1,2,3));
    }

    @Test
    public void pointTranslate(){
        Point v1=new Point(-1,5,2);
        Vector v2=new Vector(1,-5,0);
        Assertions.assertEquals(PointUtils.translate(v1,v2),new Point(0,0,2));
    }

    @Test
    public void pointsDistance(){
        Point v1=new Point(2,-1,4);
        Point v2=new Point(1,0,1);
        Assertions.assertEquals(PointUtils.distance(v1,v2),Math.sqrt(11),10E-5);
    }
}
