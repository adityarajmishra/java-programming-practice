package evaluations.level8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StackTrace {

    public void sampleExample() {
        try {
            FileInputStream fileInputStream = new FileInputStream("nonexistentfile.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void practiceOnYourOwn() {

        try {
            int number = Integer.parseInt("ABC");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
