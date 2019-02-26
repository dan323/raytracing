package com.dan.geometry.objects.test.operation;

import com.dan.geometry.utils.Vector;
import com.dan.geometry.utils.VectorUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VectorOperationsTest {

    @Test
    public void vectorSumTest() {
        Vector v1=new Vector(1,1,1);
        Vector v2=new Vector(2,3,4);
        Assertions.assertEquals(VectorUtils.add(v1,v2),new Vector(3,4,5));
    }

    @Test
    public void vectorDotTest(){
        Vector v1=new Vector(-1,5,2);
        Vector v2=new Vector(1,-5,0);
        Assertions.assertEquals(VectorUtils.dot(v1,v2),-26);
    }

    @Test
    public void vectorCrossTest(){
        Vector v1=new Vector(2,-1,4);
        Vector v2=new Vector(1,0,1);
        Assertions.assertEquals(VectorUtils.cross(v1,v2),new Vector(-1,2,1));
    }

}
