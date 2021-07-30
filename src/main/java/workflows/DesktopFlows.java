package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class DesktopFlows extends CommonOps {

    @Step("Calculations")
    public static void calculate(String num1, String action, String num2) {
        String[] digits1 = num1.split("(?<=.)");
        String[] digits2 = num2.split("(?<=.)");

        UIActions.click(calculatorMain.getBtn_Clear());
        for (String digit : digits1) {
            if (digit.equals("0")) UIActions.click(calculatorMain.getBtn_Zero());
            else if (digit.equals("1")) UIActions.click(calculatorMain.getBtn_One());
            else if (digit.equals("2")) UIActions.click(calculatorMain.getBtn_Two());
            else if (digit.equals("3")) UIActions.click(calculatorMain.getBtn_Three());
            else if (digit.equals("4")) UIActions.click(calculatorMain.getBtn_Four());
            else if (digit.equals("5")) UIActions.click(calculatorMain.getBtn_Five());
            else if (digit.equals("6")) UIActions.click(calculatorMain.getBtn_Six());
            else if (digit.equals("7")) UIActions.click(calculatorMain.getBtn_Seven());
            else if (digit.equals("8")) UIActions.click(calculatorMain.getBtn_Eight());
            else if (digit.equals("9")) UIActions.click(calculatorMain.getBtn_Nine());
        }

        if (action.equals("+")) UIActions.click(calculatorMain.getBtn_Plus());
        else if (action.equals("-")) UIActions.click(calculatorMain.getBtn_Minus());
        else if (action.equals("*")) UIActions.click(calculatorMain.getBtn_Multiply());
        else if (action.equals("/")) UIActions.click(calculatorMain.getBtn_Divide());

        for (String digit : digits2) {
            if (digit.equals("0")) UIActions.click(calculatorMain.getBtn_Zero());
            else if (digit.equals("1")) UIActions.click(calculatorMain.getBtn_One());
            else if (digit.equals("2")) UIActions.click(calculatorMain.getBtn_Two());
            else if (digit.equals("3")) UIActions.click(calculatorMain.getBtn_Three());
            else if (digit.equals("4")) UIActions.click(calculatorMain.getBtn_Four());
            else if (digit.equals("5")) UIActions.click(calculatorMain.getBtn_Five());
            else if (digit.equals("6")) UIActions.click(calculatorMain.getBtn_Six());
            else if (digit.equals("7")) UIActions.click(calculatorMain.getBtn_Seven());
            else if (digit.equals("8")) UIActions.click(calculatorMain.getBtn_Eight());
            else if (digit.equals("9")) UIActions.click(calculatorMain.getBtn_Nine());
        }

        UIActions.click(calculatorMain.getBtn_Equals());
    }
}
