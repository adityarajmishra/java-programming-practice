package org.skillovilla.level1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    private Class<?> dogClass;
    private Class<?> catClass;
    private Object dog;
    private Object cat;

    @BeforeEach
    void setUp() throws Exception {
        dogClass = Class.forName("org.skillovilla.level1.Dog");
        dog = dogClass.getDeclaredConstructor(String.class, int.class, String.class)
                      .newInstance("Buddy", 3, "Golden Retriever");

        catClass = Class.forName("org.skillovilla.level1.Cat");
        cat = catClass.getDeclaredConstructor(String.class, int.class, String.class)
                      .newInstance("Whiskers", 2, "Siamese");
    }

    @Test
    void testDog() throws Exception {
        // Test Dog attributes
        Method getNameMethod = dogClass.getMethod("getName");
        Method getAgeMethod = dogClass.getMethod("getAge");
        Method getBreedMethod = dogClass.getMethod("getBreed");

        assertEquals("Buddy", getNameMethod.invoke(dog));
        assertEquals(3, getAgeMethod.invoke(dog));
        assertEquals("Golden Retriever", getBreedMethod.invoke(dog));
    }

    @Test
    void testCat() throws Exception {
        // Test Cat attributes
        Method getNameMethod = catClass.getMethod("getName");
        Method getAgeMethod = catClass.getMethod("getAge");
        Method getBreedMethod = catClass.getMethod("getBreed");

        assertEquals("Whiskers", getNameMethod.invoke(cat));
        assertEquals(2, getAgeMethod.invoke(cat));
        assertEquals("Siamese", getBreedMethod.invoke(cat));
    }
}
