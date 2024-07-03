package org.skillovilla.level1;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    @Test
    void testOrderInitialization() throws Exception {
        // Test Order initialization
        Class<?> orderClass = Class.forName("org.skillovilla.level1.Order");
        Object order = orderClass.getDeclaredConstructor(String.class).newInstance("12345");

        Method getOrderIdMethod = orderClass.getMethod("getOrderId");
        Method getStatusMethod = orderClass.getMethod("getStatus");

        String orderId = (String) getOrderIdMethod.invoke(order);
        Enum<?> status = (Enum<?>) getStatusMethod.invoke(order);

        assertEquals("12345", orderId);
        assertEquals(Enum.valueOf((Class<Enum>)Class.forName("org.skillovilla.level1.OrderStatus"), "PENDING"), status);
    }

    @Test
    void testUpdateStatusToProcessing() throws Exception {
        // Test updating status to PROCESSING
        Class<?> orderClass = Class.forName("org.skillovilla.level1.Order");
        Object order = orderClass.getDeclaredConstructor(String.class).newInstance("12345");

        Method updateStatusMethod = orderClass.getMethod("updateStatus", Class.forName("org.skillovilla.level1.OrderStatus"));
        Method getStatusMethod = orderClass.getMethod("getStatus");

        Enum<?> processingStatus = Enum.valueOf((Class<Enum>)Class.forName("org.skillovilla.level1.OrderStatus"), "PROCESSING");
        updateStatusMethod.invoke(order, processingStatus);
        Enum<?> status = (Enum<?>) getStatusMethod.invoke(order);

        assertEquals(processingStatus, status);
    }

    @Test
    void testUpdateStatusToShipped() throws Exception {
        // Test updating status to SHIPPED
        Class<?> orderClass = Class.forName("org.skillovilla.level1.Order");
        Object order = orderClass.getDeclaredConstructor(String.class).newInstance("12345");

        Method updateStatusMethod = orderClass.getMethod("updateStatus", Class.forName("org.skillovilla.level1.OrderStatus"));
        Method getStatusMethod = orderClass.getMethod("getStatus");

        Enum<?> shippedStatus = Enum.valueOf((Class<Enum>)Class.forName("org.skillovilla.level1.OrderStatus"), "SHIPPED");
        updateStatusMethod.invoke(order, shippedStatus);
        Enum<?> status = (Enum<?>) getStatusMethod.invoke(order);

        assertEquals(shippedStatus, status);
    }

    @Test
    void testUpdateStatusToDelivered() throws Exception {
        // Test updating status to DELIVERED
        Class<?> orderClass = Class.forName("org.skillovilla.level1.Order");
        Object order = orderClass.getDeclaredConstructor(String.class).newInstance("12345");

        Method updateStatusMethod = orderClass.getMethod("updateStatus", Class.forName("org.skillovilla.level1.OrderStatus"));
        Method getStatusMethod = orderClass.getMethod("getStatus");

        Enum<?> deliveredStatus = Enum.valueOf((Class<Enum>)Class.forName("org.skillovilla.level1.OrderStatus"), "DELIVERED");
        updateStatusMethod.invoke(order, deliveredStatus);
        Enum<?> status = (Enum<?>) getStatusMethod.invoke(order);

        assertEquals(deliveredStatus, status);
    }

    @Test
    void testUpdateStatusToCancelled() throws Exception {
        // Test updating status to CANCELLED
        Class<?> orderClass = Class.forName("org.skillovilla.level1.Order");
        Object order = orderClass.getDeclaredConstructor(String.class).newInstance("12345");

        Method updateStatusMethod = orderClass.getMethod("updateStatus", Class.forName("org.skillovilla.level1.OrderStatus"));
        Method getStatusMethod = orderClass.getMethod("getStatus");

        Enum<?> cancelledStatus = Enum.valueOf((Class<Enum>)Class.forName("org.skillovilla.level1.OrderStatus"), "CANCELLED");
        updateStatusMethod.invoke(order, cancelledStatus);
        Enum<?> status = (Enum<?>) getStatusMethod.invoke(order);

        assertEquals(cancelledStatus, status);
    }
}
