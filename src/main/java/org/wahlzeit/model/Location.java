package org.wahlzeit.model;

import org.wahlzeit.services.*;

import java.sql.*;



public class Location extends DataObject {

    private CartesianCoordinate cartesianCoordinate;
    private String name;

    private int id;
    static int idCounter = 0;

    /**
     *
     * @methodtype constructor
     */
    public Location(CartesianCoordinate cartesianCoordinate){
        if(cartesianCoordinate == null) throw new IllegalArgumentException();
        this.cartesianCoordinate = cartesianCoordinate;
        this.id = getNextId();
    }

    /**
     *
     * @methodtype constructor
     */
    public Location(CartesianCoordinate cartesianCoordinate, String name){
        if(cartesianCoordinate == null) throw new IllegalArgumentException();
        this.cartesianCoordinate = cartesianCoordinate;
        this.name = name;
        this.id = getNextId();
    }

    /**
     *
     * @methodtype get
     */
    public CartesianCoordinate getCoordinate(){
        return cartesianCoordinate;
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
    public void setCoordinate(CartesianCoordinate newCartesianCoordinate){
        cartesianCoordinate = newCartesianCoordinate;
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

        cartesianCoordinate = new CartesianCoordinate(x, y, z);
        name = rset.getString("name");

    }


    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        rset.updateInt("id", id);
        rset.updateString("name", name);
        rset.updateDouble("x", cartesianCoordinate.getX());
        rset.updateDouble("y", cartesianCoordinate.getY());
        rset.updateDouble("z", cartesianCoordinate.getZ());
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
