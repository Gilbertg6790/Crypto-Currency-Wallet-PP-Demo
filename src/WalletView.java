import org.json.JSONObject;

public class WalletView {

    public void getNetwork(JSONObject Response) {
        System.out.println("Balance : " + Response.getJSONObject("data").getString("network"));
    }

    public void getBalance(JSONObject Response) {
        System.out.println("Balance : " + Response.getJSONObject("data").getString("available_balance"));
    }

    public void get_Amount_Withdrawn(JSONObject Response){

    }
    public void get_Amount_Sent(JSONObject Response){

    }
    public void get_Network_Fee(JSONObject Response){

    }

    public void getStatus(JSONObject Response) {
        System.out.println("Status : " + Response.getString("status"));
    }

    public void printAccountDetails(JSONObject Response) {
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
                "\n3. Print all Details" +
                "\n4. Send Satoshis" +
                "\n5. Exit");

    }

}
