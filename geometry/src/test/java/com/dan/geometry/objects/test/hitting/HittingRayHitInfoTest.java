package com.dan.geometry.objects.test.hitting;

import com.dan.geometry.hit.HitInfo;
import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.Ray;
import com.dan.geometry.utils.Vector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HittingRayHitInfoTest {

    @Test
    public void hittingRayNull(){
        Assertions.assertTrue(HitInfo.checkHitInfoActual(null,null));
    }

    @Test
    public void hittingRayHitInfoTest() {
        HitInfo hitInfo=new HitInfo(null) {
            @Override
            public boolean isHit() {
                return false;
            }

            @Override
            public double getDistance() {
                return 0;
            }
        };

        Assertions.assertTrue(HitInfo.checkHitInfoActual(hitInfo,null));

        Ray ray=new Ray(new Point(1,1,1),new Vector(1,1,1));
        Ray ray2=new Ray(new Point(1,1,1),new Vector(1,2,1));
        hitInfo=new HitInfo(ray) {
            @Override
            public boolean isHit() {
                return false;
            }

            @Override
            public double getDistance() {
                return 0;
            }
        };

        Assertions.assertFalse(HitInfo.checkHitInfoActual(hitInfo,ray));
        Assertions.assertTrue(HitInfo.checkHitInfoActual(hitInfo,ray2));
    }

}
