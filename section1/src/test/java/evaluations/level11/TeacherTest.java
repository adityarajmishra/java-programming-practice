package evaluations.level11;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TeacherTest {

    @Test
    public void testIdField() {
        try {
            Class<?> teacherClass = Class.forName("evaluations.level11.Teacher");

            // Check for id attribute
            Field idField = teacherClass.getDeclaredField("id");
            assertEquals(int.class, idField.getType(), "id should be of type int.");
            assertEquals(true, Modifier.isPrivate(idField.getModifiers()), "id should be private.");
        } catch (ClassNotFoundException e) {
            fail("Teacher class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testNameField() {
        try {
            Class<?> teacherClass = Class.forName("evaluations.level11.Teacher");

            // Check for name attribute
            Field nameField = teacherClass.getDeclaredField("name");
            assertEquals(String.class, nameField.getType(), "name should be of type String.");
            assertEquals(true, Modifier.isPrivate(nameField.getModifiers()), "name should be private.");
        } catch (ClassNotFoundException e) {
            fail("Teacher class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testSalaryPerMonthField() {
        try {
            Class<?> teacherClass = Class.forName("evaluations.level11.Teacher");

            // Check for salaryPerMonth attribute
            Field salaryPerMonthField = teacherClass.getDeclaredField("salaryPerMonth");
            assertEquals(int.class, salaryPerMonthField.getType(), "salaryPerMonth should be of type int.");
            assertEquals(true, Modifier.isPrivate(salaryPerMonthField.getModifiers()), "salaryPerMonth should be private.");
        } catch (ClassNotFoundException e) {
            fail("Teacher class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testPermanentField() {
        try {
            Class<?> teacherClass = Class.forName("evaluations.level11.Teacher");

            // Check for permanent attribute
            Field permanentField = teacherClass.getDeclaredField("permanent");
            assertEquals(boolean.class, permanentField.getType(), "permanent should be of type boolean.");
            assertEquals(true, Modifier.isPrivate(permanentField.getModifiers()), "permanent should be private.");
        } catch (ClassNotFoundException e) {
            fail("Teacher class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testAllArgsConstructor() {
        try {
            Class<?> teacherClass = Class.forName("evaluations.level11.Teacher");

            // Test all-args constructor
            Constructor<?> teacherConstructor = teacherClass.getConstructor(int.class, String.class, int.class, boolean.class);
            int id = 1;
            String name = "Alice";
            int salaryPerMonth = 120000;
            boolean permanent = false;
            Object teacherInstance = teacherConstructor.newInstance(id, name, salaryPerMonth, permanent);

            // Verify the fields
            Field idField = teacherClass.getDeclaredField("id");
            idField.setAccessible(true);
            assertEquals(id, idField.getInt(teacherInstance), "id should match the constructor argument.");

            Field nameField = teacherClass.getDeclaredField("name");
            nameField.setAccessible(true);
            assertEquals(name, nameField.get(teacherInstance), "name should match the constructor argument.");

            Field salaryPerMonthField = teacherClass.getDeclaredField("salaryPerMonth");
            salaryPerMonthField.setAccessible(true);
            assertEquals(salaryPerMonth, salaryPerMonthField.getInt(teacherInstance), "salaryPerMonth should match the constructor argument.");

            Field permanentField = teacherClass.getDeclaredField("permanent");
            permanentField.setAccessible(true);
            assertEquals(permanent, permanentField.getBoolean(teacherInstance), "permanent should match the constructor argument.");

        } catch (ClassNotFoundException e) {
            fail("Teacher class not found.");
        } catch (NoSuchFieldException | NoSuchMethodException e) {
            fail("Field or method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Teacher all-args constructor test failed: " + e.getMessage());
        }
    }

    @Test
    public void testPartialArgsConstructor() {
        try {
            Class<?> teacherClass = Class.forName("evaluations.level11.Teacher");

            // Test partial-args constructor
            Constructor<?> teacherConstructor = teacherClass.getConstructor(int.class, String.class);
            int id = 1;
            String name = "Alice";
            Object teacherInstance = teacherConstructor.newInstance(id, name);

            // Verify the fields
            Field idField = teacherClass.getDeclaredField("id");
            idField.setAccessible(true);
            assertEquals(id, idField.getInt(teacherInstance), "id should match the constructor argument.");

            Field nameField = teacherClass.getDeclaredField("name");
            nameField.setAccessible(true);
            assertEquals(name, nameField.get(teacherInstance), "name should match the constructor argument.");

            Field salaryPerMonthField = teacherClass.getDeclaredField("salaryPerMonth");
            salaryPerMonthField.setAccessible(true);
            assertEquals(100000, salaryPerMonthField.getInt(teacherInstance), "salaryPerMonth should match the default value.");

            Field permanentField = teacherClass.getDeclaredField("permanent");
            permanentField.setAccessible(true);
            assertEquals(true, permanentField.getBoolean(teacherInstance), "permanent should match the default value.");

        } catch (ClassNotFoundException e) {
            fail("Teacher class not found.");
        } catch (NoSuchFieldException | NoSuchMethodException e) {
            fail("Field or method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Teacher partial-args constructor test failed: " + e.getMessage());
        }
    }

    @Test
    public void testIdGettersAndSetters() {
        try {
            Class<?> teacherClass = Class.forName("evaluations.level11.Teacher");
            Constructor<?> teacherConstructor = teacherClass.getConstructor(int.class, String.class, int.class, boolean.class);
            Object teacherInstance = teacherConstructor.newInstance(1, "Alice", 120000, false);

            Method getId = teacherClass.getMethod("getId");
            assertEquals(1, getId.invoke(teacherInstance), "getId should return the correct value.");

            Method setId = teacherClass.getMethod("setId", int.class);
            setId.invoke(teacherInstance, 2);

            assertEquals(2, getId.invoke(teacherInstance), "setId should set the correct value.");
        } catch (Exception e) {
            fail("testIdGettersAndSetters failed: " + e.getMessage());
        }
    }

    @Test
    public void testNameGettersAndSetters() {
        try {
            Class<?> teacherClass = Class.forName("evaluations.level11.Teacher");
            Constructor<?> teacherConstructor = teacherClass.getConstructor(int.class, String.class, int.class, boolean.class);
            Object teacherInstance = teacherConstructor.newInstance(1, "Alice", 120000, false);

            Method getName = teacherClass.getMethod("getName");
            assertEquals("Alice", getName.invoke(teacherInstance), "getName should return the correct value.");

            Method setName = teacherClass.getMethod("setName", String.class);
            setName.invoke(teacherInstance, "Bob");

            assertEquals("Bob", getName.invoke(teacherInstance), "setName should set the correct value.");
        } catch (Exception e) {
            fail("testNameGettersAndSetters failed: " + e.getMessage());
        }
    }

    @Test
    public void testSalaryPerMonthGettersAndSetters() {
        try {
            Class<?> teacherClass = Class.forName("evaluations.level11.Teacher");
            Constructor<?> teacherConstructor = teacherClass.getConstructor(int.class, String.class, int.class, boolean.class);
            Object teacherInstance = teacherConstructor.newInstance(1, "Alice", 120000, false);

            Method getSalaryPerMonth = teacherClass.getMethod("getSalaryPerMonth");
            assertEquals(120000, getSalaryPerMonth.invoke(teacherInstance), "getSalaryPerMonth should return the correct value.");

            Method setSalaryPerMonth = teacherClass.getMethod("setSalaryPerMonth", int.class);
            setSalaryPerMonth.invoke(teacherInstance, 130000);

            assertEquals(130000, getSalaryPerMonth.invoke(teacherInstance), "setSalaryPerMonth should set the correct value.");
        } catch (Exception e) {
            fail("testSalaryPerMonthGettersAndSetters failed: " + e.getMessage());
        }
    }

    @Test
    public void testPermanentGettersAndSetters() {
        try {
            Class<?> teacherClass = Class.forName("evaluations.level11.Teacher");
            Constructor<?> teacherConstructor = teacherClass.getConstructor(int.class, String.class, int.class, boolean.class);
            Object teacherInstance = teacherConstructor.newInstance(1, "Alice", 120000, false);

            Method isPermanent = teacherClass.getMethod("isPermanent");
            assertEquals(false, isPermanent.invoke(teacherInstance), "isPermanent should return the correct value.");

            Method setPermanent = teacherClass.getMethod("setPermanent", boolean.class);
            setPermanent.invoke(teacherInstance, true);

            assertEquals(true, isPermanent.invoke(teacherInstance), "setPermanent should set the correct value.");
        } catch (Exception e) {
            fail("testPermanentGettersAndSetters failed: " + e.getMessage());
        }
    }
}
