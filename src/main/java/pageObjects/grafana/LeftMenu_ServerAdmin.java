package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LeftMenu_ServerAdmin {

    @FindBy(how = How.XPATH, using = "//a[@href='/admin/users']")
    public WebElement link_users;

    @FindBy(how = How.XPATH, using = "//a[@href='/admin/orgs']")
    public WebElement link_orgs;

    @FindBy(how = How.XPATH, using = "//a[@href='/admin/setting']")
    public WebElement link_settings;

}
