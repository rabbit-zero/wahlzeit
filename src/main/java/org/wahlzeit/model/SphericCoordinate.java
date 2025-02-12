package org.wahlzeit.model;


import org.wahlzeit.PatternInstance;

import java.util.Objects;

@PatternInstance(
        patternName = "Flyweight",
        participants = {"Concrete Flyweight"}
)

public class SphericCoordinate extends AbstractCoordinate {

    private final double phi;
    private final double theta;
    private final double radius;


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

        assertClassInvariants();
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
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        assertClassInvariants();

        double x = 0, y = 0, z = 0;

        try {
            x = radius * Math.sin(theta) * Math.cos(phi);
            y = radius * Math.sin(theta) * Math.sin(phi);
            z = radius * Math.cos(theta);
        } catch (ArithmeticException exception){
            System.out.println("Calculation in Conversin to CartesianCoordinate went wrong!");
        }

        assert (!Double.isNaN(x));
        assert (!Double.isNaN(y));
        assert (!Double.isNaN(z));

        assertClassInvariants();

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

        assertClassInvariants();

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
        assert (coordinate != null);

        assertClassInvariants();

        if (getClass() != coordinate.getClass()) return false;
        SphericCoordinate otherCoordinate = coordinate.asSphericCoordinate();
        if(otherCoordinate == null) throw new NullPointerException("Conversion to SphericCoordinate failed");
        assertClassInvariants();

        return Double.compare(otherCoordinate.phi, phi) == 0 && Double.compare(otherCoordinate.theta, theta) == 0 && Double.compare(otherCoordinate.radius, radius) == 0;
    }


    protected void assertClassInvariants(){
        assert (!Double.isNaN(phi));
        assert (!Double.isNaN(theta));
        assert (!Double.isNaN(radius));
    }
}
