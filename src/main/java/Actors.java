import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;
public class Actors {
    public static final String API_KEY = "uSxIS8dI89aRXW3tKAuaYA==QlJOYpqUJbdVWCw9";   // TODO --> add your api key about Actors here
    String netWorth;
    Boolean isAlive;

    public Actors(String netWorth, boolean isAlive){
        //TODO --> (Write a proper constructor using the get_from_api functions)
        this.netWorth = netWorth;
        this.isAlive = isAlive;
    }
    @SuppressWarnings({"deprecation"})
    /**
     * Retrieves data for the specified actor.
     * @param name for which Actor should be retrieved
     * @return a string representation of the Actors info or null if an error occurred
     */
    public String getActorData(String name) {
        try {
            URL url = new URL("https://api.api-ninjas.com/v1/celebrity?name="+
                    name.replace(" ", "+")+"&apikey="+API_KEY);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("X-Api-Key", API_KEY);
            System.out.println(connection);
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();
                return response.toString();
            } else {
                return "Error: " + connection.getResponseCode() + " " + connection.getResponseMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public double getNetWorthViaApi(String actorsInfoJson) {
        //TODO --> (This function must return the "NetWorth")
        JSONObject jsonObject = new JSONObject(actorsInfoJson);
        JSONArray results = jsonObject.getJSONArray("results");
        if (!results.isEmpty()) {
            JSONObject actorData = results.getJSONObject(0);
            String netWorthString = actorData.optString("net_worth").replace("$", "").replace(",", "");
            return Double.parseDouble(netWorthString);
        }
        return 0.0;
    }

    public boolean isAlive(String actorsInfoJson) {
        //TODO --> (If your chosen actor is alive it must return true otherwise it must return false)
        JSONObject jsonObject = new JSONObject(actorsInfoJson);
        JSONArray results = jsonObject.getJSONArray("results");
        if (!results.isEmpty()) {
            JSONObject actorData = results.getJSONObject(0);
            String status = actorData.optString("is_alive");
            return "true".equalsIgnoreCase(status);
        }
        return false;
    }

    public String getDateOfDeathViaApi(String actorsInfoJson) {
        //TODO --> (If your chosen actor is deceased it must return the date of death)  -->
        JSONObject jsonObject = new JSONObject(actorsInfoJson);
        JSONArray results = jsonObject.getJSONArray("results");
        if (!results.isEmpty()) {
            JSONObject actorData = results.getJSONObject(0);
            return actorData.optString("date_of_death", "N/A");
        }
        return "N/A";
    }

}