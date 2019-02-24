package com.dan323.geometry.objects.test;

import com.dan323.geometry.utils.Point;
import com.dan323.geometry.utils.Vector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EqualityTest {

    @Test
    public void EqualityPointTest() {
        Point p1=new Point(1,1,1);
        Point p2=new Point(1,1,1);
        Point p3=new Point(2,1,0);
        Point p4=new Point(1,2,0);
        Point p5=new Point(1,1,0);

        Assertions.assertEquals(p1, p2);
        Assertions.assertNotEquals(p1, p3);
        Assertions.assertNotEquals(p1, p4);
        Assertions.assertNotEquals(p1, p5);
    }

    @Test
    public void HashPointTest() {
        Point p1=new Point(1,1,1);
        Point p2=new Point(1,1,1);

        Assertions.assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    public void PointNotEqualVector(){
        Point p1=new Point(1,1,1);
        Vector v1=new Vector(1,1,1);

        Assertions.assertNotEquals(p1,v1);
    }


}
