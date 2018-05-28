package scenarios;

import pages.MenuPage;
import pages.SuccessfulTransferPage;
import pages.TransferFundsPage;

public class TransferFundsScenario implements Scenario <MenuPage, SuccessfulTransferPage>{

    private String amount;
    private int fromAccount;
    private int toAccount;

    public TransferFundsScenario(String amount, int fromAccount, int toAccount) {
        this.amount = amount;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
    }

    public SuccessfulTransferPage run(MenuPage entry){
        return entry.transferFunds()
                .insertAmount(amount)
                .selectAccountFrom(fromAccount)
                .selectAccountTo(toAccount)
                .transferFundsSuccess();

    }




}
