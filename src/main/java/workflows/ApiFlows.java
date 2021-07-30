package workflows;

import extensions.ApiAction;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class ApiFlows extends CommonOps {

    @Step("Business Flow: API -> Get Team Property")
    public static String getTeamProperty(String jPath) {
        response = ApiAction.get("/api/teams/search");
        return ApiAction.extractFromJSON(response, jPath);
    }

    @Step("Business Flow: API -> Create New Team in Grafana")
    public static void postTeam(String name, String email) {
        params.put("name",name);
        params.put("email",email);
        ApiAction.post(params, "/api/teams");
    }

    @Step("Business Flow: API -> Update Existing Team in Grafana")
    public static void updateTeam(String name, String email, String id) {
        params.put("name",name);
        params.put("email",email);
        ApiAction.put(params, "/api/teams/" + id);
    }

    @Step("Business Flow: API -> Delete Existing Team in Grafana")
    public static void deleteTeam(String id) {
        ApiAction.delete(id);
    }
}
