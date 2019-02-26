package com.dan.geometry.phong.texture.test;

import com.dan.geometry.phong.material.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ColorTest {

    @Test
    public void maxColor(){
        assertColor(new Color(4,1,0));
        assertColor(new Color(4,1,7));
        assertColor(new Color(-1,5,0));
    }

    private void assertColor(Color c) {
        Assertions.assertTrue(c.getB()<=1);
        Assertions.assertTrue(c.getR()<=1);
        Assertions.assertTrue(c.getG()<=1);
        Assertions.assertTrue(c.getB()>=0);
        Assertions.assertTrue(c.getR()>=0);
        Assertions.assertTrue(c.getG()>=0);
    }

    @Test
    public void builtInColors(){
        Assertions.assertEquals(Color.BLACK,new Color(0,0,0));
        Assertions.assertEquals(Color.WHITE,new Color(1,1,1));
        Assertions.assertEquals(Color.BLUE,new Color(0,0,1));
        Assertions.assertEquals(Color.RED,new Color(1,0,0));
        Assertions.assertEquals(Color.GREEN,new Color(0,1,0));
    }
}
