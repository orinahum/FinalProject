package workflows;

import extensions.MobileUIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class MobileFlows extends CommonOps {

    @Step("Business Flow: Mobile -> Fill Form and Calculate Mortgage")
    public static void calculateMortgage(String amount, String term, String rate) {
        MobileUIActions.updateText(mortgage_Main.txt_Amount, amount);
        MobileUIActions.updateText(mortgage_Main.txt_Term, term);
        MobileUIActions.updateText(mortgage_Main.txt_Rate, rate);
        MobileUIActions.tap(1,mortgage_Main.btn_Calculator, 500);
    }
}
