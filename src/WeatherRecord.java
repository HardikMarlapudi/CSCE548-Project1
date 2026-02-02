import java.sql.Date;

public class WeatherRecord {
    
    private int recordId;
    private int locationId;
    private int conditionId;
    private double temperature;
    private int humidity;
    private Date recordDate;

    public WeatherRecord(int recordId, int locationId, int conditionId, double temperature, int humidity, Date recordDate) {
        this.recordId = recordId;
        this.locationId = locationId;
        this.conditionId = conditionId;
        this.temperature = temperature;
        this.humidity = humidity;
        this.recordDate = recordDate;
    }

    public int getRecordid() {
        return recordId;
    }

    public int getLocationId() {
        return locationId;
    }

    public int getConditionId() {
        return conditionId;
    }

    public double getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public String toString() {
        return recordId + " | Temp: " + temperature +
                " | Humidity: " + humidity +
                " | Date: " + recordDate;
    }
}
