package org.wahlzeit.model;


import java.sql.ResultSet;
import java.sql.SQLException;



public class RabbitPhoto extends Photo{


    private String rabbitName;
    private String rabbitRace;

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
    public RabbitPhoto(String name, String race){
        this.rabbitName = name;
        this.rabbitRace = race;

        id = PhotoId.getNextId();
        assert (id != null);

        incWriteCount();

    }

    /**
     *
     * @methodtype constructor
     */
    public RabbitPhoto(PhotoId myId, String name, String race) {
        if (myId == null) throw new IllegalArgumentException();

        id = myId;

        this.rabbitName = name;
        this.rabbitRace = race;

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
    public String getRabbitRace(){
        return rabbitRace;

    }


    /**
     *
     */
    @Override
    public void readFrom(ResultSet rset) throws SQLException {
        super.readFrom(rset);

        rabbitName = rset.getString("name");
        rabbitRace = rset.getString("race");
    }


    /**
     *
     */
    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        super.writeOn(rset);

        rset.updateString("name", rabbitName);
        rset.updateString("race", rabbitRace);
    }


}
