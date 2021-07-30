package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import workflows.ElectronFlows;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {

    /*
    #########################################################################
    Method Name: getDATA
    Method Description: This Method get the data from xml configuration file
    Method Parameters: String
    Method Return: String
    #########################################################################
    */
    public static String getData(String nodName) {
        File xmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;

        try {
            xmlFile = new File(".\\Configuration\\DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
        }
        catch (Exception e) {
            System.out.println("Error Reading XML file: " + e);
        }

        return Objects.requireNonNull(doc).getElementsByTagName(nodName).item(0).getTextContent();
    }

    /*
   #########################################################################
   Method Name: initBrowser
   Method Description: This Method initializes drivers for Browser Tests
   #########################################################################
   */
    public static void initBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFireFoxDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else
            throw new RuntimeException("Invalid Browser Type");

        driver.manage().window().maximize();
//        driver.manage().window().setPosition(new Point(Long.parseLong(getData("xPosition"), Long.parseLong(getData("yPosition"))); // <<-- set manual Position
//        driver.manage().window().setSize(new Dimension(Long.parseLong(getData("widthSize"), Long.parseLong(getData("heightSize"))); <<-- set manual Size(Resolution)
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("timeout")));
        driver.get(getData("urlWeb"));
        ManagePages.initGrafana();

        action = new Actions(driver);
        screen = new Screen();
    }

    /*
   #########################################################################
   Method Name: initChromeDriver
   Method Description: This Method setup Chrome webdriver
   Method Parameters: WebDriver
   Method Return: ChromeDriver
   #########################################################################
   */
    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    /*
   #########################################################################
   Method Name: initFireFoxDriver
   Method Description: This Method setup FireFox webdriver
   Method Parameters: WebDriver
   Method Return: FirefoxDriver
   #########################################################################
   */
    public static WebDriver initFireFoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    /*
   #########################################################################
   Method Name: initIEDriver
   Method Description: This Method setup Internet Explorer webdriver
   Method Parameters: WebDriver
   Method Return: InternetExplorerDriver
   #########################################################################
   */
    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }

    /*
   #########################################################################
   Method Name: initMobile
   Method Description: This Method initializes drivers for Mobile Tests
   #########################################################################
   */
    public static void initMobile() {
        dc.setCapability(MobileCapabilityType.UDID, getData("udid"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,getData("appPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,getData("appActivity"));
        try {
            mobileDriver = new AndroidDriver<>(new URL(getData("appiumServer")), dc);
        } catch (Exception e) {
            System.out.println("Can not connect to appium server, see details: " + e);
        }
        ManagePages.initMortgage();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("timeout")));
    }

    /*
   #########################################################################
   Method Name: initAPI
   Method Description: This Method initializes drivers for API Tests
   #########################################################################
   */
    public static void initAPI() {
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("userNameAPI"), getData("passwordAPI"));
    }

    /*
   #########################################################################
   Method Name: initElectron
   Method Description: This Method initializes drivers for Electron Tests
   #########################################################################
   */
    public static void initElectron() {
        System.setProperty("webdriver.chrome.driver", getData("electronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("electronAppPath"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        ManagePages.initTodoList();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("timeout")));
        action = new Actions(driver);
    }

    /*
   #########################################################################
   Method Name: initDesktop
   Method Description: This Method initializes drivers for Desktop Tests
   #########################################################################
   */
    public static void initDesktop() {
        dc.setCapability("app", getData("calculatorApp"));
        try {
            driver = new WindowsDriver<>(new URL(getData("appiumServerDesktop")), dc);
        } catch (MalformedURLException e) {
            System.out.println("Can not Connect to Appium Server, See Details: " + e);
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("timeout")));
        ManagePages.initCalculator();
    }

    /*
   #########################################################################
   Method Name: startSession
   Method Description: This Method Start new Session for Tests
   #########################################################################
   */
    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName) {
        platform = PlatformName;
        if (platform.equalsIgnoreCase("web"))
            initBrowser(getData("browserName"));
        else if (platform.equalsIgnoreCase("mobile")) {
            initMobile();
        }
        else if (platform.equalsIgnoreCase("api")) {
            initAPI();
        }
        else if (platform.equalsIgnoreCase("electron")) {
            initElectron();
        }
        else if (platform.equalsIgnoreCase("desktop")) {
            initDesktop();
        }
        else
            throw new RuntimeException("Invalid platform name");

        softAssert = new SoftAssert();
        sDF = new SimpleDateFormat("yyyyMMddHHmmss");
        ManageDB.openConnection(getData("dbURL"),getData("dbUserName"),getData("dbPassword"));
    }

    /*
   #########################################################################
   Method Name: CloseSession
   Method Description: This Method Close Session for Tests
   #########################################################################
   */
    @AfterClass
    public void closeSession() {
        if (platform.equalsIgnoreCase("web"))
            driver.quit();
        else if (platform.equalsIgnoreCase("mobile")) {
            mobileDriver.quit();
        }
        else if (platform.equalsIgnoreCase("electron")) {
            driver.quit();
        }
        else if (platform.equalsIgnoreCase("desktop")) {
            driver.quit();
        }

        ManageDB.closeConnection();
    }

    /*
   #########################################################################
   Method Name: afterMethod
   Method Description: This Method re-initializes parameters for Tests
   #########################################################################
   */
    @AfterMethod
    public void afterMethod() {
        if (platform.equalsIgnoreCase("web"))
            driver.get(getData("urlWeb"));
        else if (platform.equalsIgnoreCase("electron"))
            ElectronFlows.clearList();
    }
}
