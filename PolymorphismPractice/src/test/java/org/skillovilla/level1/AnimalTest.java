package org.skillovilla.level1;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {

    @Test
    public void testAnimalSound() throws Exception {
        // Test Animal sound
        Class<?> animalClass = Class.forName("org.skillovilla.level1.Animal");
        Object animal = animalClass.getDeclaredConstructor().newInstance();
        Method makeSoundMethod = animalClass.getMethod("makeSound");
        String sound = (String) makeSoundMethod.invoke(animal);
        assertEquals("Some sound", sound);
    }

    @Test
    public void testDogSound() throws Exception {
        // Test Dog sound
        Class<?> dogClass = Class.forName("org.skillovilla.level1.Dog");
        Object dog = dogClass.getDeclaredConstructor().newInstance();
        Method makeSoundMethod = dogClass.getMethod("makeSound");
        String sound = (String) makeSoundMethod.invoke(dog);
        assertEquals("Bark", sound);
    }

    @Test
    public void testCatSound() throws Exception {
        // Test Cat sound
        Class<?> catClass = Class.forName("org.skillovilla.level1.Cat");
        Object cat = catClass.getDeclaredConstructor().newInstance();
        Method makeSoundMethod = catClass.getMethod("makeSound");
        String sound = (String) makeSoundMethod.invoke(cat);
        assertEquals("Meow", sound);
    }
}
