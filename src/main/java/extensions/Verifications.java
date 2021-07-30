package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;

import java.util.List;

import static org.testng.AssertJUnit.*;

public class Verifications extends CommonOps {

    // WebElements Verification.
    @Step("Verify Text in Element")
    public static void verifyTextInElement(WebElement element, String expected) {
        wait.until(ExpectedConditions.visibilityOf(element));
        assertEquals(element.getText(), expected);
    }

    @Step("Number of Elements")
    public static void numberOfElements(List<WebElement> elementList, int expected) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList.get(elementList.size() -1)));
        assertEquals("\nActual Users:" + elementList.size() + "\nExpected Users:" + expected, elementList.size(), expected);
    }

    @Step("User Exist")
    public static void userExist(WebElement element, String msg) {
        wait.until(ExpectedConditions.visibilityOf(element));
        assertFalse("\nUser already Exist !!", element.isDisplayed() && element.getText().contains(msg));
    }

    @Step("Visibility of Elements (Soft-Assertion)")
    public static void visibilityOfElements(List<WebElement> elementList) {
        int i = 0;
        for (WebElement element : elementList) {
            softAssert.assertTrue(element.isDisplayed(), "Element: " + element.getText() + " is not Displayed");
            i++;
        }
        softAssert.assertAll(i + "/" + elementList.size() + " Element was not Displayed");
    }

    @Step("Verify Elements Displayed")
    public static void verifyExistenceOfElement(List<WebElement> elementList) {
        assertTrue(elementList.size() > 0);
    }

    @Step("Verify Elements Not Displayed")
    public static void verifyNonExistenceOfElement(List<WebElement> elementList) {
        assertTrue(elementList.size() == 0);
    }

    @Step("Verify Text with Text")
    public static void verifyText(String actual, String expected) {
        assertEquals(actual,expected);
    }

    @Step("Verify Number with Number")
    public static void verifyNumber(int actual, int expected) {
        assertEquals(actual,expected);
    }

     // Sikuli Verification.
    @Step("Verify Image Visually")
    public static void visualImage(String expectedImageName) {
        try {
            screen.find(getData("imageRepo") + expectedImageName + ".png");
        } catch (FindFailed findFailed) {
            System.out.println("Error Comparing Image File: " + findFailed);
            fail("Error Comparing Image File: " + findFailed);
        }
    }

}
