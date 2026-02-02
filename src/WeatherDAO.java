import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class WeatherDAO {

    // CREATE: add weather record
    public void addRecord(WeatherRecord record) {
        String sql = """
            INSERT INTO weather_records
            (location_id, condition_id, temperature, humidity, record_date)
            VALUES (?, ?, ?, ?, ?)
        """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, record.getLocationId());
            ps.setInt(2, record.getConditionId());
            ps.setDouble(3, record.getTemperature());
            ps.setInt(4, record.getHumidity());
            ps.setDate(5, record.getRecordDate());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ: get all weather records
    public ArrayList<WeatherRecord> getAllRecords() {
        ArrayList<WeatherRecord> records = new ArrayList<>();
        String sql = "SELECT * FROM weather_records";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

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

    // READ: get record by ID
    public WeatherRecord getRecordById(int recordId) {
        String sql = "SELECT * FROM weather_records WHERE record_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, recordId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new WeatherRecord(
                        rs.getInt("record_id"),
                        rs.getInt("location_id"),
                        rs.getInt("condition_id"),
                        rs.getDouble("temperature"),
                        rs.getInt("humidity"),
                        rs.getDate("record_date")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE: update weather record
    public void updateRecord(WeatherRecord record) {
        String sql = """
            UPDATE weather_records
            SET location_id = ?, condition_id = ?, temperature = ?, humidity = ?, record_date = ?
            WHERE record_id = ?
        """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, record.getLocationId());
            ps.setInt(2, record.getConditionId());
            ps.setDouble(3, record.getTemperature());
            ps.setInt(4, record.getHumidity());
            ps.setDate(5, record.getRecordDate());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE: delete weather record
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
