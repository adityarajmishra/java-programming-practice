package section2.level1;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ArtistTest {

    @Test
    public void testArtistIdField() {
        try {
            Class<?> artistClass = Class.forName("section2.level1.Artist");
            Field artistIdField = artistClass.getDeclaredField("artistId");
            assertEquals(int.class, artistIdField.getType(), "artistId should be of type int.");
            assertEquals(true, Modifier.isPublic(artistIdField.getModifiers()), "artistId should be public.");
        } catch (ClassNotFoundException e) {
            fail("Artist class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testArtistNameField() {
        try {
            Class<?> artistClass = Class.forName("section2.level1.Artist");
            Field nameField = artistClass.getDeclaredField("name");
            assertEquals(String.class, nameField.getType(), "name should be of type String.");
            assertEquals(true, Modifier.isPublic(nameField.getModifiers()), "name should be public.");
        } catch (ClassNotFoundException e) {
            fail("Artist class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testArtistCountryField() {
        try {
            Class<?> artistClass = Class.forName("section2.level1.Artist");
            Field countryField = artistClass.getDeclaredField("country");
            assertEquals(String.class, countryField.getType(), "country should be of type String.");
            assertEquals(true, Modifier.isPublic(countryField.getModifiers()), "country should be public.");
        } catch (ClassNotFoundException e) {
            fail("Artist class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testArtistAllArgsConstructor() {
        try {
            Class<?> artistClass = Class.forName("section2.level1.Artist");
            Constructor<?> artistConstructor = artistClass.getConstructor(int.class, String.class, String.class);
            Object artistInstance = artistConstructor.newInstance(1, "Imagine Dragons", "USA");

            Field artistIdField = artistClass.getDeclaredField("artistId");
            Field nameField = artistClass.getDeclaredField("name");
            Field countryField = artistClass.getDeclaredField("country");

            artistIdField.setAccessible(true);
            nameField.setAccessible(true);
            countryField.setAccessible(true);

            assertEquals(1, artistIdField.get(artistInstance), "artistId should be 1.");
            assertEquals("Imagine Dragons", nameField.get(artistInstance), "name should be Imagine Dragons.");
            assertEquals("USA", countryField.get(artistInstance), "country should be USA.");

        } catch (ClassNotFoundException e) {
            fail("Artist class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        } catch (NoSuchMethodException e) {
            fail("Constructor not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Artist constructor test failed: " + e.getMessage());
        }
    }
}
