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

    /**
     * @return int return the conditionId
     */
    public int getConditionId() {
        return conditionId;
    }

    /**
     * @param conditionId the conditionId to set
     */
    public void setConditionId(int conditionId) {
        this.conditionId = conditionId;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
