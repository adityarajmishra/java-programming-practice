package evaluations.level9;

import java.io.*;

public class ThrowingExceptions {

    public void ioException() throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
            String line = reader.readLine();
            System.out.println(line);
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
            throw e;
        }
    }

    public void classNotFoundException() throws ClassNotFoundException {
        try {
            Class.forName("java.util.NoClassAvailable");
            System.out.println("Class found!");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
            e.printStackTrace();
            throw e;
        }
    }

    public void fileNotFoundException() throws FileNotFoundException {
        try {
            FileInputStream fileInputStream = new FileInputStream("nonexistentfile.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
            throw e;
        }
    }

    public void nullPointerExceptionExample() {
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("A null pointer exception occurred!");
            e.printStackTrace();
            throw e;
        }
    }

    public void handleArithmeticAndNumberFormat() {
        try {
            int result = 10 / 0; // May throw ArithmeticException

            String number = "abc";
            int value = Integer.parseInt(number); // May throw NumberFormatException
        } catch (ArithmeticException | NumberFormatException e) {
            System.out.println("An exception occurred: " + e.getClass().getSimpleName());
            e.printStackTrace();
            throw e;
        }
    }

}
