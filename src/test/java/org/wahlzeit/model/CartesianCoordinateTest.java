package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartesianCoordinateTest {

    private CartesianCoordinate cartesianCoordinate;
    private final double x = 90.5, y = 24.8, z = 80.5;

    @Before
    public void initLocation() {
       cartesianCoordinate = new CartesianCoordinate(x, y, z);
    }

    /**
     *
     */
    @Test
    public void testConstructor() {
        assertNotNull(cartesianCoordinate);

        // Check properties after creation
        assertEquals(x, cartesianCoordinate.getX(), 0);
        assertEquals(y, cartesianCoordinate.getY(), 0);
        assertEquals(z, cartesianCoordinate.getZ(), 0);

    }

    /**
     *
     */
    @Test
    public void testSetProperties() {
        double x = 0.815, y = 2.48, z = 20.17;
        cartesianCoordinate.setCoordinate(x, y, z);

        assertEquals(x, cartesianCoordinate.getX(), 0);
        assertEquals(y, cartesianCoordinate.getY(), 0);
        assertEquals(z, cartesianCoordinate.getZ(), 0);

    }


    /**
     *
     */
    @Test
    public void testGetDistance(){
        CartesianCoordinate a = new CartesianCoordinate(3, 6, 10);
        CartesianCoordinate b = new CartesianCoordinate(27, 76, 28);
        double calculatedDistance = 76.16;

        assertEquals(calculatedDistance, a.getCartesianDistance(b), 0.1);
    }


    /**
     *
     */
    @Test
    public void testEquals(){
        CartesianCoordinate a = new CartesianCoordinate(12.4, 394.87, 73.27);
        assertTrue(a.equals(a));

        CartesianCoordinate b = new CartesianCoordinate(73.7, 73.9, 73.2);
        assertFalse(a.equals(b));

    }


    /**
     *
     */
    @Test
    public void testAsCartesianCoordinate() {
        assertTrue(cartesianCoordinate.asCartesianCoordinate() instanceof CartesianCoordinate);
    }


    /**
     *
     */
    @Test
    public void testAsSphericCoordinate() {

        SphericCoordinate sphericCoordinate = cartesianCoordinate.asSphericCoordinate();

        assertTrue(sphericCoordinate instanceof SphericCoordinate);


        //in degree
        /*
        double calculatedRadius = 123.63;
        double calculatedPhi = 15.32;
        double calculatedTheta = 49.37;
        */

        //in RAD
        double calculatedRadius = 123.63;
        double calculatedPhi = 0.27;
        double calculatedTheta = 0.86;

        System.out.println(sphericCoordinate.getRadius());
        System.out.println(sphericCoordinate.getPhi());
        System.out.println(sphericCoordinate.getTheta());

        assertEquals(sphericCoordinate.getRadius(), calculatedRadius, 0.1);
        assertEquals(sphericCoordinate.getPhi(), calculatedPhi, 0.1);
        assertEquals(sphericCoordinate.getTheta(), calculatedTheta, 0.1);
    }

    /**
     *
     */
    @Test
    public void testGetCentralAngle() {

    }
}
