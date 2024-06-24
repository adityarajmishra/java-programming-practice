package section3.level2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class Employee2Test {

    @Test
    public void testEmployee2Fields() {
        try {
            Class<?> employee2Class = Class.forName("section3.level2.Employee2");

            Field salaryField = employee2Class.getDeclaredField("salary");
            assertEquals(int.class, salaryField.getType(), "salary should be of type int.");

            Field nameField = employee2Class.getDeclaredField("name");
            assertEquals(String.class, nameField.getType(), "name should be of type String.");
        } catch (ClassNotFoundException e) {
            fail("Employee2 class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testEmployee2Constructor() {
        try {
            Class<?> employee2Class = Class.forName("section3.level2.Employee2");
            Constructor<?> employee2Constructor = employee2Class.getConstructor(int.class, String.class);
            Object employee2Instance = employee2Constructor.newInstance(70000, "Diana");

            Field salaryField = employee2Class.getDeclaredField("salary");
            Field nameField = employee2Class.getDeclaredField("name");

            salaryField.setAccessible(true);
            nameField.setAccessible(true);

            assertEquals(70000, salaryField.get(employee2Instance), "salary should be 70000.");
            assertEquals("Diana", nameField.get(employee2Instance), "name should be Diana.");
        } catch (ClassNotFoundException e) {
            fail("Employee2 class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        } catch (NoSuchMethodException e) {
            fail("Constructor not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Employee2 constructor test failed: " + e.getMessage());
        }
    }

    @Test
    public void testEmployee2RoutineMethod() {
        try {
            Class<?> employee2Class = Class.forName("section3.level2.Employee2");
            Constructor<?> employee2Constructor = employee2Class.getConstructor(int.class, String.class);
            Object employee2Instance = employee2Constructor.newInstance(70000, "Diana");

            Method routineMethod = employee2Class.getMethod("routine");

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            routineMethod.invoke(employee2Instance);
            assertEquals("I work from Monday to Friday.\n", outContent.toString());

            // Reset System.out
            System.setOut(System.out);
        } catch (ClassNotFoundException e) {
            fail("Employee2 class not found.");
        } catch (NoSuchMethodException e) {
            fail("Method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Employee2 routine method test failed: " + e.getMessage());
        }
    }
}
