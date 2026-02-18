import java.util.List;

public class WeatherBusiness {

    private WeatherRecordDAO weatherDAO = new WeatherRecordDAO();

    public List<String> getAllWeatherRecords() {
        return weatherDAO.getAllRecords();
    }

    public void addWeatherRecord(WeatherRecord record) {
        if (record.getTemperature() < -100 || record.getTemperature() > 150) {
            throw new RuntimeException("Invalid temperature value");
        }
        weatherDAO.addRecord(record);
    }

    public void deleteWeatherRecord(int id) {
        weatherDAO.deleteRecord(id);
    }
}
