package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ServerAdmin_NewUser {

    @FindBy(how = How.NAME, using = "name")
    public WebElement txt_name;

    @FindBy(how = How.NAME, using = "email")
    public WebElement txt_email;

    @FindBy(how = How.NAME, using = "login")
    public WebElement txt_login;

    @FindBy(how = How.NAME, using = "password")
    public WebElement txt_password;

    @FindBy(how = How.CSS, using = "button[class='css-5tn967-button']")
    public WebElement btn_create;

    @FindBy(how = How.CSS, using = "div[class='css-hui7p1']")
    public WebElement errorMsg;
}
