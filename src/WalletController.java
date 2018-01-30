import java.io.IOException;
import java.util.Scanner;
/*
Litecoin	b757-b480-5317-c5d9
Bitcoin	bad5-b0bb-cb3c-4cd2
Dogecoin	ef18-dd59-d92d-a556
Litecoin (TESTNET!)	f334-d75d-936c-d163
Bitcoin (TESTNET!)	9708-4b63-4b4e-2358
Dogecoin (TESTNET!)	e5ed-0847-8256-7f49
*/

public class WalletController {
    private WalletModel model;
    private WalletView view;
    private String api_Key;
    private String Recipent_Adress;
    private Double amount;
    private String secret_Key;


    public WalletController(WalletView view, WalletModel model) {
        this.view = view;
        this.model = model;
    }

    public void accessAccountBalance(String APIKEY) throws IOException {
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

    public void setRecipent_Adress(String recipent_Adress) {
        Recipent_Adress = recipent_Adress;
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

    public String getRecipent_Adress() {
        return Recipent_Adress;
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

    public void pickOption() throws IOException {
        int x;
        view.pickOptionString();
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        x = reader.nextInt(); // Scans the next token of the input as an int.

        switch (x) {
            case 1:
                accessAccountBalance(getApi_Key());
                view.getBalance(model.getJsonResponse());
                break;
            case 2:
                //Get Account Coin-Type
                break;
            case 3:
                System.out.println("Send Money");
                setSecret_Key("012345678");
                getApi_Key();
                setAmount(5);
                setRecipent_Adress("2MxviUjH41KYbgndhTQe6LstF1yqyqKhqEb");

                // To send money (Apikey,Amount2Send,Where2Sendto,SecretPin)
                withDrawFromAccount(getApi_Key(), getAmount(), getRecipent_Adress(), getSecret_Key());
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
