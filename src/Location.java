public class Location {
    private int locationId;
    private String city;
    private String state;
    private String country;

    public Location(int locationId, String city, String state, String country) {
        this.locationId = locationId;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public int getLocationId() {
        return locationId;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String toString() {
        return locationId + ": " + city + ", " + state + ", " + country;
    }

    /**
     * @param locationId the locationId to set
     */
    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

}
