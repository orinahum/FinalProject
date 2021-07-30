package Helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class TempAPI {

    RequestSpecification httpRequest;
    Response response;
    String url = "http://127.0.0.1:3000/";


    public void testingAPI() {
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given().auth().preemptive().basic("admin", "admin");
        JSONObject params = new JSONObject();

        // Get Request
        response = httpRequest.get("/api/teams/search");
        response.prettyPrint();

        // Post Request
        params.put("name","BTeam");
        params.put("email","BTeam@grafana.com");
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post("/api/teams");
        response.prettyPrint();

        // Put Request
        params.put("name","CTeam");
        params.put("email","CTeam@grafana.com");
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.put("/api/teams/4");
        response.prettyPrint();

        // Delete Request
        response = httpRequest.delete("/api/teams/4");
        response.prettyPrint();
    }

}
