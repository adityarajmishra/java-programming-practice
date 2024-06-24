package evaluations.level7;

public class Artist {
    public int artistId;
    public String name;
    public String country;


    public static class ArtistMetaData {
        public String instagramHandle;
        public String twitterHandle;

        public ArtistMetaData(String instagramHandle, String twitterHandle) {
            this.instagramHandle = instagramHandle;
            this.twitterHandle = twitterHandle;
        }
    }

    public Artist(int artistId, String name, String country) {
        this.artistId = artistId;
        this.name = name;
        this.country = country;
    }
}
