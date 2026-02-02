public class WeatherCondition {

    private int conditionId;
    private String description;
    
    public WeatherCondition(int conditionId, String description) {
        this.conditionId = conditionId;
        this.description = description;
    }

    public int getCondition() {
        return conditionId;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return conditionId + ": " + description;
    }
}
