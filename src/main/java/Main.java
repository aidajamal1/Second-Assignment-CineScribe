import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        // TODO --> complete main function
        runMenu();
    }
    public static void runMenu() {
        Scanner scanner = new Scanner(System.in);
        Movie movie;
        Actors actor;
        boolean validMovie = false;
        String movieData = "";
        String movieName = "";

        while (!validMovie) {
            System.out.print("Enter the name of a movie: ");
            movieName = scanner.nextLine();
            movie = new Movie(new ArrayList<>(), "", 0);

            try {
                movieData = movie.getMovieData(movieName);
                JSONObject movieJson = new JSONObject(movieData);

                if (movieJson.has("Error")) {
                    System.out.println("Error: " + movieJson.getString("Error"));
                } else {
                    validMovie = true;
                    movie.getActorListViaApi(movieData);
                    String rating = movie.getRatingViaApi(movieData);
                    int imdbVotes = movie.getImdbVotesViaApi(movieData);

                    System.out.println("Movie: " + movieName);
                    System.out.println("Rating: " + rating);
                    System.out.println("IMDB Votes: " + imdbVotes);
                    System.out.println("Actors: " + movie.actorsList);
                }
            } catch (IOException e) {
                System.out.println("An error occurred while retrieving the movie data. Please try again.");
            }
        }

        System.out.print("Choose an actor from the list: ");
        String actorName = scanner.nextLine();
        actor = new Actors("", true);

        String actorData = actor.getActorData(actorName);
        if (actorData == null) {
            System.out.println("An error occurred while retrieving the actor data. Please try again.");
        } else {
            JSONObject actorJson = new JSONObject(actorData);

            if (actorJson.has("Error")) {
                System.out.println("Error: " + actorJson.getString("Error"));
            } else {
                double netWorth = actor.getNetWorthViaApi(actorData);
                boolean isAlive = actor.isAlive(actorData);
                String dateOfDeath = isAlive ? "N/A" : actor.getDateOfDeathViaApi(actorData);

                System.out.println("Actor: " + actorName);
                System.out.println("Net Worth: " + netWorth);
                System.out.println("Is Alive: " + isAlive);
                System.out.println("Date of Death: " + dateOfDeath);
            }
        }
    }
}