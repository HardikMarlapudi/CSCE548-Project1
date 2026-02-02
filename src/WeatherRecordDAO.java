import java.sql.*;
import java.util.ArrayList;

public class WeatherRecordDAO {
    
    public ArrayList<WeatherRecord> getAllRecords() {
        ArrayList<WeatherRecord> records = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM weather_records");

            while (rs.next()) {
                records.add(new WeatherRecord(
                    rs.getInt("record_id"),
                    rs.getInt("location_id"),
                    rs.getInt("condition_id"),
                    rs.getDouble("temperature"),
                    rs.getInt("humidity"),
                    rs.getDate("record_date")
                ));
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
