package org.skillovilla.genericclassesandmethods.level3;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

class PrinterTest {

    @Test
    void testPrinterTransformation() throws NoSuchMethodException {
        // Check if Printer class has the printMessageTwo method
        Class<Printer> printerClass = Printer.class;
        Method printMessageTwoMethod = null;

        // Search for a method with the expected signature
        for (Method method : printerClass.getMethods()) {
            if (method.getName().equals("printMessageTwo")) {
                printMessageTwoMethod = method;
                break;
            }
        }

        // Check if the method was found and if it has one parameter
        assertNotNull(printMessageTwoMethod, "printMessageTwo method not found");
        assertEquals(1, printMessageTwoMethod.getParameterCount(), "printMessageTwo method should have one parameter");

        // Check if the parameter is a generic type
        assertTrue(printMessageTwoMethod.getTypeParameters().length > 0, "printMessageTwo method should have a generic type parameter");
    }
}
