import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;

public class WalletModel {

    private String url;
    private String inputLine;
    private URL urlObject;
    private HttpURLConnection connection;
    private BufferedReader in;
    private JSONObject jsonResponse;

    public JSONObject getJSON(String url) throws IOException {
        urlObject = new URL(url);
        connection = (HttpURLConnection) urlObject.openConnection();
        connection.setRequestMethod("GET");
        in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return jsonResponse = new JSONObject(response.toString());
    }


    public JSONObject getJsonResponse() {
        return jsonResponse;
    }

    public void setJsonResponse(JSONObject jsonResponse) {
        this.jsonResponse = jsonResponse;
    }
}

   

