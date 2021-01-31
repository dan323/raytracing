package com.dan.geometry.objects.test.hitting;

import com.dan.geometry.hit.HitInfo;
import com.dan.geometry.utils.Point;
import com.dan.geometry.utils.Ray;
import com.dan.geometry.utils.Vector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.dan.geometry.hit.HitInfo.checkHitInfoActual;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HittingRayHitInfoTest {

    @Test
    public void hittingRayNull() {
        assertTrue(checkHitInfoActual(null, null));
    }

    @Test
    public void hittingRayHitInfoTest() {
        HitInfo hitInfo = new HitInfo(null) {
            @Override
            public boolean isHit() {
                return false;
            }

            @Override
            public double getDistance() {
                return 0;
            }
        };

        assertTrue(checkHitInfoActual(hitInfo, null));

        Ray ray = new Ray(new Point(1, 1, 1), new Vector(1, 1, 1));
        Ray ray2 = new Ray(new Point(1, 1, 1), new Vector(1, 2, 1));
        hitInfo = new HitInfo(ray) {
            @Override
            public boolean isHit() {
                return false;
            }

            @Override
            public double getDistance() {
                return 0;
            }
        };

        assertFalse(checkHitInfoActual(hitInfo, ray));
        assertTrue(checkHitInfoActual(hitInfo, ray2));
    }

}
