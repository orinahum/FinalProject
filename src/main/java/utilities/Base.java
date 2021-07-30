package utilities;

import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.grafana.*;
import pageObjects.mortgage.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class Base {

    // General
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert softAssert;
    protected static Screen screen;
    protected static String platform;
    protected static SimpleDateFormat sDF;

    // Web & WinAppDriver
    protected static WebDriver driver;

    // Mobile
    protected static AppiumDriver mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();

    // Page Objects - Web -> Grafana
    protected static LoginPage grafana_Login;
    protected static pageObjects.grafana.MainPage grafana_Main;
    protected static LeftMenu_Main grafana_LeftMenu_Main;
    protected static LeftMenu_ServerAdmin grafana_LeftMenu_ServerAdmin;
    protected static ServerAdmin_Main grafana_ServerAdmin_Main;
    protected static ServerAdmin_NewUser grafana_ServerAdmin_NewUser;
    protected static ServerAdmin_EditUser grafana_ServerAdmin_EditUser;

    // Page Objects - Mobile -> Appium ->> UK Mortgage Calculator
    protected static pageObjects.mortgage.MainPage mortgage_Main;

    // Rest API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;

    // Page Objects - Electron -> TodoList
    protected static pageObjects.todoList.MainPage todolist_Main;

    // Page Objects - Desktop
    protected static pageObjects.calculator.MainPage calculatorMain;

    // DataBase
    protected static Connection con;
    protected static Statement stmt;
    protected static ResultSet rs;
    protected static ResultSetMetaData rsmd;
}
