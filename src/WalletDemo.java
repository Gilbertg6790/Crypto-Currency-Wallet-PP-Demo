import org.json.JSONException;
import java.io.IOException;
/*
* Simple Driver class for the MVC wallet prototype, starts off by obtaining the APIkey from the user
* Api key is user specific and will be saved on account basis.
* From there the user can select options based on what they want to do with their coin.
*/

class WalletDemo {
    public static void main(String[] args) throws IOException, JSONException {
        WalletModel model = new WalletModel();
        WalletView view = new WalletView();
        WalletController testRun = new WalletController(view, model);

        testRun.setAPIkey(testRun.obtainAPIKEY()); // Need Api key for account access
        testRun.pickOption(); // Main program loop for options
    }
}
