package org.wahlzeit.model;

import java.util.Objects;


public class CartesianCoordinate extends AbstractCoordinate{

    private double x;
    private double y;
    private double z;


    /**
     *
     * @methodtype constructor
     */
    public CartesianCoordinate(double x, double y, double z){
        assert (!Double.isNaN(x));
        assert (!Double.isNaN(y));
        assert (!Double.isNaN(z));

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
        assert (!Double.isNaN(x));
        assert (!Double.isNaN(y));
        assert (!Double.isNaN(z));

        this.x = x;
        this.y = y;
        this.z = z;
    }


    /**
     *
     *
     */
    @Override
    public boolean equals(Object otherCoordinate) {
        assert (otherCoordinate instanceof CartesianCoordinate);

        if (this == otherCoordinate) return true;
        if (getClass() != otherCoordinate.getClass()) return false;
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
        assert (coordinate instanceof CartesianCoordinate);

        assertClassInvariants();

        if (getClass() != coordinate.getClass()) return false;
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
    public SphericCoordinate asSphericCoordinate() {
        assertClassInvariants();

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


        assert (!Double.isNaN(phi));
        assert (!Double.isNaN(theta));
        assert (!Double.isNaN(radius));

        return new SphericCoordinate(phi, theta, radius);
    }


    protected void assertClassInvariants(){
        assert (!Double.isNaN(x));
        assert (!Double.isNaN(y));
        assert (!Double.isNaN(z));
    }

}
