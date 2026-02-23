import java.util.ArrayList;

public class LocationBusiness {

    private LocationDAO locationDAO = new LocationDAO();

    public ArrayList<Location> getAllLocations() {
        return locationDAO.getAllLocations();
    }

    public void addLocation(Location location) {
        locationDAO.addLocation(location);
    }

    public void updateLocation(Location location) {
        locationDAO.updateLocation(location);
    }

    public void deleteLocation(int id) {
        locationDAO.deleteLocation(id);
    }
}
