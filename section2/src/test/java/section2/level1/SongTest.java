package section2.level1;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SongTest {

    @Test
    public void testSongIdField() {
        try {
            Class<?> songClass = Class.forName("section2.level1.Song");
            Field idField = songClass.getDeclaredField("id");
            assertEquals(int.class, idField.getType(), "id should be of type int.");
            assertEquals(true, Modifier.isPublic(idField.getModifiers()), "id should be public.");
        } catch (ClassNotFoundException e) {
            fail("Song class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testSongNameField() {
        try {
            Class<?> songClass = Class.forName("section2.level1.Song");
            Field nameField = songClass.getDeclaredField("name");
            assertEquals(String.class, nameField.getType(), "name should be of type String.");
            assertEquals(true, Modifier.isPublic(nameField.getModifiers()), "name should be public.");
        } catch (ClassNotFoundException e) {
            fail("Song class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testSongArtistField() {
        try {
            Class<?> songClass = Class.forName("section2.level1.Song");
            Field artistField = songClass.getDeclaredField("artist");
            assertEquals(String.class, artistField.getType(), "artist should be of type String.");
            assertEquals(true, Modifier.isPublic(artistField.getModifiers()), "artist should be public.");
        } catch (ClassNotFoundException e) {
            fail("Song class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }
}
