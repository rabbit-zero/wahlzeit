package org.wahlzeit.model;


public abstract class AbstractCoordinate implements Coordinate{

    /**
     *
     * @methodtype get
     */
    public double calculateDistance(CartesianCoordinate otherCartesianCoordinate, CartesianCoordinate coordinate){
        assert (coordinate!= null);
        assert (otherCartesianCoordinate != null);

        double a = otherCartesianCoordinate.getX() - coordinate.getX();
        assert (!Double.isNaN(a));
        double b = otherCartesianCoordinate.getY() - coordinate.getY();
        assert (!Double.isNaN(b));
        double c = otherCartesianCoordinate.getZ() - coordinate.getZ();
        assert (!Double.isNaN(c));
        double sum_square = Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2);


        assert (!Double.isNaN(sum_square));

        return Math.sqrt(sum_square);
    }


    /**
     *
     *
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        assert (coordinate != null);

        return calculateDistance(coordinate.asCartesianCoordinate(), this.asCartesianCoordinate());
    }


    /**
     *
     */
    public double calculateCentralAngle(Coordinate coordinate, Coordinate coordinate2) {
        assert (coordinate!= null);
        assert (coordinate2!= null);

        SphericCoordinate otherCoordinate = coordinate.asSphericCoordinate();
        SphericCoordinate sphericCoordinate = coordinate2.asSphericCoordinate();
        double deltaLamda = Math.abs(sphericCoordinate.getPhi() - otherCoordinate.getPhi());
        double numerator = Math.pow(Math.cos(otherCoordinate.getTheta()) * Math.sin(deltaLamda), 2) +
                Math.pow(Math.cos(sphericCoordinate.getTheta()) * Math.sin(otherCoordinate.getTheta()) -
                        Math.sin(sphericCoordinate.getTheta()) * Math.cos(otherCoordinate.getTheta()) * Math.cos(deltaLamda) ,2);

        double denominator = Math.sin(sphericCoordinate.getTheta()) * Math.sin(otherCoordinate.getTheta()) +
                Math.cos(sphericCoordinate.getTheta()) * Math.cos(otherCoordinate.getTheta()) * Math.cos(deltaLamda);

        assert (!Double.isNaN(numerator));
        assert (!Double.isNaN(denominator) && denominator != 0);

        return Math.atan(Math.sqrt(numerator) / denominator);
    }


    /**
     *
     *
     */
    @Override
    public double getCentralAngle(Coordinate coordinate) {
        assert (coordinate != null);

        return calculateCentralAngle(coordinate.asSphericCoordinate(), this.asSphericCoordinate());
    }

}
