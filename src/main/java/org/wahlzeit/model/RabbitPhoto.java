package org.wahlzeit.model;


import java.sql.ResultSet;
import java.sql.SQLException;



public class RabbitPhoto extends Photo{


    private String rabbitName;
    private short rabbitAge;

    public RabbitPhoto(){
        id = PhotoId.getNextId();
        incWriteCount();
    }


    public RabbitPhoto(PhotoId myId){
        if (myId == null) throw new IllegalArgumentException();

        id = myId;
        incWriteCount();
    }

    /**
     *
     * @methodtype constructor
     */
    public RabbitPhoto(String name, short age){
        this.rabbitName = name;
        this.rabbitAge = age;

        id = PhotoId.getNextId();
        assert (id != null);

        incWriteCount();

    }

    /**
     *
     * @methodtype constructor
     */
    public RabbitPhoto(PhotoId myId, String name, short age) {
        if (myId == null) throw new IllegalArgumentException();

        id = myId;

        this.rabbitName = name;
        this.rabbitAge = age;

        incWriteCount();
    }


    public RabbitPhoto(ResultSet rset) throws SQLException {
        readFrom(rset);
    }


    /**
     *
     * @methodtype get
     */
    public String getRabbitName(){
        return rabbitName;
    }

    /**
     *
     * @methodtype get
     */
    public short getrabbitAge(){
        return rabbitAge;

    }


    /**
     *
     */
    @Override
    public void readFrom(ResultSet rset) throws SQLException {
        super.readFrom(rset);

        rabbitName = rset.getString("name");
        rabbitAge = rset.getShort("age");
    }


    /**
     *
     */
    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        super.writeOn(rset);

        rset.updateString("name", rabbitName);
        rset.updateShort("age", rabbitAge);
    }


}
