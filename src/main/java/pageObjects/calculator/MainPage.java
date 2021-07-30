package pageObjects.calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {

    @FindBy(how = How.NAME, using = "Zero")
    private WebElement btn_Zero;

    @FindBy(how = How.NAME, using = "One")
    private WebElement btn_One;

    @FindBy(how = How.NAME, using = "Two")
    private WebElement btn_Two;

    @FindBy(how = How.NAME, using = "Three")
    private WebElement btn_Three;

    @FindBy(how = How.NAME, using = "Four")
    private WebElement btn_Four;

    @FindBy(how = How.NAME, using = "Five")
    private WebElement btn_Five;

    @FindBy(how = How.NAME, using = "Six")
    private WebElement btn_Six;

    @FindBy(how = How.NAME, using = "Seven")
    private WebElement btn_Seven;

    @FindBy(how = How.NAME, using = "Eight")
    private WebElement btn_Eight;

    @FindBy(how = How.NAME, using = "Nine")
    private WebElement btn_Nine;

    @FindBy(how = How.NAME, using = "Divide")
    private WebElement btn_Divide;

    @FindBy(how = How.NAME, using = "Multiply")
    private WebElement btn_Multiply;

    @FindBy(how = How.NAME, using = "Minus")
    private WebElement btn_Minus;

    @FindBy(how = How.NAME, using = "Plus")
    private WebElement btn_Plus;

    @FindBy(how = How.NAME, using = "Equals")
    private WebElement btn_Equals;

    @FindBy(how = How.NAME, using = "Clear")
    private WebElement btn_Clear;

    @FindBy(how = How.XPATH, using = "//*[@AutomationId='CalculatorResults']")
    private WebElement field_Result;

    public WebElement getBtn_Zero() {
        return btn_Zero;
    }

    public WebElement getBtn_One() {
        return btn_One;
    }

    public WebElement getBtn_Two() {
        return btn_Two;
    }

    public WebElement getBtn_Three() {
        return btn_Three;
    }

    public WebElement getBtn_Four() {
        return btn_Four;
    }

    public WebElement getBtn_Five() {
        return btn_Five;
    }

    public WebElement getBtn_Six() {
        return btn_Six;
    }

    public WebElement getBtn_Seven() {
        return btn_Seven;
    }

    public WebElement getBtn_Eight() {
        return btn_Eight;
    }

    public WebElement getBtn_Nine() {
        return btn_Nine;
    }

    public WebElement getBtn_Divide() {
        return btn_Divide;
    }

    public WebElement getBtn_Multiply() {
        return btn_Multiply;
    }

    public WebElement getBtn_Minus() {
        return btn_Minus;
    }

    public WebElement getBtn_Plus() {
        return btn_Plus;
    }

    public WebElement getBtn_Equals() {
        return btn_Equals;
    }

    public WebElement getBtn_Clear() {
        return btn_Clear;
    }

    public WebElement getField_Result() {
        return field_Result;
    }
}
