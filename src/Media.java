public class Media {
    private String name;
    private String artist;
    private String duration;
    private String path;

    public Media(String name, String artist, String duration, String path) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getDuration() {
        return duration;
    }

    public String getPath() {
        return path;
    }
}
