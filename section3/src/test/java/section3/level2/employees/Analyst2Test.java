package section3.level2.employees;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class Analyst2Test {

    @Test
    public void testAnalyst2Fields() {
        try {
            Class<?> analyst2Class = Class.forName("section3.level2.employees.Analyst2");

            Field secretAccessField = analyst2Class.getDeclaredField("analystTeamSecretAccess");
            assertEquals(int.class, secretAccessField.getType(), "analystTeamSecretAccess should be of type int.");
            assertTrue(Modifier.isPublic(secretAccessField.getModifiers()), "analystTeamSecretAccess should be public.");
        } catch (ClassNotFoundException e) {
            fail("Analyst2 class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testAnalyst2Constructor() {
        try {
            Class<?> analyst2Class = Class.forName("section3.level2.employees.Analyst2");
            Constructor<?> analyst2Constructor = analyst2Class.getConstructor(int.class, String.class, int.class);
            Object analyst2Instance = analyst2Constructor.newInstance(50000, "Alice", 12345);

            Field salaryField = analyst2Class.getSuperclass().getDeclaredField("salary");
            Field nameField = analyst2Class.getSuperclass().getDeclaredField("name");
            Field secretAccessField = analyst2Class.getDeclaredField("analystTeamSecretAccess");

            salaryField.setAccessible(true);
            nameField.setAccessible(true);
            secretAccessField.setAccessible(true);

            assertEquals(50000, salaryField.get(analyst2Instance), "salary should be 50000.");
            assertEquals("Alice", nameField.get(analyst2Instance), "name should be Alice.");
            assertEquals(12345, secretAccessField.get(analyst2Instance), "analystTeamSecretAccess should be 12345.");
        } catch (ClassNotFoundException e) {
            fail("Analyst2 class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        } catch (NoSuchMethodException e) {
            fail("Constructor not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Analyst2 constructor test failed: " + e.getMessage());
        }
    }

    @Test
    public void testAnalyst2Methods() {
        try {
            Class<?> analyst2Class = Class.forName("section3.level2.employees.Analyst2");
            Constructor<?> analyst2Constructor = analyst2Class.getConstructor(int.class, String.class, int.class);
            Object analyst2Instance = analyst2Constructor.newInstance(50000, "Alice", 12345);

            Method analyseMethod = analyst2Class.getMethod("analyse");
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            analyseMethod.invoke(analyst2Instance);
            assertEquals("I am analysing\n", outContent.toString());

            // Reset System.out
            System.setOut(System.out);
        } catch (ClassNotFoundException e) {
            fail("Analyst2 class not found.");
        } catch (NoSuchMethodException e) {
            fail("Method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Analyst2 method test failed: " + e.getMessage());
        }
    }

    @Test
    public void testAnalyst2Inheritance() {
        try {
            Class<?> analyst2Class = Class.forName("section3.level2.employees.Analyst2");
            assertEquals(Class.forName("section3.level2.Employee2"), analyst2Class.getSuperclass(), "Analyst2 should inherit from Employee2");
        } catch (ClassNotFoundException e) {
            fail("Analyst2 class not found.");
        }
    }

    @Test
    public void testAnalyst2RoutineMethodInheritance() {
        try {
            Class<?> analyst2Class = Class.forName("section3.level2.employees.Analyst2");
            Constructor<?> analyst2Constructor = analyst2Class.getConstructor(int.class, String.class, int.class);
            Object analyst2Instance = analyst2Constructor.newInstance(50000, "Alice", 12345);

            Method routineMethod = analyst2Class.getSuperclass().getMethod("routine");
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            routineMethod.invoke(analyst2Instance);
            assertEquals("I work from Monday to Friday.\n", outContent.toString());

            // Reset System.out
            System.setOut(System.out);
        } catch (ClassNotFoundException e) {
            fail("Analyst2 class not found.");
        } catch (NoSuchMethodException e) {
            fail("Method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Analyst2 routine method inheritance test failed: " + e.getMessage());
        }
    }
}
