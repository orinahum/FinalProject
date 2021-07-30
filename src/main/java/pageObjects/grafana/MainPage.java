package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {

    @FindBy(how = How.CSS, using = "h1[class='css-1aanzv4']")
    public WebElement head_Dashboard;

    @FindBy(how = How.CSS, using = "div[class='css-p8muss']")
    public List<WebElement> list_TopRightPageToolbar;

}
