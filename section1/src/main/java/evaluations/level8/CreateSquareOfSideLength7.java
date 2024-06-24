package evaluations.level8;

public class CreateSquareOfSideLength7 {
    public final int size = 7;
    public static int numberOfSquaresCreated = 0;
    public static final int NUMBER_OF_SIDES = 4;

    public final long timeOfCreation;

    public CreateSquareOfSideLength7(long timeOfCreation) {
        this.timeOfCreation = timeOfCreation;
        numberOfSquaresCreated++;
    }
}
