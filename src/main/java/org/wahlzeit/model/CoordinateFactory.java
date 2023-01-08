package org.wahlzeit.model;

import org.wahlzeit.PatternInstance;
import org.wahlzeit.services.SysLog;

import java.util.concurrent.ConcurrentHashMap;


@PatternInstance(
        patternName = "Flyweight",
        participants = {"FlyweightFactory Object"}
)


public class CoordinateFactory {

    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    private static CoordinateFactory instance = null;
    private static ConcurrentHashMap<Integer, Coordinate> allInstances = new ConcurrentHashMap<>();

    /**
     * Public singleton access method.
     */
    public static synchronized CoordinateFactory getInstance() {
        if (instance == null) {
            SysLog.logSysInfo("setting CoordinateFactory");
            setInstance(new CoordinateFactory());
        }

        return instance;
    }

    /**
     * Method to set the singleton instance of PhotoFactory.
     */
    protected static synchronized void setInstance(CoordinateFactory coordinateFactory) {
        if (instance != null) {
            throw new IllegalStateException("attempt to initialize CoordinateFactory twice");
        }

        instance = coordinateFactory;
    }

    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    public static void initialize() {
        getInstance(); // drops result due to getInstance() side-effects
    }

    /**
     *
     */
    protected CoordinateFactory() {
        // do nothing
    }

    /**
     * @methodtype factory
     */
    public Coordinate createCartesianCoordinate(double x, double y, double z) {
        Coordinate coord = new CartesianCoordinate(x, y, z);

        return makeShared(coord);
    }

    /**
     *
     */
    public Coordinate createSphericCoordinate(double phi, double theta, double r) {
        Coordinate coord = new SphericCoordinate(phi, theta, r);

        return makeShared(coord);
    }


    private Coordinate makeShared(Coordinate coord){

        if (allInstances.containsKey(coord.hashCode())){

            return allInstances.replace(coord.hashCode(), coord);

        } else {

            return allInstances.put(coord.hashCode(), coord);
        }

    }



}
