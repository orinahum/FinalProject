package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.grafana.*;
import pageObjects.mortgage.*;
import pageObjects.todoList.*;

public class ManagePages extends Base {

    public static void initGrafana() {
        grafana_Login = PageFactory.initElements(driver, LoginPage.class);
        grafana_Main = PageFactory.initElements(driver, pageObjects.grafana.MainPage.class);
        grafana_LeftMenu_Main = PageFactory.initElements(driver, LeftMenu_Main.class);
        grafana_LeftMenu_ServerAdmin = PageFactory.initElements(driver, LeftMenu_ServerAdmin.class);
        grafana_ServerAdmin_Main = PageFactory.initElements(driver, ServerAdmin_Main.class);
        grafana_ServerAdmin_NewUser = PageFactory.initElements(driver, ServerAdmin_NewUser.class);
        grafana_ServerAdmin_EditUser = PageFactory.initElements(driver, ServerAdmin_EditUser.class);
    }

    public static void initMortgage() {
        mortgage_Main = new pageObjects.mortgage.MainPage(mobileDriver);
    }

    public static void initTodoList() {
        todolist_Main = PageFactory.initElements(driver,pageObjects.todoList.MainPage.class);
    }

    public static void initCalculator() {
        calculatorMain = PageFactory.initElements(driver,pageObjects.calculator.MainPage.class);
    }
}
