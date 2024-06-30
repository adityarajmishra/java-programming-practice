package evaluations.level2;

public class ExceptionHandlingApplication {
    public void handleException() {
        try {
            int a = 5/0;
        }
        catch (ArithmeticException e) {
            System.out.println("Exception handled");
        }
    }

    public void generateStackTrace() {
        int[] a = new int[5];
        try {
            a[5] = 10;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

}
