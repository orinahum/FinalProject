package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;

@Listeners(utilities.Listeners.class)
public class MortgageMobile extends CommonOps {

    @Test(description = "Test #1 - Verify Mortgage")
    @Description("This Test fill in mortgage fields & calculate repayment")
    public void test01_verifyMortgage() {
        MobileFlows.calculateMortgage("1000", "3","4");
        Verifications.verifyTextInElement(mortgage_Main.txt_Repayment, "30.03");
    }
}
