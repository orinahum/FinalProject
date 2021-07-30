package pageObjects.todoList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {

    @FindBy(how = How.CSS, using = "input[placeholder='Create a task']")
    public WebElement txt_create;

    @FindBy(how = How.CSS, using = "div[class='wrapper_7gdK1 content_3jnKF'] span[class='tag_21fhY']")
    public List<WebElement> list_colors;

    @FindBy(how = How.CSS, using = "div[class='textWrapper_X9gil']")
    public List<WebElement> list_tasks;

    @FindBy(how = How.CSS, using = "svg[class='destroy_19w1q']")
    public WebElement btn_delete;

}
