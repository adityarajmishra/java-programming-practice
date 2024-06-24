package section3.level2.employees;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class Developer2Test {

    @Test
    public void testDeveloper2Fields() {
        try {
            Class<?> developer2Class = Class.forName("section3.level2.employees.Developer2");

            Field codePasswordField = developer2Class.getDeclaredField("developersCodePassword");
            assertEquals(String.class, codePasswordField.getType(), "developersCodePassword should be of type String.");
            assertTrue(Modifier.isPublic(codePasswordField.getModifiers()), "developersCodePassword should be public.");
        } catch (ClassNotFoundException e) {
            fail("Developer2 class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testDeveloper2Constructor() {
        try {
            Class<?> developer2Class = Class.forName("section3.level2.employees.Developer2");
            Constructor<?> developer2Constructor = developer2Class.getConstructor(int.class, String.class, String.class);
            Object developer2Instance = developer2Constructor.newInstance(60000, "Bob", "password123");

            Field salaryField = developer2Class.getSuperclass().getDeclaredField("salary");
            Field nameField = developer2Class.getSuperclass().getDeclaredField("name");
            Field codePasswordField = developer2Class.getDeclaredField("developersCodePassword");

            salaryField.setAccessible(true);
            nameField.setAccessible(true);
            codePasswordField.setAccessible(true);

            assertEquals(60000, salaryField.get(developer2Instance), "salary should be 60000.");
            assertEquals("Bob", nameField.get(developer2Instance), "name should be Bob.");
            assertEquals("password123", codePasswordField.get(developer2Instance), "developersCodePassword should be password123.");
        } catch (ClassNotFoundException e) {
            fail("Developer2 class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        } catch (NoSuchMethodException e) {
            fail("Constructor not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Developer2 constructor test failed: " + e.getMessage());
        }
    }

    @Test
    public void testDeveloper2Methods() {
        try {
            Class<?> developer2Class = Class.forName("section3.level2.employees.Developer2");
            Constructor<?> developer2Constructor = developer2Class.getConstructor(int.class, String.class, String.class);
            Object developer2Instance = developer2Constructor.newInstance(60000, "Bob", "password123");

            Method developMethod = developer2Class.getMethod("develop");
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            developMethod.invoke(developer2Instance);
            assertEquals("I am developing\n", outContent.toString());

            // Reset System.out
            System.setOut(System.out);
        } catch (ClassNotFoundException e) {
            fail("Developer2 class not found.");
        } catch (NoSuchMethodException e) {
            fail("Method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Developer2 method test failed: " + e.getMessage());
        }
    }

    @Test
    public void testDeveloper2Inheritance() {
        try {
            Class<?> developer2Class = Class.forName("section3.level2.employees.Developer2");
            assertEquals(Class.forName("section3.level2.Employee2"), developer2Class.getSuperclass(), "Developer2 should inherit from Employee2");
        } catch (ClassNotFoundException e) {
            fail("Developer2 class not found.");
        }
    }

    @Test
    public void testDeveloper2RoutineMethodInheritance() {
        try {
            Class<?> developer2Class = Class.forName("section3.level2.employees.Developer2");
            Constructor<?> developer2Constructor = developer2Class.getConstructor(int.class, String.class, String.class);
            Object developer2Instance = developer2Constructor.newInstance(60000, "Bob", "password123");

            Method routineMethod = developer2Class.getSuperclass().getMethod("routine");
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            routineMethod.invoke(developer2Instance);
            assertEquals("I work from Monday to Friday.\n", outContent.toString());

            // Reset System.out
            System.setOut(System.out);
        } catch (ClassNotFoundException e) {
            fail("Developer2 class not found.");
        } catch (NoSuchMethodException e) {
            fail("Method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Developer2 routine method inheritance test failed: " + e.getMessage());
        }
    }
}
