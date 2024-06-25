package org.skillovilla.level1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

public class Level1Test {

    @Test
    public void testDefaultConstructor() throws Exception {
        Class<?> rectangleClass = Class.forName("org.skillovilla.level1.Rectangle");
        Constructor<?> constructor = rectangleClass.getDeclaredConstructor();
        Object rect = constructor.newInstance();

        Field widthField = rectangleClass.getDeclaredField("width");
        widthField.setAccessible(true);
        int width = (int) widthField.get(rect);

        Field heightField = rectangleClass.getDeclaredField("height");
        heightField.setAccessible(true);
        int height = (int) heightField.get(rect);

        // Check if the width and height are initialized to 0
        assertEquals(0, width, "Width should be initialized to 0");
        assertEquals(0, height, "Height should be initialized to 0");
    }

    @Test
    public void testParameterizedConstructor() throws Exception {
        Class<?> rectangleClass = Class.forName("org.skillovilla.level1.Rectangle");
        Constructor<?> constructor = rectangleClass.getDeclaredConstructor(int.class, int.class);
        Object rect = constructor.newInstance(10, 20);

        Field widthField = rectangleClass.getDeclaredField("width");
        widthField.setAccessible(true);
        int width = (int) widthField.get(rect);

        Field heightField = rectangleClass.getDeclaredField("height");
        heightField.setAccessible(true);
        int height = (int) heightField.get(rect);

        // Check if the width and height are initialized to the provided values
        assertEquals(10, width, "Width should be initialized to 10");
        assertEquals(20, height, "Height should be initialized to 20");
    }
}
