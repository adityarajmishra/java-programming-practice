package section3.level4;

public class Office {
    private String location;
    private int capacity;
    private String wifiPassword;
    private boolean lunchProvided;

    public Office(String location, int capacity, String wifiPassword, boolean lunchProvided) {
        this.location = location;
        this.capacity = capacity;
        this.wifiPassword = wifiPassword;
        this.lunchProvided = lunchProvided;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getWifiPassword() {
        return wifiPassword;
    }

    public void setWifiPassword(String wifiPassword) {
        this.wifiPassword = wifiPassword;
    }

    public boolean isLunchProvided() {
        return lunchProvided;
    }

    public void setLunchProvided(boolean lunchProvided) {
        this.lunchProvided = lunchProvided;
    }
}
