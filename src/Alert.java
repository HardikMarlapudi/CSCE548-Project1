public class Alert {

    private int alertId;
    private String locationName;
    private String message;

    public Alert(String locationName, String message) {
        this.locationName = locationName;
        this.message = message;
    }

    public int getAlertId() {
        return alertId;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getMessage() {
        return message;
    }

    /**
     * @param alertId the alertId to set
     */
    public void setAlertId(int alertId) {
        this.alertId = alertId;
    }

    /**
     * @param locationName the locationName to set
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
