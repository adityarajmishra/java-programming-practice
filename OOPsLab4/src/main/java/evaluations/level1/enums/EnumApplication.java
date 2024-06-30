package evaluations.level1.enums;

public class EnumApplication {
    public TrafficLight nextLight(TrafficLight trafficLight) {

        switch (trafficLight) {
            case RED:
                return TrafficLight.GREEN;
            case YELLOW:
                return TrafficLight.RED;
            case GREEN:
                return TrafficLight.YELLOW;
            default:
                return TrafficLight.RED;
        }
    }


}
