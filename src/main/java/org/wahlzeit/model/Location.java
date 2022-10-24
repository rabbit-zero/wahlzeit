package org.wahlzeit.model;

public class Location {

    private Coordinate coordinate;

    /**
     *
     * @methodtype constructor
     */
    public Location(Coordinate coordinate){
        if(coordinate == null) throw new IllegalArgumentException();
        this.coordinate = coordinate;
    }

    /**
     *
     * @methodtype get
     */
    public Coordinate getCoordinate(){
        return coordinate;
    }

    /**
     *
     * @methodtype set
     */
    public void setCoordinate(Coordinate newCoordinate){
        coordinate = newCoordinate;
    }



}
