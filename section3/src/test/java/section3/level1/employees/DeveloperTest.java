package section3.level1.employees;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class DeveloperTest {


    @Test
    public void testDeveloperMethods() {
        try {
            Class<?> developerClass = Class.forName("section3.level1.employees.Developer");
            Constructor<?> developerConstructor = developerClass.getConstructor(int.class, String.class, String.class);
            Object developerInstance = developerConstructor.newInstance(60000, "Bob", "password123");

            Method developMethod = developerClass.getMethod("develop");
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            developMethod.invoke(developerInstance);
            assertEquals("I am developing\n", outContent.toString());

            // Reset System.out
            System.setOut(System.out);
        } catch (ClassNotFoundException e) {
            fail("Developer class not found.");
        } catch (NoSuchMethodException e) {
            fail("Method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Developer method test failed: " + e.getMessage());
        }
    }

    @Test
    public void testDeveloperInheritance() {
        try {
            Class<?> developerClass = Class.forName("section3.level1.employees.Developer");
            assertEquals(Class.forName("section3.level1.Employee"), developerClass.getSuperclass(), "Developer should inherit from Employee");
        } catch (ClassNotFoundException e) {
            fail("Developer class not found.");
        }
    }

    @Test
    public void testDeveloperRoutineMethodInheritance() {
        try {
            Class<?> developerClass = Class.forName("section3.level1.employees.Developer");
            Constructor<?> developerConstructor = developerClass.getConstructor(int.class, String.class, String.class);
            Object developerInstance = developerConstructor.newInstance(60000, "Bob", "password123");

            Method routineMethod = developerClass.getSuperclass().getMethod("routine");
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            routineMethod.invoke(developerInstance);
            assertEquals("I work from Monday to Friday.\n", outContent.toString());

            // Reset System.out
            System.setOut(System.out);
        } catch (ClassNotFoundException e) {
            fail("Developer class not found.");
        } catch (NoSuchMethodException e) {
            fail("Method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Developer routine method inheritance test failed: " + e.getMessage());
        }
    }


}