package evaluations.level7;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SongTest {

    @Test
    public void testSongMetadataAsInnerClass() {
        try {
            // Check if Song class exists
            Class<?> songClass = Class.forName("evaluations.level7.Song");

            // Check if SongMetadata exists as an inner class of Song
            Class<?> songMetadataClass = Class.forName("evaluations.level7.Song$SongMetadata");

            // Check SongMetadata attributes
            Field durationField = songMetadataClass.getDeclaredField("duration");
            assertEquals(int.class, durationField.getType(), "duration should be of type int.");

            Field genreField = songMetadataClass.getDeclaredField("genre");
            assertEquals(String.class, genreField.getType(), "genre should be of type String.");

            // Test SongMetadata constructor and methods
            Constructor<?> songMetadataConstructor = songMetadataClass.getConstructor(int.class, String.class);
            Object songMetadataInstance = songMetadataConstructor.newInstance(300, "Pop");

            // Check if duration and genre are correctly assigned
            durationField.setAccessible(true);
            genreField.setAccessible(true);

            assertEquals(300, durationField.get(songMetadataInstance), "duration should be 300.");
            assertEquals("Pop", genreField.get(songMetadataInstance), "genre should be Pop.");

        } catch (ClassNotFoundException e) {
            fail("Song or SongMetadata class not found.");
        } catch (NoSuchFieldException | NoSuchMethodException e) {
            fail("Field or method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("SongMetadata as inner class test failed: " + e.getMessage());
        }
    }

    @Test
    public void testSongMetadataFileRemoved() {
        // Check that SongMetadata.java file has been removed
        File songMetadataFile = new File("src/main/java/evaluations/level7/SongMetadata.java");
        if (songMetadataFile.exists()) {
            fail("SongMetadata.java file should be removed.");
        }
    }
}
