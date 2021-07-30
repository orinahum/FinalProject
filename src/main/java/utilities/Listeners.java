package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listeners extends CommonOps implements ITestListener {

    public void onStart(ITestContext execution) {
        System.out.println("\n+-+-+-+-+ Execution: " + execution.getName() + " START +-+-+-+-+");
    }

    public void onFinish(ITestContext execution) {
        System.out.println("\n+-+-+-+-+ Execution: " + execution.getName() + " FINISH +-+-+-+-+");
    }


    public void onTestStart(ITestResult test) {
        System.out.println("\n+-+-+-+-+ Helper.Test: " + test.getName() + " START +-+-+-+-+");
        if (platform.equalsIgnoreCase("web") || platform.equalsIgnoreCase("electron")) {
            try {
                ScreenRecorderMonte.startRecord(sDF.format(test.getStartMillis()) + "-" + test.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onTestSuccess(ITestResult test) {
        System.out.println("\n+-+-+-+-+ Helper.Test: " + test.getName() + " Successfully Finish +-+-+-+-+");
        if (platform.equalsIgnoreCase("web") || platform.equalsIgnoreCase("electron")) {
            // Stop Recording
            try {
                ScreenRecorderMonte.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Delete Recorded File
            File fileMonte = new File(getData("screenRecDir") + sDF.format(test.getStartMillis()) + "-" + test.getName() + ".avi");
            if (fileMonte.delete()) System.out.println("AVI File: Deleted Successfully");
            else System.out.println("AVI File: Failed to Delete File");
        }
    }

    public void onTestFailure(ITestResult test) {
        System.out.println("\n+-+-+-+-+ Helper.Test: " + test.getName() + " Failed to Finish +-+-+-+-+");
        if (platform.equalsIgnoreCase("web") || platform.equalsIgnoreCase("electron")) {
            // Stop Recording
            try {
                ScreenRecorderMonte.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
            attachScreenshot();
        }
        else if (platform.equalsIgnoreCase("mobile") || platform.equalsIgnoreCase("desktop")) {
            attachScreenshot();
        }
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult test) {
        System.out.println("\n+-+-+-+-+ Helper.Test: " + test.getName() + " Failed Within Success Percentage +-+-+-+-+");
    }

    public void onTestSkipped(ITestResult test) {
        System.out.println("\n+-+-+-+-+ Helper.Test: " + test.getName() + " SKIPPED +-+-+-+-+");
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
