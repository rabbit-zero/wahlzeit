package org.wahlzeit.model;

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
        //formula √[(x₂ - x₁)² + (y₂ - y₁)²]
        //pythagoras a, b, c
        double a = otherCoordinate.getX() - x;
        double b = otherCoordinate.getY() - y;
        double c_square = Math.pow(a, 2) + Math.pow(b, 2);

        return Math.sqrt(c_square);
    }


    /**
     *
     *
     */
    public boolean isEqual(Coordinate otherCoordinate){
        //ToDo
        return false;
    }


}
