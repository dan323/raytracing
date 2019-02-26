package com.dan.geometry.objects.test.operation;

import com.dan.geometry.utils.Vector;
import com.dan.geometry.utils.VectorUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VectorOpsTest {

    @Test
    public void reflectTest(){
        Vector v=new Vector(1,1,0);
        Vector n=new Vector(0,1,0);
        Assertions.assertEquals(new Vector(1,-1,0), VectorUtils.reflect(v,n));
    }

    @Test
    public void refractTest(){
        Vector v=new Vector(1,1,0);
        Vector n=new Vector(0,1,0);
        Assertions.assertEquals(v.normalize(),VectorUtils.refract(v,n,1,1));
    }
}
