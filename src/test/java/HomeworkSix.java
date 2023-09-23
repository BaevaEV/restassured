import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HomeworkSix {

    @Test
    public void FormParamsTest() {
        Map<String, String> params = new HashMap<>();
        params.put("username", "BAEVA");
        params.put("password", "Start123");

        JsonPath responce = RestAssured.given()
                .log().uri()
                .formParams(params)
                .get("http://172.24.120.5:8081/api/login")
                .jsonPath();


        String token = responce.get("access_token");
        if(token!= null){
            System.out.println("ПОЛУЧЕНЫЙ ТОКЕН: "+ token);
        } else {
            System.out.println("Полученный токен равен null");
        }

        RestAssured.given()
                .log().all()
                .header("Authorization", "Bearer " + token)
                .get("http://172.24.120.5:8081/api/users/BAEVA/notes/archive")
                .then().log().all()
                .statusCode(200);
    }

}
