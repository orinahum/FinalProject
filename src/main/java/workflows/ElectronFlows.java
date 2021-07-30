package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utilities.CommonOps;

public class ElectronFlows extends CommonOps {

    @Step("Add New Task to the List")
    public static void addNewTask(String taskName) {
        UIActions.updateText(todolist_Main.txt_create, taskName);
        UIActions.insertKey(todolist_Main.txt_create, Keys.RETURN);
    }

    @Step("Count and Return Number of Tasks")
    public static int getNumberTasks() {
        return todolist_Main.list_tasks.size();
    }

    @Step("Clear List From Tasks")
    public static void clearList() {
        for (int i = 0; i < getNumberTasks(); i++) {
            UIActions.mouseHover(todolist_Main.btn_delete);
        }
    }
}
