import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class WeatherConditionDAO {

    // CREATE: add a new weather condition
    public void addCondition(WeatherCondition condition) {
        String sql = "INSERT INTO weather_conditions (description) VALUES (?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, condition.getDescription());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ: get all weather conditions
    public ArrayList<WeatherCondition> getAllConditions() {
        ArrayList<WeatherCondition> conditions = new ArrayList<>();
        String sql = "SELECT * FROM weather_conditions";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                conditions.add(new WeatherCondition(
                        rs.getInt("condition_id"),
                        rs.getString("description")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conditions;
    }

    // READ: get a condition by ID
    public WeatherCondition getConditionById(int conditionId) {
        String sql = "SELECT * FROM weather_conditions WHERE condition_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, conditionId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new WeatherCondition(
                        rs.getInt("condition_id"),
                        rs.getString("description")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE: update a weather condition
    public void updateCondition(WeatherCondition condition) {
        String sql = "UPDATE weather_conditions SET description = ? WHERE condition_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, condition.getDescription());
            ps.setInt(2, condition.getCondition());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE: delete a weather condition
    public void deleteCondition(int conditionId) {
        String sql = "DELETE FROM weather_conditions WHERE condition_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, conditionId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
