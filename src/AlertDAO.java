import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AlertDAO {
    
    public void addAlert(Alert alert) {
        String sql = "INSERT INTO Alerts VALUES (" + alert.getAlertId() + ", " + alert.getUserId() + ", " + alert.getLcationId() + ", '" + alert.getMessage() + "')";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Alert> getAllAlerts() {
        ArrayList<Alert> alerts = new ArrayList<>();
        String sql = "SELECT * FROM alerts";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                alerts.add(new Alert(
                    rs.getInt("alert_id"),
                    rs.getInt("user_id"),
                    rs.getInt("location_id"),
                    rs.getString("message")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return alerts;
    }

    public ArrayList<Alert> getAlertsByUser(int userId) {
        ArrayList<Alert> alerts = new ArrayList<>();
        String sql = "SELECT * FROM alerts WHERE user_id = ?";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, userId);
                ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                alerts.add(new Alert(
                    rs.getInt("alert_id"),
                    rs.getInt("user_id"),
                    rs.getInt("location_id"),
                    rs.getString("message")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return alerts;

    }

    public void updateAlertMessage(int alertId, String newMessage) {
        String sql = "UPDATE alerts SET message = ? WHERE alert_id = ?";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, newMessage);
                pstmt.setInt(2, alertId);
                pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
