import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Scanner;
//Test
@SuppressWarnings("SpellCheckingInspection")
class WalletController {
    private final WalletModel model;
    private final WalletView view;
    private String api_Key;
    private String recipient_Address;
    private Double amount;
    private String secret_Key;


    WalletController(WalletView view, WalletModel model) {
        this.view = view;
        this.model = model;
    }

    private void accessAccountBalance(String APIKEY) throws IOException, JSONException {
        String sb = "https://block.io/api/v2/get_balance/?api_key=";
        sb += APIKEY;
        model.setJsonResponse(model.getJSON(sb));
    }

    private void withDrawFromAccount(String APIKEY, Double amount_to_send, String adress_to_send_to, String secret_pin) throws IOException, JSONException {
        String sb = "https://block.io/api/v2/withdraw/?api_key=" + APIKEY + "&amounts=" + amount_to_send + "&to_addresses=" + adress_to_send_to + "&pin=" + secret_pin;
        // System.out.println(sb);

        model.setJsonResponse(model.getJSON(sb));
    }

    public String obtainAPIKEY() {
        view.obtain_Key_String();
        Scanner reader = new Scanner(System.in);
        api_Key = reader.next();
        return api_Key;
    }

    private Double obtainAmount() {
        view.obtain_Amount_To_Send();
        Scanner reader = new Scanner(System.in);
        amount = reader.nextDouble();
        return amount;
    }

    private String obtainSecret_Key() {
        view.obtain_Secret_Key();
        Scanner reader = new Scanner(System.in);
        secret_Key = reader.next();
        return secret_Key;
    }

    private String obtainReciepient_adresss() {
        view.obtain_Recipient_Address();
        Scanner reader = new Scanner(System.in);
        recipient_Address = reader.next();
        return recipient_Address;
    }

    private void setRecipent_Adress(String recipient_Address) {
        this.recipient_Address = recipient_Address;
    }

    public void setAPIkey(String api_Key) {
        this.api_Key = api_Key;
    }

    private void setSecret_Key(String secret_Key) {
        this.secret_Key = secret_Key;
    }

    private String getApi_Key() {
        return api_Key;
    }

    private String getrecipient_Address() {
        return recipient_Address;
    }

    private double getAmount() {
        return amount;
    }

    private void setAmount(double amount) {
        this.amount = amount;
    }

    private String getSecret_Key() {
        return secret_Key;
    }


    public void pickOption() throws IOException, JSONException {
        int x;
        boolean exit = true;
        view.pickOptionString();
        //noinspection ConstantConditions
        while (exit) {
            Scanner reader = new Scanner(System.in);
            x = reader.nextInt();


            switch (x) {
                case 1:
                    accessAccountBalance(getApi_Key());
                    view.getBalance(model.getJsonResponse());
                    break;
                case 2:
                    accessAccountBalance(getApi_Key());
                    view.getNetwork(model.getJsonResponse());
                    break;
                case 3:
                /*
                1)Get ApiKey
                2)Get Pin
                3)Get RecipientAddress
                4)Get Amount to send
                5)Send
                6)Confirm.
                */
                    //Test address: 2MxviUjH41KYbgndhTQe6LstF1yqyqKhqEb
                    //Test Key: 	e5ed-0847-8256-7f49
                    setSecret_Key(obtainSecret_Key());
                    setRecipent_Adress(obtainReciepient_adresss());
                    setAmount(obtainAmount());

                    withDrawFromAccount(getApi_Key(), getAmount(), getrecipient_Address(), getSecret_Key());
                    view.getStatus(model.getJsonResponse());
                    JSONObject jsreponse = model.getJsonResponse();
                    System.out.println(jsreponse.getString("status"));
                    view.get_Amount_Sent(model.getJsonResponse());
                    view.get_Network_Fee(model.getJsonResponse());

                    break;
                case 4:
                    view.printAccountDetails(model.getJsonResponse());
                    break;
                case 5:
                    exit = false;
                    System.exit(0);
                    break;
                case 6:
                    view.pickOptionString();
                    break;
                default:
                    view.IncorrectOption();
                    break;

            }
        }
    }
}
