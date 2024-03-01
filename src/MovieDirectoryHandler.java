import java.io.File;

public class MovieDirectoryHandler implements DirectoryHandler {
    @Override
    public File[] listFiles(String directoryPath) {
        File directory = new File(directoryPath);
        return directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".mp4") ||
                name.toLowerCase().endsWith(".avi") ||
                name.toLowerCase().endsWith(".mkv"));
    }
}
