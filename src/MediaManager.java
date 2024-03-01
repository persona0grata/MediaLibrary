import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

public class MediaManager {
    private final DirectoryHandler directoryHandler;

    public MediaManager(DirectoryHandler directoryHandler) {
        this.directoryHandler = directoryHandler;
    }

    public Movie[] listMovies() {
        File[] movieFiles = directoryHandler.listFiles("movies");
        if (movieFiles == null || movieFiles.length == 0)
            return null;

        Movie[] movies = new Movie[movieFiles.length];
        for (int i = 0; i < movieFiles.length; i++) {
            movies[i] = new Movie(movieFiles[i].getName(), movieFiles[i].getAbsolutePath());
        }
        return movies;
    }

    public Media[] listMusic() {
        File[] musicFiles = directoryHandler.listFiles("music");
        if (musicFiles == null || musicFiles.length == 0)
            return null;

        Media[] music = new Media[musicFiles.length];
        for (int i = 0; i < musicFiles.length; i++) {
            try {
                AudioFile audioFile = AudioFileIO.read(musicFiles[i]);
                Tag tag = audioFile.getTag();
                String name = musicFiles[i].getName();
                String artist = tag.getFirst(FieldKey.ARTIST);
                String duration = getDurationAsString(audioFile.getAudioHeader().getTrackLength());
                String path = musicFiles[i].getAbsolutePath();
                music[i] = new Media(name, artist, duration, path);
            } catch (CannotReadException | IOException | TagException | ReadOnlyFileException | InvalidAudioFrameException ex) {
                Logger.getLogger(MediaManager.class.getName()).log(Level.SEVERE, null, ex);
                music[i] = new Media(musicFiles[i].getName(), "Unknown", "Unknown", musicFiles[i].getAbsolutePath());
            }
        }
        return music;
    }

    private String getDurationAsString(long durationInSeconds) {
        int minutes = (int) (durationInSeconds / 60);
        int seconds = (int) (durationInSeconds % 60);
        return String.format("%02d:%02d", minutes, seconds);
    }
}
