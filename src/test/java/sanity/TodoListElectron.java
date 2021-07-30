package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;


@Listeners(utilities.Listeners.class)
public class TodoListElectron extends CommonOps {

    @Test (description = "Test #1 - Add And Verify New Task")
    @Description("This Test add a new task and verifies it in the list of tasks")
    public void test01_AddAndVerifyNewTask() throws InterruptedException {
        ElectronFlows.addNewTask("Learn Java");
        Verifications.verifyNumber(ElectronFlows.getNumberTasks(),1);
    }

    @Test (description = "Test #2 - Add And Verify New Task")
    @Description("This Test add a new task and verifies it in the list of tasks")
    public void test02_AddAndVerifyNewTask() throws InterruptedException {
        ElectronFlows.addNewTask("Learn Java");
        ElectronFlows.addNewTask("Learn C#");
        ElectronFlows.addNewTask("Learn Python");
        Verifications.verifyNumber(ElectronFlows.getNumberTasks(),5);
    }
}
