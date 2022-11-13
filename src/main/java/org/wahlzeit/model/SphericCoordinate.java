package org.wahlzeit.model;

import javax.swing.text.html.HTMLDocument;

public class SphericCoordinate implements Coordinate {

    private double phi;
    private double theta;
    private double radius;


    /**
     *
     * @methodtype constructor
     */
    public SphericCoordinate(double phi, double theta, double radius){
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
        this.phi = p;
        this.theta = t;
        this.radius = r;
    }


    /**
     *
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        double x = radius * Math.sin(theta) * Math.cos(phi);
        double y = radius * Math.sin(theta) * Math.sin(phi);
        double z = radius * Math.cos(theta);

        return new CartesianCoordinate(x, y, z);
    }

    /**
     *
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        CartesianCoordinate otherCoordinate = coordinate.asCartesianCoordinate();
        return otherCoordinate.getDistance(asCartesianCoordinate());
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
     */
    @Override
    public double getCentralAngle(Coordinate coordinate) {
        SphericCoordinate otherCoordinate = coordinate.asSphericCoordinate();
        double deltaLamda = Math.abs(phi - otherCoordinate.getPhi());
        double numerator = Math.pow(Math.cos(otherCoordinate.theta) * Math.sin(deltaLamda), 2) + 
                Math.pow(Math.cos(theta) * Math.sin(otherCoordinate.theta) - Math.sin(theta) * Math.cos(otherCoordinate.theta) * Math.cos(deltaLamda) ,2);
        
        double denominator = Math.sin(theta) * Math.sin(otherCoordinate.theta) + 
                Math.cos(theta) * Math.cos(otherCoordinate.theta) * Math.cos(deltaLamda); 

        return Math.atan(Math.sqrt(numerator) / denominator);
    }

    /**
     *
     */
    @Override
    public boolean isEqual(Coordinate coordinate) {
        SphericCoordinate otherCoordinate = coordinate.asSphericCoordinate();
        return Double.compare(otherCoordinate.phi, phi) == 0 && Double.compare(otherCoordinate.theta, theta) == 0 && Double.compare(otherCoordinate.radius, radius) == 0;
    }
}
