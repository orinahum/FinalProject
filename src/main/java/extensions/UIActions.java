package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class UIActions extends CommonOps {

     //Web WebElements Methods
    @Step("Click on Element")
    public static void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    @Step("Update Text Element")
    public static void updateText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    @Step("Update Text Element as Human")
    public static void updateTextHuman(WebElement element, String search) {
        wait.until(ExpectedConditions.visibilityOf(element));
        for (char ch : search.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
            element.sendKeys(ch + "");
        }
    }

    @Step("Update DropDown Element")
    public static void updateDropDown(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(text);
    }

    @Step("Mouse Hover Element")
    public static void mouseHover(WebElement element1, WebElement element2) {
        action.moveToElement(element1).moveToElement(element2).click().build().perform();
    }

    @Step("Mouse Hover Element") // 🠉 Method Overload
    public static void mouseHover(WebElement element1) {
        action.moveToElement(element1).click().build().perform();
    }

    @Step("List Table Row Element Select")
    public static void rowElementSelect(List<WebElement> element, String login) {
        for (WebElement elem : element) {
            if (elem.getText().contains(login)) {
                elem.click();
                break;
            }
        }
    }

    @Step("Insert Key")
    public static void insertKey(WebElement element, Keys keys) {
        element.sendKeys(keys);
    }

     // Sikuli Methods
    @Step("Click on Image")
    public static void Image_click(String screenImage) throws FindFailed {
        screen.click(getData("imageRepo") + screenImage + ".png");
    }
}
