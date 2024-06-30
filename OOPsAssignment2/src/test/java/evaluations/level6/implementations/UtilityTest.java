package evaluations.level6.implementations;

import evaluations.level6.Meal;
import evaluations.level6.Shape;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class UtilityTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }


    @Test
    public void testMethodToInvokeDrawSquare() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level6.implementations.Utility");
        Object utilityInstance = clazz.getDeclaredConstructor().newInstance();

        Method method = clazz.getMethod("methodToInvokeDrawSquare");
        Shape shape = (Shape) method.invoke(utilityInstance);

        Method drawMethod = shape.getClass().getMethod("draw");
        Method aboutMethod = shape.getClass().getMethod("about");

        drawMethod.invoke(shape);
        aboutMethod.invoke(shape);

        String output = outputStream.toString().trim();
        assertNotNull(output);
        assertFalse(output.isEmpty());
        assertTrue(shape instanceof Shape);
    }


    @Test
    public void testMethodToInvokeCookBreakfast() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level6.implementations.Utility");
        Object utilityInstance = clazz.getDeclaredConstructor().newInstance();

        Method method = clazz.getMethod("methodToInvokeCookBreakfast");
        Meal meal = (Meal) method.invoke(utilityInstance);

        Method cookMethod = meal.getClass().getMethod("cook");
        Method caloriesMethod = meal.getClass().getMethod("calories");

        cookMethod.invoke(meal);
        caloriesMethod.invoke(meal);

        String output = outputStream.toString().trim();
        assertNotNull(output);
        assertFalse(output.isEmpty());
        assertTrue(meal instanceof Meal);
    }
}
