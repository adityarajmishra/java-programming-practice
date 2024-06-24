package section3.level2.employees;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class Recruiter2Test {

    @Test
    public void testRecruiter2Fields() {
        try {
            Class<?> recruiter2Class = Class.forName("section3.level2.employees.Recruiter2");

            Field secretsField = recruiter2Class.getDeclaredField("recruitingSecrets");
            assertEquals(String.class, secretsField.getType(), "recruitingSecrets should be of type String.");
            assertTrue(Modifier.isPublic(secretsField.getModifiers()), "recruitingSecrets should be public.");
        } catch (ClassNotFoundException e) {
            fail("Recruiter2 class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testRecruiter2Constructor() {
        try {
            Class<?> recruiter2Class = Class.forName("section3.level2.employees.Recruiter2");
            Constructor<?> recruiter2Constructor = recruiter2Class.getConstructor(int.class, String.class, String.class);
            Object recruiter2Instance = recruiter2Constructor.newInstance(55000, "Charlie", "topsecret");

            Field salaryField = recruiter2Class.getSuperclass().getDeclaredField("salary");
            Field nameField = recruiter2Class.getSuperclass().getDeclaredField("name");
            Field secretsField = recruiter2Class.getDeclaredField("recruitingSecrets");

            salaryField.setAccessible(true);
            nameField.setAccessible(true);
            secretsField.setAccessible(true);

            assertEquals(55000, salaryField.get(recruiter2Instance), "salary should be 55000.");
            assertEquals("Charlie", nameField.get(recruiter2Instance), "name should be Charlie.");
            assertEquals("topsecret", secretsField.get(recruiter2Instance), "recruitingSecrets should be topsecret.");
        } catch (ClassNotFoundException e) {
            fail("Recruiter2 class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        } catch (NoSuchMethodException e) {
            fail("Constructor not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Recruiter2 constructor test failed: " + e.getMessage());
        }
    }

    @Test
    public void testRecruiter2Methods() {
        try {
            Class<?> recruiter2Class = Class.forName("section3.level2.employees.Recruiter2");
            Constructor<?> recruiter2Constructor = recruiter2Class.getConstructor(int.class, String.class, String.class);
            Object recruiter2Instance = recruiter2Constructor.newInstance(55000, "Charlie", "topsecret");

            Method recruitMethod = recruiter2Class.getMethod("recruit");
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            recruitMethod.invoke(recruiter2Instance);
            assertEquals("I am recruiting\n", outContent.toString());

            // Reset System.out
            System.setOut(System.out);
        } catch (ClassNotFoundException e) {
            fail("Recruiter2 class not found.");
        } catch (NoSuchMethodException e) {
            fail("Method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Recruiter2 method test failed: " + e.getMessage());
        }
    }

    @Test
    public void testRecruiter2Inheritance() {
        try {
            Class<?> recruiter2Class = Class.forName("section3.level2.employees.Recruiter2");
            assertEquals(Class.forName("section3.level2.Employee2"), recruiter2Class.getSuperclass(), "Recruiter2 should inherit from Employee2");
        } catch (ClassNotFoundException e) {
            fail("Recruiter2 class not found.");
        }
    }

    @Test
    public void testRecruiter2RoutineMethodInheritance() {
        try {
            Class<?> recruiter2Class = Class.forName("section3.level2.employees.Recruiter2");
            Constructor<?> recruiter2Constructor = recruiter2Class.getConstructor(int.class, String.class, String.class);
            Object recruiter2Instance = recruiter2Constructor.newInstance(55000, "Charlie", "topsecret");

            Method routineMethod = recruiter2Class.getSuperclass().getMethod("routine");
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            routineMethod.invoke(recruiter2Instance);
            assertEquals("I work from Monday to Friday.\n", outContent.toString());

            // Reset System.out
            System.setOut(System.out);
        } catch (ClassNotFoundException e) {
            fail("Recruiter2 class not found.");
        } catch (NoSuchMethodException e) {
            fail("Method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Recruiter2 routine method inheritance test failed: " + e.getMessage());
        }
    }
}
