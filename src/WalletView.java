import org.json.JSONException;
import org.json.JSONObject;

public class WalletView {

    public void getNetwork(JSONObject Response) throws JSONException {
        System.out.println("Network : " + Response.getJSONObject("data").getString("network"));
    }

    public void getBalance(JSONObject Response) throws JSONException {
        System.out.println("Balance : " + Response.getJSONObject("data").getString("available_balance"));
    }

    public void get_Amount_Withdrawn(JSONObject Response){

    }
    public void get_Amount_Sent(JSONObject Response){

    }
    public void get_Network_Fee(JSONObject Response){

    }
    public void withdrawAmount(){
        System.out.println("");
    }

    public void getStatus(JSONObject Response) throws JSONException {
        System.out.println("Status : " + Response.getString("status"));
    }

    public void printAccountDetails(JSONObject Response) throws JSONException {
        System.out.println("Status : " + Response.getString("status"));
        System.out.println("Network : " + Response.getJSONObject("data").getString("network"));
        System.out.println("Balance : " + Response.getJSONObject("data").getString("available_balance"));
    }

    public void ObtainKeyString() {
        System.out.println("Please Enter API Key");
    }
    public void ObtainSecretKey() {
        System.out.println("Please Enter Secret Pin");
    }
    public void IncorrectOption() {
        System.out.println("Incorrect option, please try again.");
    }

    public void pickOptionString() {
        System.out.println("" +
                "\n1. Check Account Balance." +
                "\n2. Check Account Type" +
                "\n3. Send Currency to an Address" +
                "\n4. Print Account Details" +
                "\n5. Exit");

    }

}
