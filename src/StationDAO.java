import java.sql.*;
import java.util.*;

public class StationDAO {

    public List<String> getAllStations() {
        List<String> stations = new ArrayList<>();
        String sql = "SELECT * FROM stations";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                stations.add(
                    rs.getInt("station_id") + " | " +
                    rs.getString("station_name") + " | " +
                    rs.getString("location_name")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stations;
    }
}
