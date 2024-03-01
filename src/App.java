import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select media type:");
        System.out.println("1. Movies");
        System.out.println("2. Music");
        System.out.print("Enter your choice: ");
        int mediaType = scanner.nextInt();

        if (mediaType == 1) {
            MediaManager mediaManager = new MediaManager(new MovieDirectoryHandler());
            DisplayManager displayManager = new DisplayManager();
            Movie[] movies = mediaManager.listMovies();
            displayManager.displayMovies(movies);
            int choice = getUserChoice(movies.length);
            if (choice != -1) {
                MediaPlayer mediaPlayer = new VLCMediaPlayer();
                mediaPlayer.play(movies[choice - 1]);
            }
        } else if (mediaType == 2) {
            MediaManager mediaManager = new MediaManager(new MusicDirectoryHandler());
            DisplayManager displayManager = new DisplayManager();
            Media[] music = mediaManager.listMusic();
            displayManager.displayMedia(music);
            int choice = getUserChoice(music.length);
            if (choice != -1) {
                MediaPlayer mediaPlayer = new VLCMediaPlayer();
                mediaPlayer.play(music[choice - 1]);
            }
        } else {
            System.out.println("Invalid choice. Exiting.");
        }
    }

    private static int getUserChoice(int maxChoice) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the media you want to play: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > maxChoice) {
            return -1;
        }

        return choice;
    }
}
