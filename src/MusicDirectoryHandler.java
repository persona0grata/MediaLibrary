import java.io.File;

public class MusicDirectoryHandler implements DirectoryHandler {
    @Override
    public File[] listFiles(String directoryPath) {
        File directory = new File(directoryPath);
        return directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".mp3") ||
                name.toLowerCase().endsWith(".wav") ||
                name.toLowerCase().endsWith(".flac"));
    }
}
