import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class Movie {
    public static final String API_KEY = "bb9c907d";   // TODO --> add your api key about Movie here
    int ImdbVotes;
    ArrayList<String> actorsList;
    String rating;

    public Movie(ArrayList<String> actorsList, String rating, int ImdbVotes){
        //TODO --> (Write a proper constructor using the get_from_api functions)
        this.actorsList = actorsList;
        this.rating = rating;
        this.ImdbVotes = ImdbVotes;
    }

    @SuppressWarnings("deprecation")
    /**
     * Retrieves data for the specified movie.
     *
     * @param title the name of the title for which MovieData should be retrieved
     * @return a string representation of the MovieData, or null if an error occurred
     */

    public String getMovieData(String title) throws IOException {
        URL url = new URL("https://www.omdbapi.com/?t="+title+"&apikey="+API_KEY);
        URLConnection Url = url.openConnection();
        Url.setRequestProperty("Authorization", "Key" + API_KEY);
        BufferedReader reader = new BufferedReader(new InputStreamReader(Url.getInputStream()));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = reader.readLine())!=null) {
            stringBuilder.append(line);
        }
        reader.close();
        //handle an error if the chosen movie is not found
        return stringBuilder.toString();
    }
    public int getImdbVotesViaApi(String moviesInfoJson) {
        //TODO --> (This function must change and return the "ImdbVotes" as an Integer)
        // NOTICE :: you are not permitted to convert this function to return a String instead of an int !!!
        JSONObject jsonObject = new JSONObject(moviesInfoJson);
        String imdbVotesString = jsonObject.optString("imdbVotes").replace(",", "");
        int ImdbVotes = 0;
        if (!imdbVotesString.isEmpty()) {
            ImdbVotes = Integer.parseInt(imdbVotesString);
        }
        return ImdbVotes;
    }

    public String getRatingViaApi(String moviesInfoJson) {
        //TODO --> (This function must return the rating in the "Ratings" part
        // where the source is "Internet Movie Database")  -->
        JSONObject jsonObject = new JSONObject(moviesInfoJson);
        JSONArray ratingsArray = jsonObject.optJSONArray("Ratings");
        if (ratingsArray != null) {
            for (int i = 0; i < ratingsArray.length(); i++) {
                JSONObject ratingObject = ratingsArray.getJSONObject(i);
                if (ratingObject.optString("Source").equals("Internet Movie Database")) {
                    return ratingObject.optString("Value");
                }
            }
        }
        return "";
    }

    public void getActorListViaApi(String movieInfoJson) {
        //TODO --> (This function must return the "Actors" in actorsList)
        JSONObject jsonObject = new JSONObject(movieInfoJson);
        String actors = jsonObject.optString("Actors");
        if (!actors.isEmpty()) {
            String[] actorsArray = actors.split(", ");
            this.actorsList = new ArrayList<>();
            for (String actor : actorsArray) {
                this.actorsList.add(actor);
            }
        }
    }
}