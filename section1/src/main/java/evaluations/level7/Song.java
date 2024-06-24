package evaluations.level7;

public class Song {

    public int id;
    public String name;
    public String artist;

    public Song(int id, String name, String artist) {
        this.id = id;
        this.name = name;
        this.artist = artist;
    }

    public static class SongMetadata {
        public int duration; // Duration in seconds
        public String genre;

        public SongMetadata(int duration, String genre) {
            this.duration = duration;
            this.genre = genre;
        }
    }
}
