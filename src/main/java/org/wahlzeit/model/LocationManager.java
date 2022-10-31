package org.wahlzeit.model;

import org.wahlzeit.services.ObjectManager;
import org.wahlzeit.services.SysLog;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationManager extends ObjectManager {


    @Override
    protected Location createObject(ResultSet rset) throws SQLException {
        Location locationObj = null;

        double x = rset.getDouble("x");
        double y = rset.getDouble("y");
        double z = rset.getDouble("z");

        Coordinate locCoordinate = new Coordinate(x, y, z);

        String name = rset.getString("name");

        locationObj = new Location(locCoordinate, name);


        return locationObj;
    }

    public void addLocation(Location location) {
        assertIsNonNullArgument(location);
        assertIsNonNullArgument(location.getCoordinate());

        try {
            int id = location.getId();
            Coordinate coordinate = location.getCoordinate();
            String name = location.getName();
            PreparedStatement stmt = getReadingStatement("INSERT INTO locations (id, name, x, y, z) VALUES(?,?,?,?,?)");
            //createObject(location, stmt, id);

            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setDouble(3, coordinate.getX());
            stmt.setDouble(4, coordinate.getY());
            stmt.setDouble(5, coordinate.getZ());

            SysLog.logQuery(stmt);
            stmt.executeUpdate();

        } catch (SQLException exception) {
            SysLog.logThrowable(exception);
        }
    }

    /**
     *
     */
    public void deleteLocation(Location location) {
        assertIsNonNullArgument(location);

        try {
            PreparedStatement stmt = getReadingStatement("DELETE FROM locations WHERE id = ?");
            deleteObject(location, stmt);
        } catch (SQLException exception) {
            SysLog.logThrowable(exception);
        }

    }


    /**
     *
     */
    public void saveLocation(Location location) {
        try {
            PreparedStatement stmt = getUpdatingStatement("SELECT * FROM locations WHERE id = ?");
            updateObject(location, stmt);
        } catch (SQLException exception) {
            SysLog.logThrowable(exception);
        }
    }
}
