import java.util.List;

public class AlertBusiness {

    private AlertDAO alertDAO = new AlertDAO();

    public List<String> getAllAlerts() {
        return alertDAO.getAllAlerts();
    }

    public void addAlert(Alert alert) {
        if (alert.getMessage() == null || alert.getMessage().isEmpty()) {
            throw new RuntimeException("Alert message cannot be empty");
        }
        alertDAO.addAlert(alert);
    }
}
