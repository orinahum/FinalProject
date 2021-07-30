package workflows;

import extensions.DBAction;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;

import java.util.List;

public class WebFlows extends CommonOps {

    @Step("Business Flow: Grafana Web -> Login")
    public static void login(String userName, String password) {
        UIActions.updateText(grafana_Login.txt_username, userName);
        UIActions.updateText(grafana_Login.txt_password, password);
        UIActions.click(grafana_Login.btn_login);
        UIActions.click(grafana_Login.btn_skip);
    }

    @Step("Business Flow: Grafana Web -> Create New User")
    public static void createNewUser(String name, String email, String login, String password) {
        UIActions.click(grafana_ServerAdmin_Main.btn_NewUser);
        UIActions.updateText(grafana_ServerAdmin_NewUser.txt_name, name);
        UIActions.updateText(grafana_ServerAdmin_NewUser.txt_email, email);
        UIActions.updateText(grafana_ServerAdmin_NewUser.txt_login, login);
        UIActions.updateText(grafana_ServerAdmin_NewUser.txt_password, password);
        UIActions.click(grafana_ServerAdmin_NewUser.btn_create);
    }

    @Step("Business Flow: Grafana Web -> Delete User(by login name)")
    public static void deleteLastUser() {
        UIActions.click(grafana_ServerAdmin_Main.rows.get(grafana_ServerAdmin_Main.rows.size() - 1));
        UIActions.click(grafana_ServerAdmin_EditUser.btn_deleteUser);
        UIActions.click(grafana_ServerAdmin_EditUser.btn_confirmDeleteUser);
    }

    @Step("Business Flow: Grafana Web -> Click on Avatar (Sikuli)")
    public static void clickAvatar(String expectedImageName) throws FindFailed {
        UIActions.Image_click(expectedImageName);
    }

    @Step("Business Flow: Grafana Web -> Search And Verify User")
    public static void searchAndVerifyUser(String user, Boolean shouldExists) {
        UIActions.updateTextHuman(grafana_ServerAdmin_Main.txt_search, user);
        if (shouldExists.equals(true))
            Verifications.verifyExistenceOfElement(grafana_ServerAdmin_Main.rows);
        else if (shouldExists.equals(false))
            Verifications.verifyNonExistenceOfElement(grafana_ServerAdmin_Main.rows);
        else
            throw new RuntimeException("Invalid Expected Output Option in Data Driven testing, Should be True or False");
    }

}
