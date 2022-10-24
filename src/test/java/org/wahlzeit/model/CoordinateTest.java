package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CoordinateTest {

    private Coordinate coordinate;
    private final double x = 90.5, y = 24.8, z = 80.5;

    @Before
    public void initLocation() {
       coordinate = new Coordinate(x, y, z);
    }

    /**
     *
     */
    @Test
    public void testConstructor() {
        assertNotNull(coordinate);

        // Check properties after creation
        assertEquals(x, coordinate.getX(), 0);
        assertEquals(y, coordinate.getY(), 0);
        assertEquals(z, coordinate.getZ(), 0);

    }

    /**
     *
     */
    @Test
    public void testSetProperties() {
        double x = 0.815, y = 2.48, z = 20.17;
        coordinate.setCoordinates(x, y, z);

        assertEquals(x, coordinate.getX(), 0);
        assertEquals(y, coordinate.getY(), 0);
        assertEquals(z, coordinate.getZ(), 0);

    }

}
