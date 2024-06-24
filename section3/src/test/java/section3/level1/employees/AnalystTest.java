package section3.level1.employees;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class AnalystTest {


    @Test
    public void testAnalystMethods() {
        try {
            Class<?> analystClass = Class.forName("section3.level1.employees.Analyst");
            Constructor<?> analystConstructor = analystClass.getConstructor(int.class, String.class, int.class);
            Object analystInstance = analystConstructor.newInstance(50000, "Alice", 12345);

            Method analyseMethod = analystClass.getMethod("analyse");
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            analyseMethod.invoke(analystInstance);
            assertEquals("I am analysing\n", outContent.toString());

            // Reset System.out
            System.setOut(System.out);
        } catch (ClassNotFoundException e) {
            fail("Analyst class not found.");
        } catch (NoSuchMethodException e) {
            fail("Method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Analyst method test failed: " + e.getMessage());
        }
    }

    @Test
    public void testAnalystInheritance() {
        try {
            Class<?> analystClass = Class.forName("section3.level1.employees.Analyst");
            assertEquals(Class.forName("section3.level1.Employee"), analystClass.getSuperclass(), "Analyst should inherit from Employee");
        } catch (ClassNotFoundException e) {
            fail("Analyst class not found.");
        }
    }

    @Test
    public void testAnalystRoutineMethodInheritance() {
        try {
            Class<?> analystClass = Class.forName("section3.level1.employees.Analyst");
            Constructor<?> analystConstructor = analystClass.getConstructor(int.class, String.class, int.class);
            Object analystInstance = analystConstructor.newInstance(50000, "Alice", 12345);

            Method routineMethod = analystClass.getSuperclass().getMethod("routine");
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            routineMethod.invoke(analystInstance);
            assertEquals("I work from Monday to Friday.\n", outContent.toString());

            // Reset System.out
            System.setOut(System.out);
        } catch (ClassNotFoundException e) {
            fail("Analyst class not found.");
        } catch (NoSuchMethodException e) {
            fail("Method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Analyst routine method inheritance test failed: " + e.getMessage());
        }
    }
}
