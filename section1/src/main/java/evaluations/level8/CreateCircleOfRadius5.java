package evaluations.level8;

public class CreateCircleOfRadius5 {

    public final int radius = 5;
    public static int numberOfCirclesCreated = 0;
    public static final double PI_VALUE = 3.14;

    public final long timeOfCreation;

    public CreateCircleOfRadius5(long timeOfCreation) {
        this.timeOfCreation = timeOfCreation;
        numberOfCirclesCreated++;
    }
}
