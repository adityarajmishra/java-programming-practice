package org.skillovilla.level3;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapeTest {

    @Test
    public void testCircleArea() throws Exception {
        // Test Circle area
        Class<?> circleClass = Class.forName("org.skillovilla.level3.Circle");
        Object circle = circleClass.getDeclaredConstructor(double.class).newInstance(3.0);
        Method calculateAreaMethod = circleClass.getMethod("calculateArea");
        double area = (double) calculateAreaMethod.invoke(circle);
        assertEquals(28.27, area, 0.01);
    }

    @Test
    public void testRectangleArea() throws Exception {
        // Test Rectangle area
        Class<?> rectangleClass = Class.forName("org.skillovilla.level3.Rectangle");
        Object rectangle = rectangleClass.getDeclaredConstructor(double.class, double.class).newInstance(4.0, 5.0);
        Method calculateAreaMethod = rectangleClass.getMethod("calculateArea");
        double area = (double) calculateAreaMethod.invoke(rectangle);
        assertEquals(20.0, area, 0.01);
    }
}
