import java.sql.*;
import java.util.*;

public class WeatherRecordDAO {

    public List<String> getAllRecords() {
        List<String> records = new ArrayList<>();
        String sql = "SELECT * FROM weather_records ORDER BY record_id ASC";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                records.add(
                    rs.getInt("record_id") +
                    " | City: " + rs.getString("city_name") +
                    " | Station: " + rs.getString("station_name") +
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
        String sql =
            "INSERT INTO weather_records " +
            "(city_name, station_name, condition_name, temperature, humidity, record_date) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, record.getCityName());
            ps.setString(2, record.getStationName());
            ps.setString(3, record.getConditionName());
            ps.setDouble(4, record.getTemperature());
            ps.setInt(5, record.getHumidity());
            ps.setDate(6, record.getRecordDate());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteRecord(int recordId) {
        String sql = "DELETE FROM weather_records WHERE record_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, recordId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
