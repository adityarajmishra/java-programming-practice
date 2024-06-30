package evaluations.level7;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrafficLightTest {

    @Test
    public void testRedLight() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level7.TrafficLight");
        Object redLight = Enum.valueOf((Class<Enum>) clazz, "RED");

        Method getDurationMethod = clazz.getMethod("getDuration");
        Method getActionMethod = clazz.getMethod("getAction");

        int duration = (int) getDurationMethod.invoke(redLight);
        String action = (String) getActionMethod.invoke(redLight);

        assertEquals(30, duration);
        assertEquals("STOP", action);
    }

    @Test
    public void testYellowLight() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level7.TrafficLight");
        Object yellowLight = Enum.valueOf((Class<Enum>) clazz, "YELLOW");

        Method getDurationMethod = clazz.getMethod("getDuration");
        Method getActionMethod = clazz.getMethod("getAction");

        int duration = (int) getDurationMethod.invoke(yellowLight);
        String action = (String) getActionMethod.invoke(yellowLight);

        assertEquals(5, duration);
        assertEquals("WATCH", action);
    }

    @Test
    public void testGreenLight() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level7.TrafficLight");
        Object greenLight = Enum.valueOf((Class<Enum>) clazz, "GREEN");

        Method getDurationMethod = clazz.getMethod("getDuration");
        Method getActionMethod = clazz.getMethod("getAction");

        int duration = (int) getDurationMethod.invoke(greenLight);
        String action = (String) getActionMethod.invoke(greenLight);

        assertEquals(60, duration);
        assertEquals("GO", action);
    }
}
