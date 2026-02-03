import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WeatherRecordDAO {
    
    public List<String> getAllRecords() {
    List<String> records = new ArrayList<>();
    String sql = "SELECT * FROM weather_records";

    try (Connection conn = DBConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            records.add(
                rs.getInt("record_id") +
                " | Station ID: " + rs.getInt("station_id") +
                " | Condition: " + rs.getString("condition_name") +
                " | Temp: " + rs.getDouble("temperature") +
                " | Humidity: " + rs.getInt("humidity") +
                " | Date: " + rs.getDate("record_date")
            );
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return records;
}

    public void addRecord(WeatherRecord record) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(
                "INSERT INTO weather_records (location_id, condition_id, temperature, humidity, record_date) VALUES (?, ?, ?, ?, ?)"
            );
            pstmt.setInt(1, record.getLocationId());
            pstmt.setInt(2, record.getConditionId());
            pstmt.setDouble(3, record.getTemperature());
            pstmt.setInt(4, record.getHumidity());
            pstmt.setDate(5, record.getRecordDate());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteRecord(int recordId) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM weather_records WHERE reconrd_id = ?"
            );
            ps.setInt(1, recordId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
