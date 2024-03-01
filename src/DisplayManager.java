public class DisplayManager {
    public void displayMovies(Movie[] movies) {
        System.out.printf("%-5s | %-50s | %-100s\n", "ID", "MOVIE NAME", "PATH");
        for (int i = 0; i < movies.length; i++) {
            System.out.printf("%-5d | %-50s | %-100s\n", i + 1, movies[i].getName(), movies[i].getPath());
        }
    }

    public void displayMedia(Media[] media) {
        System.out.printf("%-5s | %-50s | %-30s | %-10s\n", "ID", "SONG NAME", "ARTIST", "DURATION");
        for (int i = 0; i < media.length; i++) {
            System.out.printf("%-5d | %-50s | %-30s | %-10s\n", i + 1, media[i].getName(), media[i].getArtist(), media[i].getDuration());
        }
    }
}
