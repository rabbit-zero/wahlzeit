package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate{

    /**
     *
     * @methodtype get
     */
    public double calculateDistance(CartesianCoordinate otherCartesianCoordinate, CartesianCoordinate coordinate){
        double a = otherCartesianCoordinate.getX() - coordinate.getX();
        double b = otherCartesianCoordinate.getY() - coordinate.getY();
        double c = otherCartesianCoordinate.getZ() - coordinate.getZ();
        double sum_square = Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2);

        return Math.sqrt(sum_square);
    }


    /**
     *
     *
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        return calculateDistance(coordinate.asCartesianCoordinate(), this.asCartesianCoordinate());
    }


    /**
     *
     */
    public double calculateCentralAngle(Coordinate coordinate, Coordinate coordinate2) {
        SphericCoordinate otherCoordinate = coordinate.asSphericCoordinate();
        SphericCoordinate sphericCoordinate = coordinate2.asSphericCoordinate();
        double deltaLamda = Math.abs(sphericCoordinate.getPhi() - otherCoordinate.getPhi());
        double numerator = Math.pow(Math.cos(otherCoordinate.getTheta()) * Math.sin(deltaLamda), 2) +
                Math.pow(Math.cos(sphericCoordinate.getTheta()) * Math.sin(otherCoordinate.getTheta()) -
                        Math.sin(sphericCoordinate.getTheta()) * Math.cos(otherCoordinate.getTheta()) * Math.cos(deltaLamda) ,2);

        double denominator = Math.sin(sphericCoordinate.getTheta()) * Math.sin(otherCoordinate.getTheta()) +
                Math.cos(sphericCoordinate.getTheta()) * Math.cos(otherCoordinate.getTheta()) * Math.cos(deltaLamda);

        return Math.atan(Math.sqrt(numerator) / denominator);
    }


    /**
     *
     *
     */
    @Override
    public double getCentralAngle(Coordinate coordinate) {
        return calculateCentralAngle(coordinate.asSphericCoordinate(), this.asSphericCoordinate());
    }

}
