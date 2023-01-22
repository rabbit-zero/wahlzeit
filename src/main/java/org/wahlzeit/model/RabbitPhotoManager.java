package org.wahlzeit.model;

import org.wahlzeit.main.ServiceMain;
import org.wahlzeit.services.SysLog;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RabbitPhotoManager extends PhotoManager{

    protected static final RabbitPhotoManager instance = new RabbitPhotoManager();


    public static RabbitPhotoManager getInstance(){
        return instance;
    }


    @Override
    public void addPhoto(Photo photo) {
        SysLog.logSysInfo("Rabbit photo added");
        PhotoId id = photo.getId();
        super.assertIsNewPhoto(id);
        super.doAddPhoto(photo);

        try {
            PreparedStatement stmt = getReadingStatement("INSERT INTO rabbit_photos(id) VALUES(?)");
            createObject(photo, stmt, id.asInt());
            ServiceMain.getInstance().saveGlobals();
        } catch (SQLException sex) {
            SysLog.logThrowable(sex);
        }
    }

    public void loadPhotos(Collection<Photo> result) {
        try {
            PreparedStatement stmt = getReadingStatement("SELECT * FROM rabbit_photos");
            readObjects(result, stmt);
            for (Iterator<Photo> i = result.iterator(); i.hasNext(); ) {
                Photo photo = i.next();
                if (!doHasPhoto(photo.getId())) {
                    doAddPhoto(photo);
                } else {
                    SysLog.logSysInfo("rabbit_photo", photo.getId().asString(), "photo had already been loaded");
                }
            }
        } catch (SQLException sex) {
            SysLog.logThrowable(sex);
        }

        SysLog.logSysInfo("loaded all photos");
    }

    /**
     *
     */
    public void savePhoto(Photo photo) {
        try {
            PreparedStatement stmt = getUpdatingStatement("SELECT * FROM rabbit_photos WHERE id = ?");
            updateObject(photo, stmt);
        } catch (SQLException sex) {
            SysLog.logThrowable(sex);
        }
    }

    /**
     *
     */
    public void savePhotos() {
        try {
            PreparedStatement stmt = getUpdatingStatement("SELECT * FROM rabbit_photos WHERE id = ?");
            updateObjects(photoCache.values(), stmt);
        } catch (SQLException sex) {
            SysLog.logThrowable(sex);
        }
    }

    /**
     * @methodtype command
     *
     * Persists all available sizes of the Photo. If one size exceeds the limit of the persistence layer, e.g. > 1MB for
     * the Datastore, it is simply not persisted.
     */
    public Set<Photo> findPhotosByOwner(String ownerName) {
        Set<Photo> result = new HashSet<Photo>();
        try {
            PreparedStatement stmt = getReadingStatement("SELECT * FROM rabbit_photos WHERE owner_name = ?");
            readObjects(result, stmt, ownerName);
        } catch (SQLException sex) {
            SysLog.logThrowable(sex);
        }

        for (Iterator<Photo> i = result.iterator(); i.hasNext(); ) {
            doAddPhoto(i.next());
        }

        return result;
    }


}


