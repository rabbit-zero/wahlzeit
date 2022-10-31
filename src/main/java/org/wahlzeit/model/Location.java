package org.wahlzeit.model;

import org.wahlzeit.services.*;

import java.sql.*;



public class Location extends DataObject {

    private Coordinate coordinate;
    private String name;

    private int id;
    static int idCounter = 0;

    /**
     *
     * @methodtype constructor
     */
    public Location(Coordinate coordinate){
        if(coordinate == null) throw new IllegalArgumentException();
        this.coordinate = coordinate;
        this.id = getNextId();
    }

    /**
     *
     * @methodtype constructor
     */
    public Location(Coordinate coordinate, String name){
        if(coordinate == null) throw new IllegalArgumentException();
        this.coordinate = coordinate;
        this.name = name;
        this.id = getNextId();
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
     * @methodtype get
     */
    public String getName(){
        return name;
    }


    /**
     *
     * @methodtype set
     */
    public void setCoordinate(Coordinate newCoordinate){
        coordinate = newCoordinate;
    }


    /**
     *
     * @methodtype set
     */
    public void setName(String newName){
        name = newName;
    }


    /**
     *
     * @methodtype set
     */
    private int getNextId(){ return ++idCounter; }



    @Override
    public void readFrom(ResultSet rset) throws SQLException {

        double x = rset.getDouble("x");
        double y = rset.getDouble("y");
        double z = rset.getDouble("z");

        coordinate = new Coordinate(x, y, z);
        name = rset.getString("name");

    }


    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        rset.updateInt("id", id);
        rset.updateString("name", name);
        rset.updateDouble("x", coordinate.getX());
        rset.updateDouble("y", coordinate.getY());
        rset.updateDouble("z", coordinate.getZ());
    }


    @Override
    public void writeId(PreparedStatement stmt, int pos) throws SQLException {
        stmt.setInt(pos, id);
    }


    /**
     * @methodtype get
     */
    public int getId() {
        return id;
    }

    /**
     *
     */
    @Override
    public String getIdAsString() {
        return String.valueOf(id);
    }


}
