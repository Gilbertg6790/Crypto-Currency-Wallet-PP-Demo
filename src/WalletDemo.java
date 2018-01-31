import org.json.JSONException;
import java.io.IOException;

class WalletDemo {
    public static void main(String[] args) throws IOException, JSONException {
        WalletModel model = new WalletModel();
        WalletView view = new WalletView();
        WalletController testRun = new WalletController(view, model);

        testRun.setAPIkey(testRun.obtainAPIKEY()); // Need Api key for account access
        testRun.pickOption();

    }
}
