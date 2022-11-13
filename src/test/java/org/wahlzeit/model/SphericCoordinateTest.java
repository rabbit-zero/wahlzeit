package org.wahlzeit.model;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SphericCoordinateTest {

    private SphericCoordinate sphericCoordinate;
    private final double phi = 82.8, theta = 98.5, radius = 20;

    @Before
    public void initLocation() {
        sphericCoordinate = new SphericCoordinate(phi, theta, radius);
    }

    /**
     *
     */
    @Test
    public void testSetCoordinate() {
        double p = 2.8, t = 9.5, r = 10;

        SphericCoordinate sphericCoordinate = new SphericCoordinate(p, t, r);

        assertEquals(p, sphericCoordinate.getPhi(), 0.0);
        assertEquals(t, sphericCoordinate.getTheta(), 0.0);
        assertEquals(r, sphericCoordinate.getRadius(), 0.0);
    }

    /**
     *
     */
    @Test
    public void testAsCartesianCoordinate() {
        assertTrue(sphericCoordinate.asCartesianCoordinate() instanceof CartesianCoordinate);
    }

    /**
     *
     */
    @Test
    public void testGetCartesianDistance() {
        CartesianCoordinate a = new CartesianCoordinate(3, 6, 10);
        CartesianCoordinate b = sphericCoordinate.asCartesianCoordinate();

        System.out.println(b.getX());
        System.out.println(b.getY());
        System.out.println(b.getZ());

        double calculatedDistance = 31.03;

        System.out.println(b.getCartesianDistance(a));
        assertEquals(calculatedDistance, b.getCartesianDistance(a), 0.3);


    }

    /**
     *
     */
    @Test
    public void testAsSphericCoordinate() {
        assertTrue(sphericCoordinate.asSphericCoordinate() instanceof SphericCoordinate);
    }

    /**
     *
     */
    @Test
    public void testGetCentralAngle() {

    }

    /**
     *
     */
    @Test
    public void testIsEqual() {
        double p1 = 82.8, t1 = 98.5, r1 = 20;
        SphericCoordinate sameCoordinate = new SphericCoordinate(p1, t1, r1);
        assertTrue(sphericCoordinate.isEqual(sameCoordinate));

        double p2 = 7.6, t2 = 4.2, r2 = -2;
        SphericCoordinate otherCoordinate = new SphericCoordinate(p2, t2, r2);
        assertFalse(sphericCoordinate.isEqual(otherCoordinate));

    }
}