package com.dan323.geometry.objects.test;

import com.dan323.geometry.hit.HitInfo;
import com.dan323.geometry.utils.Point;
import com.dan323.geometry.utils.Ray;
import com.dan323.geometry.utils.Vector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HittingRayHitInfoTest {

    @Test
    public void HittingRayHitInfoTest() {
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

        Assertions.assertTrue(HitInfo.checkHitInfoActual(null,null));
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
