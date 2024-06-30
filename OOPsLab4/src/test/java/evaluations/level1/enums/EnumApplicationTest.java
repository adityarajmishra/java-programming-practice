package evaluations.level1.enums;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnumApplicationTest {

    @Test
    public void testNextLight() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level1.enums.EnumApplication");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method nextLightMethod = clazz.getMethod("nextLight", TrafficLight.class);

        TrafficLight redToGreen = (TrafficLight) nextLightMethod.invoke(instance, TrafficLight.RED);
        assertEquals(TrafficLight.GREEN, redToGreen);

        TrafficLight greenToYellow = (TrafficLight) nextLightMethod.invoke(instance, TrafficLight.GREEN);
        assertEquals(TrafficLight.YELLOW, greenToYellow);

        TrafficLight yellowToRed = (TrafficLight) nextLightMethod.invoke(instance, TrafficLight.YELLOW);
        assertEquals(TrafficLight.RED, yellowToRed);

    }
}
