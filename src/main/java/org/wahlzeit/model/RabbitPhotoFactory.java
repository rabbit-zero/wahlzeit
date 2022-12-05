package org.wahlzeit.model;

import org.wahlzeit.services.SysLog;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RabbitPhotoFactory extends PhotoFactory{

    private static RabbitPhotoFactory instance = null;

    private static boolean isInitialized = false;

    public static synchronized RabbitPhotoFactory getInstance(){

        if(!isInitialized){
            SysLog.logSysInfo("setting specialized RabbitPhotoFactory");
            PhotoFactory.setInstance(new RabbitPhotoFactory());
            isInitialized = true;
        }

        return (RabbitPhotoFactory) PhotoFactory.getInstance();
    }

    public static void initialize(){
        getInstance();
    }


    /**
     * Method to set the singleton instance of PhotoFactory.
     */
    protected static synchronized void setInstance(RabbitPhotoFactory photoFactory) {
        if (instance != null) {
            throw new IllegalStateException("attempt to initialize PhotoFactory twice");
        }

        instance = photoFactory;
    }


    /**
     * @methodtype factory
     */
    public Photo createPhoto() {
        return new RabbitPhoto();
    }

    /**
     *
     */
    public Photo createPhoto(PhotoId id) {
        return new RabbitPhoto(id);
    }

    /**
     *
     */
    public Photo createPhoto(ResultSet rs) throws SQLException {
        return new RabbitPhoto(rs);
    }


}
