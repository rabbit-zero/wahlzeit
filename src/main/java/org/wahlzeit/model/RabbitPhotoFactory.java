package org.wahlzeit.model;

import org.wahlzeit.services.SysLog;

public class RabbitPhotoFactory extends PhotoFactory{

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


}
