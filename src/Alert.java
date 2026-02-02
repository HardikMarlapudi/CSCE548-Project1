public class Alert {
    private int alertId;
    private int userId;
    private int locationId;
    private String message;

    public Alert(int alertId, int userId, int locationId, String message) {
        this.alertId = alertId;
        this.userId = userId;
        this.locationId = locationId;
        this.message = message;
    }

    public int getAlertId() {
        return alertId;
    }

    public int getUserId() {
        return userId;
    }

    public int getLcationId() {
        return locationId;
    }

    public String getMessage() {
        return message;
    }

    public String toString() {
        return alertId + ": " + message;
    }
}
