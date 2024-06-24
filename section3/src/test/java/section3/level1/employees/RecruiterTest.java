package section3.level1.employees;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class RecruiterTest {

    @Test
    public void testRecruiterFields() {
        try {
            Class<?> recruiterClass = Class.forName("section3.level1.employees.Recruiter");

            Field salaryField = recruiterClass.getDeclaredField("salary");
            assertEquals(int.class, salaryField.getType(), "salary should be of type int.");
            assertTrue(Modifier.isPublic(salaryField.getModifiers()), "salary should be public.");

            Field nameField = recruiterClass.getDeclaredField("name");
            assertEquals(String.class, nameField.getType(), "name should be of type String.");
            assertTrue(Modifier.isPublic(nameField.getModifiers()), "name should be public.");

            Field secretsField = recruiterClass.getDeclaredField("recruitingSecrets");
            assertEquals(String.class, secretsField.getType(), "recruitingSecrets should be of type String.");
            assertTrue(Modifier.isPublic(secretsField.getModifiers()), "recruitingSecrets should be public.");
        } catch (ClassNotFoundException e) {
            fail("Recruiter class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testRecruiterConstructor() {
        try {
            Class<?> recruiterClass = Class.forName("section3.level1.employees.Recruiter");
            Constructor<?> recruiterConstructor = recruiterClass.getConstructor(int.class, String.class, String.class);
            Object recruiterInstance = recruiterConstructor.newInstance(55000, "Charlie", "topsecret");

            Field salaryField = recruiterClass.getDeclaredField("salary");
            Field nameField = recruiterClass.getDeclaredField("name");
            Field secretsField = recruiterClass.getDeclaredField("recruitingSecrets");

            salaryField.setAccessible(true);
            nameField.setAccessible(true);
            secretsField.setAccessible(true);

            assertEquals(55000, salaryField.get(recruiterInstance), "salary should be 55000.");
            assertEquals("Charlie", nameField.get(recruiterInstance), "name should be Charlie.");
            assertEquals("topsecret", secretsField.get(recruiterInstance), "recruitingSecrets should be topsecret.");
        } catch (ClassNotFoundException e) {
            fail("Recruiter class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        } catch (NoSuchMethodException e) {
            fail("Constructor not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Recruiter constructor test failed: " + e.getMessage());
        }
    }

    @Test
    public void testRecruiterMethods() {
        try {
            Class<?> recruiterClass = Class.forName("section3.level1.employees.Recruiter");
            Constructor<?> recruiterConstructor = recruiterClass.getConstructor(int.class, String.class, String.class);
            Object recruiterInstance = recruiterConstructor.newInstance(55000, "Charlie", "topsecret");

            Method recruitMethod = recruiterClass.getMethod("recruit");
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            recruitMethod.invoke(recruiterInstance);
            assertEquals("I am recruiting\n", outContent.toString());

            // Reset System.out
            System.setOut(System.out);
        } catch (ClassNotFoundException e) {
            fail("Recruiter class not found.");
        } catch (NoSuchMethodException e) {
            fail("Method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Recruiter method test failed: " + e.getMessage());
        }
    }

    @Test
    public void testRecruiterInheritance() {
        try {
            Class<?> recruiterClass = Class.forName("section3.level1.employees.Recruiter");
            assertEquals(Class.forName("section3.level1.Employee"), recruiterClass.getSuperclass(), "Recruiter should inherit from Employee");
        } catch (ClassNotFoundException e) {
            fail("Recruiter class not found.");
        }
    }

    @Test
    public void testRecruiterRoutineMethodInheritance() {
        try {
            Class<?> recruiterClass = Class.forName("section3.level1.employees.Recruiter");
            Constructor<?> recruiterConstructor = recruiterClass.getConstructor(int.class, String.class, String.class);
            Object recruiterInstance = recruiterConstructor.newInstance(55000, "Charlie", "topsecret");

            Method routineMethod = recruiterClass.getSuperclass().getMethod("routine");
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            routineMethod.invoke(recruiterInstance);
            assertEquals("I work from Monday to Friday.\n", outContent.toString());

            // Reset System.out
            System.setOut(System.out);
        } catch (ClassNotFoundException e) {
            fail("Recruiter class not found.");
        } catch (NoSuchMethodException e) {
            fail("Method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Recruiter routine method inheritance test failed: " + e.getMessage());
        }
    }
}
