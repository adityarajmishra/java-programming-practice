package evaluations.level4;


import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ShapeTest {

    @Test
    public void testTriangleInheritance() {
        try {
            // Check if Triangle class exists
            Class<?> triangleClass = Class.forName("evaluations.level4.Triangle");

            // Test Triangle class inheritance
            Method drawMethodInTriangle = triangleClass.getMethod("draw");
            assertEquals(Class.forName("evaluations.level4.Shape"), drawMethodInTriangle.getDeclaringClass(), "Triangle class should inherit draw method from Shape class.");

        } catch (ClassNotFoundException e) {
            fail("Triangle class not found.");
        } catch (NoSuchMethodException e) {
            fail("Method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Triangle inheritance test failed: " + e.getMessage());
        }
    }

    @Test
    public void testCircleInheritance() {
        try {
            // Check if Circle class exists
            Class<?> circleClass = Class.forName("evaluations.level4.Circle");

            // Test Circle class inheritance
            Method drawMethodInCircle = circleClass.getMethod("draw");
            assertEquals(Class.forName("evaluations.level4.Shape"), drawMethodInCircle.getDeclaringClass(), "Circle class should inherit draw method from Shape class.");

        } catch (ClassNotFoundException e) {
            fail("Circle class not found.");
        } catch (NoSuchMethodException e) {
            fail("Method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Circle inheritance test failed: " + e.getMessage());
        }
    }

    @Test
    public void testSquare() {
        try {
            // Check if Square class exists
            Class<?> squareClass = Class.forName("evaluations.level4.Square");

            // Test Square class inheritance
            Method drawMethodInSquare = squareClass.getMethod("draw");
            assertEquals(Class.forName("evaluations.level4.Shape"), drawMethodInSquare.getDeclaringClass(), "Square class should inherit draw method from Shape class.");

            // Test Square class specific method
            Object squareInstance = squareClass.getDeclaredConstructor().newInstance();
            Method squareMethod = squareClass.getMethod("square");
            squareMethod.invoke(squareInstance); // Should print "This is a square"

        } catch (ClassNotFoundException e) {
            fail("Square class not found.");
        } catch (NoSuchMethodException e) {
            fail("Method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Square test failed: " + e.getMessage());
        }
    }

}
