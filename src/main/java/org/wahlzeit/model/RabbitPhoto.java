package org.wahlzeit.model;


import java.sql.ResultSet;
import java.sql.SQLException;



public class RabbitPhoto extends Photo{


    private String rabbitName;
    private String rabbitRace;


    /**
     *
     * @methodtype constructor
     */
    public RabbitPhoto(String name, String race){
        this.rabbitName = name;
        this.rabbitRace = race;

        id = PhotoId.getNextId();
        incWriteCount();

    }

    /**
     *
     * @methodtype constructor
     */
    public RabbitPhoto(PhotoId myId, String name, String race) {
        id = myId;

        this.rabbitName = name;
        this.rabbitRace = race;

        incWriteCount();
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
