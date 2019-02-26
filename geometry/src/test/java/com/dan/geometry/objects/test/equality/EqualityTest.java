package com.dan.geometry.objects.test.equality;

import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.Vector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EqualityTest {

    @Test
    public void equalityPointTest() {
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
    public void hashPointTest() {
        Point p1=new Point(1,1,1);
        Point p2=new Point(1,1,1);

        Assertions.assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    public void pointNotEqualVectorOrOtherClass(){
        Point p1=new Point(1,1,1);
        Vector v1=new Vector(1,1,1);

        Assertions.assertNotEquals(p1,this);
        Assertions.assertNotEquals(p1,v1);
        Assertions.assertNotEquals(v1,p1);

        Assertions.assertNotEquals(v1.hashCode(),p1.hashCode());
    }

    @Test
    public void equalityVectorTest(){
        Vector p1=new Vector(1,1,1);
        Vector p2=new Vector(1,1,1);
        Vector p3=new Vector(2,1,0);
        Vector p4=new Vector(1,2,0);
        Vector p5=new Vector(1,1,0);

        Assertions.assertEquals(p1, p2);
        Assertions.assertNotEquals(p1, p3);
        Assertions.assertNotEquals(p1, p4);
        Assertions.assertNotEquals(p1, p5);
    }

    @Test
    public void toStringTest(){
        Vector v1=new Vector(1,1,1);
        Point p1=new Point(1,1,1);

        Assertions.assertTrue(v1.toString().matches("\\{([^}]+)}"));
        Assertions.assertEquals(v1.toString(), p1.toString());
    }

}
