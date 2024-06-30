package evaluations.level7;

public enum TrafficLight {

    RED(30 , "STOP"), YELLOW(5 , "WATCH"), GREEN(60 , "GO");

    private final int duration; // in seconds
    private final String action;

    TrafficLight(int duration, String action) {
        this.duration = duration;
        this.action = action;
    }

    public int getDuration() {
        return duration;
    }

    public String getAction() {
        return action;
    }

}

