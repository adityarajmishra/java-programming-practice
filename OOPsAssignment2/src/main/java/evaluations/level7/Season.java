package evaluations.level7;

public enum Season {
    WINTER(-5, 50), SPRING(15, 70), SUMMER(25, 30), AUTUMN(10, 60);

    private final int avgTemperature; // in Celsius
    private final int avgRainfall;    // in mm

    Season(int avgTemperature, int avgRainfall) {
        this.avgTemperature = avgTemperature;
        this.avgRainfall = avgRainfall;
    }

    public int getAvgTemperature() {
        return avgTemperature;
    }

    public int getAvgRainfall() {
        return avgRainfall;
    }
}

