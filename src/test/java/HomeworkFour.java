import io.restassured.RestAssured;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HomeworkFour{
    @Test
    public void QueryParamTest(){
        RestAssured.given()
                .log().uri()
                .queryParam("name", "Весна, весна")
                .queryParam("count", "2")
                .get("http://172.24.120.5:8081/api/users/BAEVA/notes")
                .then()
                .log().all()
                .statusCode(200);

//                .statusCode(403);
    }


    @Test
    public void FormParamsTest() {
        Map<String, String> params = new HashMap<>();
        params.put("username", "BAEVA");
        params.put("password", "Start123");

        RestAssured.given()
                .log().uri()
                .formParams(params)
                .get("http://172.24.120.5:8081/api/login")
                .then()
                .log().all()
                .statusCode(200);

    }

}