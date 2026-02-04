import java.sql.*;
import java.util.*;

public class AlertDAO {

    public List<String> getAllAlerts() {
        List<String> alerts = new ArrayList<>();
        String sql = "SELECT * FROM alerts ORDER BY alert_id ASC";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                alerts.add(
                    rs.getInt("alert_id") +
                    " | Location: " + rs.getString("location_name") +
                    " | Message: " + rs.getString("message")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return alerts;
    }

    public void addAlert(Alert alert) {
        String sql =
            "INSERT INTO alerts (location_name, message) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, alert.getLocationName());
            ps.setString(2, alert.getMessage());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
