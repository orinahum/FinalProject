package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

import static extensions.Verifications.visibilityOfElements;
import static extensions.Verifications.visualImage;

@Listeners(utilities.Listeners.class)
public class GrafanaWeb extends CommonOps {

    @Test(description = "Test #1 - Verify Header")
    @Description("This Test verifies login & verifies main header text")
    public void test01_verifyHeader() {
        WebFlows.login(getData("userName"), getData("password"));
        Verifications.verifyTextInElement(grafana_Main.head_Dashboard, "Welcome to Grafana");
    }

//    @Test(description = "Test #2 - Verify Default Users")
//    @Description("This Test verifies default user in the system")
//    public void test02_verifyDefaultUsers() {
//        UIActions.mouseHover(grafana_LeftMenu_Main.btn_server, grafana_LeftMenu_ServerAdmin.link_users);
//        Verifications.numberOfElements(grafana_ServerAdmin_Main.rows, 1);
//    }
//
//    @Test (description = "Test #3 - Verify New User")
//    @Description("This Test create new user & verifies if user not exist & create new")
//    public void test03_verifyNewUser() {
//        UIActions.mouseHover(grafana_LeftMenu_Main.btn_server, grafana_LeftMenu_ServerAdmin.link_users);
//        WebFlows.createNewUser("Grafana Server", "grafana@server.com", "grafanaUser", "grafana");
//        Verifications.userExist(grafana_ServerAdmin_NewUser.errorMsg,"exist");
//        Verifications.numberOfElements(grafana_ServerAdmin_Main.rows, 2);
//    }
//
//    @Test (description = "Test #4 - Verify Delete User")
//    @Description("This Test delete user by name & verifies if deleted")
//    public void test04_verifyDeleteUser() throws InterruptedException {
//        UIActions.mouseHover(grafana_LeftMenu_Main.btn_server, grafana_LeftMenu_ServerAdmin.link_users);
//        WebFlows.deleteLastUser();
//        UIActions.mouseHover(grafana_LeftMenu_Main.btn_server, grafana_LeftMenu_ServerAdmin.link_users);
//        Verifications.numberOfElements(grafana_ServerAdmin_Main.rows, 1);
//    }
//
//    @Test (description = "Test #5 - Verify Page Toolbar Elements")
//    @Description("This Test verifies if all page toolbar element exist (Soft-Assertion)")
//    public void test05_verifyPageToolbarElements() {
//        visibilityOfElements(grafana_Main.list_TopRightPageToolbar);
//    }
//
//    @Test (description = "Test #6 - Verify in Page Avatar Image")
//    @Description("This Test verifies the Avatar Image (Sikuli Api)")
//    public void test06_verifyAvatarImage() throws FindFailed {
//        visualImage("Grafana_Admin_User_Avatar");
//        WebFlows.clickAvatar("Grafana_Admin_User_Avatar");
//    }

    @Test (description = "Test #7 - Search Users", dataProvider = "data-provider-users", dataProviderClass = utilities.ManageDDT.class)
    @Description("This Test Searched User in a table using DDT")
    public void test07_searchUsers(String user, String shouldExist)  {
        UIActions.mouseHover(grafana_LeftMenu_Main.btn_server, grafana_LeftMenu_ServerAdmin.link_users);
        WebFlows.searchAndVerifyUser(user, Boolean.parseBoolean(shouldExist));
    }
}