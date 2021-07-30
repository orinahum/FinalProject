package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ServerAdmin_Main {

    @FindBy(how = How.CSS, using = "table[class='filter-table form-inline filter-table--hover'] >tbody > tr")
    public List<WebElement> rows;

    @FindBy(how = How.CSS, using = "a[class='css-5tn967-button']")
    public WebElement btn_NewUser;

    @FindBy(how = How.CSS, using = "input[class='css-mtvhwr-input-input']")
    public WebElement txt_search;

}
