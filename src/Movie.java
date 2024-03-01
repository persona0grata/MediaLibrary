import java.io.File;

public class Movie {
    private String name;
    private String path;

    public Movie(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
}
