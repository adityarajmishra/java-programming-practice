package org.skillovilla.level3;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    @Test
    public void testFullTimeEmployeeSalary() throws Exception {
        // Test FullTimeEmployee methods and details
        Class<?> fullTimeEmployeeClass = Class.forName("org.skillovilla.level3.FullTimeEmployee");
        Object fullTimeEmployee = fullTimeEmployeeClass.getDeclaredConstructor(String.class, int.class, double.class)
                                                       .newInstance("Alice", 101, 60000);

        Method calculateSalaryMethod = fullTimeEmployeeClass.getMethod("calculateSalary");
        Method getEmployeeDetailsMethod = fullTimeEmployeeClass.getMethod("getEmployeeDetails");
        Method getSalaryMethod = fullTimeEmployeeClass.getMethod("getSalary");

        double salary = (double) calculateSalaryMethod.invoke(fullTimeEmployee);
        String employeeDetails = (String) getEmployeeDetailsMethod.invoke(fullTimeEmployee);
        double salaryDetails = (double) getSalaryMethod.invoke(fullTimeEmployee);

        assertEquals(60000, salary);
        assertEquals("ID: 101, Name: Alice", employeeDetails);
        assertEquals(60000, salaryDetails);
    }

    @Test
    public void testContractEmployeeSalary() throws Exception {
        // Test ContractEmployee methods and details
        Class<?> contractEmployeeClass = Class.forName("org.skillovilla.level3.ContractEmployee");
        Object contractEmployee = contractEmployeeClass.getDeclaredConstructor(String.class, int.class, double.class, int.class)
                                                       .newInstance("Bob", 102, 20.0, 100);

        Method calculateSalaryMethod = contractEmployeeClass.getMethod("calculateSalary");
        Method getEmployeeDetailsMethod = contractEmployeeClass.getMethod("getEmployeeDetails");
        Method getHourlyRateMethod = contractEmployeeClass.getMethod("getHourlyRate");
        Method getHoursWorkedMethod = contractEmployeeClass.getMethod("getHoursWorked");

        double salary = (double) calculateSalaryMethod.invoke(contractEmployee);
        String employeeDetails = (String) getEmployeeDetailsMethod.invoke(contractEmployee);
        double hourlyRate = (double) getHourlyRateMethod.invoke(contractEmployee);
        int hoursWorked = (int) getHoursWorkedMethod.invoke(contractEmployee);

        assertEquals(2000, salary);
        assertEquals("ID: 102, Name: Bob", employeeDetails);
        assertEquals(20.0, hourlyRate);
        assertEquals(100, hoursWorked);
    }
}
