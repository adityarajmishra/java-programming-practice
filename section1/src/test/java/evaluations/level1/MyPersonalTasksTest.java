package evaluations.level1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class MyPersonalTasksTest {
    @Test
    public void testDescription() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level1.MyPersonalTasks");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Field descriptionField = clazz.getField("description");
        String description = (String) descriptionField.get(instance);
        assertNotNull(description);
    }

    @Test
    public void testAddTask() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level1.MyPersonalTasks");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method addTaskMethod = clazz.getMethod("addTask", String.class);
        String task = "Complete unit testing";

        // Capture the output of the addTask method
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        addTaskMethod.invoke(instance, task);

        // Restore the original System.out
        System.setOut(originalOut);

    }

}