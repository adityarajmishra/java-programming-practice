package org.skillovilla.level2;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskTest {

    @Test
    void testTaskInitialization() throws Exception {
        // Test Task initialization
        Class<?> taskClass = Class.forName("org.skillovilla.level2.Task");
        Object task = taskClass.getDeclaredConstructor(String.class, String.class).newInstance("T123", "Complete the report");

        Method getTaskIdMethod = taskClass.getMethod("getTaskId");
        Method getDescriptionMethod = taskClass.getMethod("getDescription");
        Method getPriorityMethod = taskClass.getMethod("getPriority");

        String taskId = (String) getTaskIdMethod.invoke(task);
        String description = (String) getDescriptionMethod.invoke(task);
        Enum<?> priority = (Enum<?>) getPriorityMethod.invoke(task);

        assertEquals("T123", taskId);
        assertEquals("Complete the report", description);
        assertEquals(Enum.valueOf((Class<Enum>)Class.forName("org.skillovilla.level2.Priority"), "MEDIUM"), priority);
    }

    @Test
    void testUpdatePriorityToHigh() throws Exception {
        // Test updating priority to HIGH
        Class<?> taskClass = Class.forName("org.skillovilla.level2.Task");
        Object task = taskClass.getDeclaredConstructor(String.class, String.class).newInstance("T123", "Complete the report");

        Method updatePriorityMethod = taskClass.getMethod("updatePriority", Class.forName("org.skillovilla.level2.Priority"));
        Method getPriorityMethod = taskClass.getMethod("getPriority");

        Enum<?> highPriority = Enum.valueOf((Class<Enum>)Class.forName("org.skillovilla.level2.Priority"), "HIGH");
        updatePriorityMethod.invoke(task, highPriority);
        Enum<?> priority = (Enum<?>) getPriorityMethod.invoke(task);

        assertEquals(highPriority, priority);
    }

    @Test
    void testUpdatePriorityToCritical() throws Exception {
        // Test updating priority to CRITICAL
        Class<?> taskClass = Class.forName("org.skillovilla.level2.Task");
        Object task = taskClass.getDeclaredConstructor(String.class, String.class).newInstance("T123", "Complete the report");

        Method updatePriorityMethod = taskClass.getMethod("updatePriority", Class.forName("org.skillovilla.level2.Priority"));
        Method getPriorityMethod = taskClass.getMethod("getPriority");

        Enum<?> criticalPriority = Enum.valueOf((Class<Enum>)Class.forName("org.skillovilla.level2.Priority"), "CRITICAL");
        updatePriorityMethod.invoke(task, criticalPriority);
        Enum<?> priority = (Enum<?>) getPriorityMethod.invoke(task);

        assertEquals(criticalPriority, priority);
    }

    @Test
    void testUpdatePriorityToLow() throws Exception {
        // Test updating priority to LOW
        Class<?> taskClass = Class.forName("org.skillovilla.level2.Task");
        Object task = taskClass.getDeclaredConstructor(String.class, String.class).newInstance("T123", "Complete the report");

        Method updatePriorityMethod = taskClass.getMethod("updatePriority", Class.forName("org.skillovilla.level2.Priority"));
        Method getPriorityMethod = taskClass.getMethod("getPriority");

        Enum<?> lowPriority = Enum.valueOf((Class<Enum>)Class.forName("org.skillovilla.level2.Priority"), "LOW");
        updatePriorityMethod.invoke(task, lowPriority);
        Enum<?> priority = (Enum<?>) getPriorityMethod.invoke(task);

        assertEquals(lowPriority, priority);
    }
}
