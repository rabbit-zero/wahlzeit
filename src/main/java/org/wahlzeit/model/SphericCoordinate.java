package org.wahlzeit.model;


import java.util.Objects;

public class SphericCoordinate extends AbstractCoordinate {

    private double phi;
    private double theta;
    private double radius;


    /**
     *
     * @methodtype constructor
     */
    public SphericCoordinate(double phi, double theta, double radius){
        assert (!Double.isNaN(phi));
        assert (!Double.isNaN(theta));
        assert (!Double.isNaN(radius));

        this.phi = phi;
        this.theta = theta;
        this.radius = radius;
    }

    /**
     *
     * @methodtype get
     */
    public double getPhi(){
        return phi;
    }

    /**
     *
     * @methodtype get
     */
    public double getTheta(){
        return theta;
    }

    /**
     *
     * @methodtype get
     */
    public double getRadius(){
        return radius;
    }

    /**
     *
     * @methodtype set
     */
    public void setCoordinate(double p, double t, double r){
        assert (!Double.isNaN(p));
        assert (!Double.isNaN(t));
        assert (!Double.isNaN(r));

        this.phi = p;
        this.theta = t;
        this.radius = r;
    }


    /**
     *
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        assertClassInvariants();

        double x = radius * Math.sin(theta) * Math.cos(phi);
        double y = radius * Math.sin(theta) * Math.sin(phi);
        double z = radius * Math.cos(theta);

        assert (!Double.isNaN(x));
        assert (!Double.isNaN(y));
        assert (!Double.isNaN(z));

        return new CartesianCoordinate(x, y, z);
    }

    /**
     *
     */
    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    /**
     *
     *
     */
    @Override
    public boolean equals(Object otherCoordinate) {
        assert (otherCoordinate instanceof Coordinate);
        assertClassInvariants();

        if (this == otherCoordinate) return true;
        if (getClass() != otherCoordinate.getClass()) return false;
        SphericCoordinate that = (SphericCoordinate) otherCoordinate;

        return isEqual(that);
    }

    /**
     *
     *
     */
    @Override
    public int hashCode() {
        assertClassInvariants();
        return Objects.hash(phi, theta, radius);
    }


    /**
     *
     */
    @Override
    public boolean isEqual(Coordinate coordinate) {
        assert (coordinate instanceof SphericCoordinate);

        assertClassInvariants();

        if (getClass() != coordinate.getClass()) return false;
        SphericCoordinate otherCoordinate = coordinate.asSphericCoordinate();
        return Double.compare(otherCoordinate.phi, phi) == 0 && Double.compare(otherCoordinate.theta, theta) == 0 && Double.compare(otherCoordinate.radius, radius) == 0;
    }


    protected void assertClassInvariants(){
        assert (!Double.isNaN(phi));
        assert (!Double.isNaN(theta));
        assert (!Double.isNaN(radius));
    }
}
