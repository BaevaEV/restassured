import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HomeworkSix {

    @Test
    public void SetHeaderTest() {
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
    @Test
    public void SetCookieTest() {
        Map<String, String> params = new HashMap<>();
        params.put("username", "BAEVA");
        params.put("password", "Start123");

        JsonPath responce = RestAssured.given()
                .log().uri()
                .formParams(params)
                .get("http://172.24.120.5:8081/api/login")
                .jsonPath();


        String token = responce.get("access_token");
        if (token != null) {
            System.out.println("ПОЛУЧЕНЫЙ ТОКЕН: " + token);
        } else {
            System.out.println("Полученный токен равен null");
        }

        RestAssured.given()
                .log().all()
                .header("Authorization", "Bearer " + token)
                .cookie("cookieName", "cookieValue")
                .get("http://172.24.120.5:8081/api/users/BAEVA/notes/archive")
                .then().log().all()
                .statusCode(200);
    }
    @Test
    public void SetCookiesTest() {
        Map<String, String> params = new HashMap<>();
        params.put("username", "BAEVA");
        params.put("password", "Start123");

        JsonPath responce = RestAssured.given()
                .log().uri()
                .formParams(params)
                .get("http://172.24.120.5:8081/api/login")
                .jsonPath();


        String token = responce.get("access_token");
        if (token != null) {
            System.out.println("ПОЛУЧЕНЫЙ ТОКЕН: " + token);
        } else {
            System.out.println("Полученный токен равен null");
        }

        RestAssured.given()
                .log().all()
                .header("Authorization", "Bearer " + token)
                .cookies("cookieName1", "cookieValue1","cookieName2","cookieValue2")
                .get("http://172.24.120.5:8081/api/users/BAEVA/notes/archive")
                .then().log().all()
                .statusCode(200);
    }

}
