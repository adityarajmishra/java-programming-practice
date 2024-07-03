package org.skillovilla.level4;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class EmployeeTest {

    @Test
    public void testFullTimeEmployeePay() throws Exception {
        // Test FullTimeEmployee pay and details
        Class<?> fullTimeEmployeeClass = Class.forName("org.skillovilla.level4.FullTimeEmployee");
        Object fullTimeEmployee = fullTimeEmployeeClass.getDeclaredConstructor(String.class, int.class, double.class)
                .newInstance("Alice", 101, 60000);
        Method calculatePayMethod = fullTimeEmployeeClass.getMethod("calculatePay");
        Method getDetailsMethod = fullTimeEmployeeClass.getMethod("getDetails");

        double pay = (double) calculatePayMethod.invoke(fullTimeEmployee);
        String details = (String) getDetailsMethod.invoke(fullTimeEmployee);

        assertEquals(60000, pay);
        assertEquals("ID: 101, Name: Alice", details);
    }

    @Test
    public void testPartTimeEmployeePay() throws Exception {
        // Test PartTimeEmployee pay and details
        Class<?> partTimeEmployeeClass = Class.forName("org.skillovilla.level4.PartTimeEmployee");
        Object partTimeEmployee = partTimeEmployeeClass.getDeclaredConstructor(String.class, int.class, double.class, double.class)
                .newInstance("Bob", 102, 20.0, 100.0);
        Method calculatePayMethod = partTimeEmployeeClass.getMethod("calculatePay");
        Method getDetailsMethod = partTimeEmployeeClass.getMethod("getDetails");

        double pay = (double) calculatePayMethod.invoke(partTimeEmployee);
        String details = (String) getDetailsMethod.invoke(partTimeEmployee);

        assertEquals(2000, pay);
        assertEquals("ID: 102, Name: Bob", details);
    }
}
