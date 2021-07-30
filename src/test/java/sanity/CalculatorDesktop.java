package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;

@Listeners(utilities.Listeners.class)
public class CalculatorDesktop extends CommonOps {

    @Test(description = "Test #1 - Verify Calculated Result")
    @Description("This Test do Calculate and verify the Result")
    public void test01_VerifyCalculatedResult() {
        DesktopFlows.calculate("10", "+", "12");
        Verifications.verifyTextInElement(calculatorMain.getField_Result(),"Display is 22");
    }

}
