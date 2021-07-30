package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ServerAdmin_EditUser {

    @FindBy(how = How.CSS, using = "button[class='css-1vxgxz7-button']")
    public WebElement btn_deleteUser;

    @FindBy(how = How.CSS, using = "div[class='css-1n9me5o'] button[class='css-1vxgxz7-button']")
    public WebElement btn_confirmDeleteUser;
}
