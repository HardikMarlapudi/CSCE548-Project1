import java.sql.Date;

public class WeatherRecord {

    private int recordId;
    private String cityName;
    private String stationName;
    private String conditionName;
    private double temperature;
    private int humidity;
    private Date recordDate;

    public WeatherRecord(String cityName, String stationName,
                         String conditionName, double temperature,
                         int humidity, Date recordDate) {

        this.cityName = cityName;
        this.stationName = stationName;
        this.conditionName = conditionName;
        this.temperature = temperature;
        this.humidity = humidity;
        this.recordDate = recordDate;
    }

    public int getRecordId() { return recordId; }
    public void setRecordId(int recordId) { this.recordId = recordId; }

    public String getCityName() { return cityName; }
    public String getStationName() { return stationName; }
    public String getConditionName() { return conditionName; }
    public double getTemperature() { return temperature; }
    public int getHumidity() { return humidity; }
    public Date getRecordDate() { return recordDate; }

    /**
     * @param cityName the cityName to set
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * @param stationName the stationName to set
     */
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    /**
     * @param conditionName the conditionName to set
     */
    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    /**
     * @param temperature the temperature to set
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    /**
     * @param humidity the humidity to set
     */
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    /**
     * @param recordDate the recordDate to set
     */
    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

}
