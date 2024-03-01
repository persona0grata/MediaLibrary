import java.io.IOException;

public class VLCMediaPlayer implements MediaPlayer {
    @Override
    public void play(Object media) {
        if (media instanceof Movie) {
            playMovie((Movie) media);
        } else if (media instanceof Media) {
            playMusic((Media) media);
        } else {
            System.out.println("Unsupported media type");
        }
    }

    private void playMovie(Movie movie) {
        String vlcPath = "/usr/bin/vlc";
        try {
            System.out.println("Playing movie: " + movie.getName() + " with VLC player");
            ProcessBuilder pb = new ProcessBuilder(vlcPath, "--quiet", movie.getPath());
            pb.start();
        } catch (IOException e) {
            System.out.println("Error playing movie with VLC: " + e.getMessage());
        }
    }

    private void playMusic(Media music) {
        String vlcPath = "/usr/bin/vlc";
        try {
            System.out.println("Playing music: " + music.getName() + " with VLC player");
            ProcessBuilder pb = new ProcessBuilder(vlcPath, "--quiet", music.getPath());
            pb.start();
        } catch (IOException e) {
            System.out.println("Error playing music with VLC: " + e.getMessage());
        }
    }
}
