import org.json.JSONException;

import java.io.IOException;
import java.util.Scanner;

public class WalletController {
    private WalletModel model;
    private WalletView view;
    private String api_Key;
    private String Recipent_Address;
    private Double amount;
    private String secret_Key;


    public WalletController(WalletView view, WalletModel model) {
        this.view = view;
        this.model = model;
    }

    public void accessAccountBalance(String APIKEY) throws IOException, JSONException {
        String sb = "https://block.io/api/v2/get_balance/?api_key=";
        sb += APIKEY;
        model.setJsonResponse(model.getJSON(sb));
    }

    public void withDrawFromAccount(String APIKEY, Double amount_to_send, String adress_to_send_to, String secret_pin) throws IOException {
        String sb = "https://block.io/api/v2/withdraw/?api_key=" + APIKEY + "&amounts=" + amount_to_send + "&to_addresses=" + adress_to_send_to + "&pin=" + secret_pin;
        System.out.println(sb);

        //model.setJsonResponse(model.getJSON(sb));
    }

    public String obtainAPIKEY() {
        view.ObtainKeyString();
        Scanner reader = new Scanner(System.in);
        api_Key = reader.next();
        return api_Key;
    }

    public String obtainSecret_Key() {
        view.ObtainSecretKey();
        Scanner reader = new Scanner(System.in);
        secret_Key = reader.next();
        return secret_Key;
    }
    public String obtainReciepient_adresss() {

        Scanner reader = new Scanner(System.in);
        secret_Key = reader.next();
        return secret_Key;
    }

    public void setRecipent_Adress(String recipent_Address) {
        Recipent_Address = recipent_Address;
    }

    public void setAPIkey(String api_Key) {
        this.api_Key = api_Key;
    }
    public void setSecret_Key(String secret_Key) {
        this.secret_Key = secret_Key;
    }

    public String getApi_Key() {
        return api_Key;
    }

    public String getRecipent_Address() {
        return Recipent_Address;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSecret_Key() {
        return secret_Key;
    }
    public void getAmountToSend(){
        Scanner reader = new Scanner(System.in);
        amount = reader.nextDouble();
        setAmount(amount);
    }

    public void pickOption() throws IOException, JSONException {
        int x;
        view.pickOptionString();
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
                System.out.println("Send Money");
                getAmountToSend();
                setRecipent_Adress();

                setRecipent_Adress("2MxviUjH41KYbgndhTQe6LstF1yqyqKhqEb");

                // To send money (Apikey,Amount2Send,Where2Sendto,SecretPin)
                withDrawFromAccount(getApi_Key(), getAmount(), getRecipent_Address(), getSecret_Key());
                break;
            case 4:
                view.printAccountDetails(model.getJsonResponse());
                break;
            case 5:
                System.exit(0);
                break;
            default:
                view.IncorrectOption();
                break;

        }

    }
}
