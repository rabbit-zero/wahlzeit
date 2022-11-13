package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class LocationTest {

    private Location location;
    private final double x = 90.5, y = 24.8, z = 80.5;

    @Before
    public void initLocation() {

        CartesianCoordinate testCartesianCoordinate = new CartesianCoordinate(x, y, z);
        location = new Location(testCartesianCoordinate);
    }

    /**
     *
     */
    @Test
    public void testConstructor() {
        assertNotNull(location);

        // Check properties after creation
        assertEquals(x, location.getCoordinate().getX(), 0);
        assertEquals(y, location.getCoordinate().getY(), 0);
        assertEquals(z, location.getCoordinate().getZ(), 0);

    }

}
