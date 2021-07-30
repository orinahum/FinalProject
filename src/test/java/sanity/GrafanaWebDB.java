package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DatabaseFlows;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class GrafanaWebDB extends CommonOps {

    @Test(description = "Test #1 - Login to Grafana with DB Credentials & Verify Header")
    @Description("This Test login with DB Credentials and verifies the main header text")
    public void test01_loginDBandVerifyHeader() {
        DatabaseFlows.loginDBCredentials();
        Verifications.verifyTextInElement(grafana_Main.head_Dashboard, "Welcome to Grafana");
    }

    @Test(description = "Test #2 - Search And Verify User from DB Credentials")
    @Description("This Test use DB Credentials and verifies if User Exist")
    public void test02_searchVerifyUserWithDBCredentials() {
        UIActions.mouseHover(grafana_LeftMenu_Main.btn_server, grafana_LeftMenu_ServerAdmin.link_users);
        DatabaseFlows.searchDBCredentials(true);
    }


}
