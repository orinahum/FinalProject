package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;

public class MobileUIActions extends CommonOps {

    @Step("Update Text Element")
    public static void updateText(MobileElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    @Step("Tap on Element")
    public static void tap(int fingers, MobileElement element, int duration) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
//        mobileDriver.tap(fingers, element, duration);
    }

    @Step("Swipe")
    public static void swipe(int startX, int startY, int endX, int endY, int duration) {
        Uninterruptibles.sleepUninterruptibly(150, TimeUnit.MILLISECONDS);
//        mobileDriver.swipe(startX, startY, endX, endY,duration);
    }

    @Step("Zoom Element")
    public static void zoom(MobileElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
//        mobileDriver.zoom(element);
    }

    @Step("Zoom Pinch")
    public static void pinch(MobileElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
//        mobileDriver.pinch(element);
    }

    @Step("Execute Script")
    public static void executeScript(String script) {
        mobileDriver.executeScript(script);
    }
}
