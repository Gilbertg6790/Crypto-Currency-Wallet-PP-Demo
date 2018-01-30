import java.io.IOException;

public class WalletDemo {
    public static void main(String[] args) throws IOException {
        WalletModel model = new WalletModel();
        WalletView view = new WalletView();
        WalletController testRun = new WalletController(view, model);


        testRun.setAPIkey(testRun.obtainAPIKEY());
        testRun.pickOption();

    }
}
