package org.skillovilla.level2;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    @Test
    public void testEmployeeGettersAndSetters() throws Exception {
        Class<?> employeeClass = Class.forName("org.skillovilla.level2.Employee");
        Object employee = employeeClass.getDeclaredConstructor().newInstance();

        // Test inherited public access modifier
        Method setNameMethod = employeeClass.getMethod("setName", String.class);
        Method getNameMethod = employeeClass.getMethod("getName");
        setNameMethod.invoke(employee, "Bob");
        String name = (String) getNameMethod.invoke(employee);
        assertEquals("Bob", name);

        // Test inherited protected access modifier
        Method setAgeMethod = employeeClass.getMethod("setAge", int.class);
        Method getAgeMethod = employeeClass.getMethod("getAge");
        setAgeMethod.invoke(employee, 30);
        int age = (int) getAgeMethod.invoke(employee);
        assertEquals(30, age);

        // Test inherited default access modifier
        Method setAddressMethod = employeeClass.getMethod("setAddress", String.class);
        Method getAddressMethod = employeeClass.getMethod("getAddress");
        setAddressMethod.invoke(employee, "456 Elm St");
        String address = (String) getAddressMethod.invoke(employee);
        assertEquals("456 Elm St", address);

        // Test inherited private access modifier through public methods
        Method setPhoneNumberMethod = employeeClass.getMethod("setPhoneNumber", String.class);
        Method getPhoneNumberMethod = employeeClass.getMethod("getPhoneNumber");
        setPhoneNumberMethod.invoke(employee, "987-654-3210");
        String phoneNumber = (String) getPhoneNumberMethod.invoke(employee);
        assertEquals("987-654-3210", phoneNumber);

        // Test private access modifier in Employee class
        Method setEmployeeIdMethod = employeeClass.getDeclaredMethod("setEmployeeId", int.class);
        Method getEmployeeIdMethod = employeeClass.getDeclaredMethod("getEmployeeId");
        setEmployeeIdMethod.setAccessible(true);
        getEmployeeIdMethod.setAccessible(true);
        setEmployeeIdMethod.invoke(employee, 1234);
        int employeeId = (int) getEmployeeIdMethod.invoke(employee);
        assertEquals(1234, employeeId);
    }
}
