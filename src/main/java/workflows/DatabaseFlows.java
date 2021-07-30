package workflows;

import extensions.DBAction;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import utilities.CommonOps;

import java.util.List;

public class DatabaseFlows extends CommonOps {

    // Web
    static String query = "SELECT User, Password, Comments FROM Employees Where ID=1";
    static List<String> cred = DBAction.getCredentials(query);

    @Step("Business Flow: Grafana Web -> Login with DB Credentials")
    public static void loginDBCredentials() {
        UIActions.updateText(grafana_Login.txt_username, cred.get(0));
        UIActions.updateText(grafana_Login.txt_password, cred.get(1));
        UIActions.click(grafana_Login.btn_login);
        UIActions.click(grafana_Login.btn_skip);
    }

    @Step("Business Flow: Grafana Web -> Search And Verify User from DB Credentials")
    public static void searchDBCredentials(Boolean shouldExists) {
        UIActions.updateTextHuman(grafana_ServerAdmin_Main.txt_search, cred.get(0));
        if (shouldExists.equals(true))
            Verifications.verifyExistenceOfElement(grafana_ServerAdmin_Main.rows);
        else if (shouldExists.equals(false))
            Verifications.verifyNonExistenceOfElement(grafana_ServerAdmin_Main.rows);
        else
            throw new RuntimeException("Invalid Expected Output Option in Data Driven testing, Should be True or False");
    }
}
