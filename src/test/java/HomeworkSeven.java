import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class HomeworkSeven {

    private String urlLogin = "http://172.24.120.5:8081/api/login";
    private String urlCreate = "http://172.24.120.5:8081/api/users/BAEVA/notes";

    @Test
    public void createNoteTest() {

        JsonPath responseBody = getRequest();
        String token = getAccessToken(responseBody);


        ArrayList<Map<String, String>> arrayList = new ArrayList<>();
        Map<String, String> createNoteBody = new HashMap<>();
        createNoteBody.put("name", "Автотесты");
        createNoteBody.put("content", "это круто!");
        createNoteBody.put("color", "красный");
        createNoteBody.put("priority", "0");
        arrayList.add(createNoteBody);


        RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .log().all()
                .body(arrayList)
                .contentType("application/json")
                .post(urlCreate)
                .then().log().all()
                .statusCode(201);

    }
    private JsonPath getRequest(){
        Map<String, String> loginParams = new HashMap<>();
        loginParams.put("username", "BAEVA");
        loginParams.put("password", "Start123");

        return given()
                .log().uri()
                .formParams(loginParams)
                .get(urlLogin)
                .jsonPath();
    }

    private String getAccessToken(JsonPath responseBody){
        String token = responseBody.get("access_token");
        Assertions.assertNotNull(token,"Не был получен access_token");
        return token;
    }

}
