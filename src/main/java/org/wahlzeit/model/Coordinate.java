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
     *
     */
    public double getDistance(Coordinate destination){
        //ToDo
        return 0.00;
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
