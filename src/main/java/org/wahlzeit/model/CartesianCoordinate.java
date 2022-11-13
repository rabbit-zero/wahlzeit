package org.wahlzeit.model;

import java.util.Objects;

public class CartesianCoordinate implements Coordinate{

    private double x;
    private double y;
    private double z;


    /**
     *
     * @methodtype constructor
     */
    public CartesianCoordinate(double x, double y, double z){
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
    public void setCoordinate(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }


    /**
     *
     * @methodtype get
     */
    public double getDistance(CartesianCoordinate otherCartesianCoordinate){
        double a = otherCartesianCoordinate.getX() - x;
        double b = otherCartesianCoordinate.getY() - y;
        double c = otherCartesianCoordinate.getZ() - z;
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
        CartesianCoordinate that = (CartesianCoordinate) otherCoordinate;
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
    @Override
    public boolean isEqual(Coordinate coordinate){
        CartesianCoordinate otherCoordinate = coordinate.asCartesianCoordinate();
        return Double.compare(otherCoordinate.x, x) == 0 && Double.compare(otherCoordinate.y, y) == 0 && Double.compare(otherCoordinate.z, z) == 0;
    }

    /**
     *
     *
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    /**
     *
     *
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        return getDistance(coordinate.asCartesianCoordinate());
    }

    /**
     *
     *
     */
    @Override
    public SphericCoordinate asSphericCoordinate() {
        double radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
        double theta = Math.acos( z / radius);

        double phi;

        if (x > 0){

            if ( y >= 0) {
                phi = Math.atan( y / x);

            }else {
                phi = Math.atan( y / x) + 2 * Math.PI;
            }

        }else if (x < 0){
            phi = Math.atan(y / x) + Math.PI;

        }else {
            phi = Math.signum(y) * Math.PI / 2;
        }

        return new SphericCoordinate(phi, theta, radius);
    }

    /**
     *
     *
     */
    @Override
    public double getCentralAngle(Coordinate coordinate) {
        return this.asSphericCoordinate().getCentralAngle(coordinate);
    }
}
