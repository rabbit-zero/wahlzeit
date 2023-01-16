package org.wahlzeit.model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class RabbitPhoto extends Photo{


    private ArrayList<Rabbit> rabbits = new ArrayList<>();

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
    public RabbitPhoto(ArrayList<Rabbit> r){
        rabbits = r;

        id = PhotoId.getNextId();
        assert (id != null);

        incWriteCount();

    }

    /**
     *
     * @methodtype constructor
     */
    public RabbitPhoto(PhotoId myId, ArrayList<Rabbit> r) {
        if (myId == null) throw new IllegalArgumentException();

        id = myId;
        rabbits = r;
        incWriteCount();
    }


    public RabbitPhoto(ResultSet rset) throws SQLException {
        readFrom(rset);
    }



    /**
     *
     */
    @Override
    public void readFrom(ResultSet rset) throws SQLException {
        super.readFrom(rset);
    }


    /**
     *
     */
    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        super.writeOn(rset);

    }


}
