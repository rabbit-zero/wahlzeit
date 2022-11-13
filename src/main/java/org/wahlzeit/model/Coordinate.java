package org.wahlzeit.model;

public interface Coordinate {

    public CartesianCoordinate asCartesianCoordinate();

    public double getCartesianDistance(Coordinate otherCoordinate);

    public SphericCoordinate asSphericCoordinate();

    public double getCentralAngle(Coordinate coordinate);

    public boolean isEqual(Coordinate otherCoordinate);

}
