package org.wahlzeit.model;

import java.util.Objects;

public class Coordinate {

    private double x;
    private double y;
    private double z;


    /**
     *
     * @methodtype constructor
     */
    public Coordinate(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     *
     * @methodtype get
     */
    public double getX(){
        return x;
    }

    /**
     *
     * @methodtype get
     */
    public double getY(){
        return y;
    }

    /**
     *
     * @methodtype get
     */
    public double getZ(){
        return z;
    }

    /**
     *
     * @methodtype set
     */
    public void setCoordinates(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }


    /**
     *
     * @methodtype get
     */
    public double getDistance(Coordinate otherCoordinate){
        double a = otherCoordinate.getX() - x;
        double b = otherCoordinate.getY() - y;
        double c = otherCoordinate.getZ() - z;
        double sum_square = Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2);

        return Math.sqrt(sum_square);
    }

    /**
     *
     *
     */
    @Override
    public boolean equals(Object otherCoordinate) {
        if (this == otherCoordinate) return true;
        if (otherCoordinate == null || getClass() != otherCoordinate.getClass()) return false;
        Coordinate that = (Coordinate) otherCoordinate;
        return isEqual(that);
    }

    /**
     *
     *
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    /**
     *
     *
     */
    public boolean isEqual(Coordinate otherCoordinate){
        return otherCoordinate.getX() == x && otherCoordinate.getY() == y && otherCoordinate.getZ() == z;
    }


}
