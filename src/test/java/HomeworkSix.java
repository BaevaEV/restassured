import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;

public class HomeworkSix {

    private String urlLogin = "http://172.24.120.5:8081/api/login";
    private String urlArchive = "http://172.24.120.5:8081/api/users/BAEVA/notes/archive";

    @Test
    public void SetHeaderTest() {

        JsonPath responseBody = getRequest();
        String token = getAccessToken(responseBody);

        RestAssured.given()
                .log().all()
                .header("Authorization", "Bearer " + token)
                .get(urlArchive)
                .then().log().all()
                .statusCode(200);
    }

    @Test
    public void SetCookieTest() {

        JsonPath responseBody = getRequest();
        String token = getAccessToken(responseBody);

        RestAssured.given()
                .log().all()
                .header("Authorization", "Bearer " + token)
                .cookie("cookieName", "cookieValue")
                .get(urlArchive)
                .then().log().all()
                .statusCode(200);
    }

    @Test
    public void SetCookiesTest() {

        JsonPath responseBody = this.getRequest();
        String token = this.getAccessToken(responseBody);

        RestAssured.given()
                .log().all()
                .header("Authorization", "Bearer " + token)
                .cookies("cookieName1", "cookieValue1","cookieName2","cookieValue2")
                .get(urlArchive)
                .then().log().all()
                .statusCode(200);
    }

    private JsonPath getRequest(){
        Map<String, String> params = new HashMap<>();
        params.put("username", "BAEVA");
        params.put("password", "Start123");

        return RestAssured.given()
                .log().uri()
                .formParams(params)
                .get(urlLogin)
                .jsonPath();
    }

    private String getAccessToken(JsonPath responseBody){
        String token = responseBody.get("access_token");
        Assertions.assertNotNull(token,"Не был получен access_token");
        return token;
    }

}
