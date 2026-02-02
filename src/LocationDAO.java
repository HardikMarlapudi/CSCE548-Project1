import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LocationDAO {

    // CREATE: add a new location
    public void addLocation(Location location) {
        String sql = "INSERT INTO locations (city, state, country) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, location.getCity());
            ps.setString(2, location.getState());
            ps.setString(3, location.getCountry());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ: get all locations
    public ArrayList<Location> getAllLocations() {
        ArrayList<Location> locations = new ArrayList<>();
        String sql = "SELECT * FROM locations";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                locations.add(new Location(
                        rs.getInt("location_id"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("country")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return locations;
    }

    // READ: get a single location by ID
    public Location getLocationById(int locationId) {
        String sql = "SELECT * FROM locations WHERE location_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, locationId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Location(
                        rs.getInt("location_id"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("country")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE: update a location
    public void updateLocation(Location location) {
        String sql = "UPDATE locations SET city = ?, state = ?, country = ? WHERE location_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, location.getCity());
            ps.setString(2, location.getState());
            ps.setString(3, location.getCountry());
            ps.setInt(4, location.getLocationId());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE: remove a location
    public void deleteLocation(int locationId) {
        String sql = "DELETE FROM locations WHERE location_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, locationId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
