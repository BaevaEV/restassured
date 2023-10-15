import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class HomeworkFourteen {


    private String urlLogin = "http://172.24.120.5:8081/api/login";
    private String urlCreate = "http://172.24.120.5:8081";

    JsonPath responseBody = getRequest();
    String token = getAccessToken(responseBody);


    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .addHeader("Authorization", "Bearer " + token)
            .setContentType("application/json")
            .setBaseUri(urlCreate)
            .setBasePath("/api/users/BAEVA/notes")
            .build();

    ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .expectStatusCode(not(equalTo(400)))
            .build();


    @Test
    public void createFullNoteTest() {

        JsonPath responseBody = getRequest();
        String token = getAccessToken(responseBody);


        ArrayList<Map<String, String>> arrayList = new ArrayList<>();
        Map<String, String> createNoteBody = new HashMap<>();
        createNoteBody.put("name", "Автотесты");
        createNoteBody.put("content", "это круто!");
        createNoteBody.put("color", "красный");
        createNoteBody.put("priority", "0");
        arrayList.add(createNoteBody);


        RestAssured.given(requestSpecification)
                .body(arrayList)
                .post()
                .then().spec(responseSpecification);

    }
    @Test
    public void createNoteNameTest() {

        JsonPath responseBody = getRequest();
        String token = getAccessToken(responseBody);


        ArrayList<Map<String, String>> arrayList = new ArrayList<>();
        Map<String, String> createNoteBody = new HashMap<>();
        createNoteBody.put("name", "Автотесты");
        arrayList.add(createNoteBody);


        RestAssured.given(requestSpecification)
                .body(arrayList)
                .post()
                .then().spec(responseSpecification);

    }
    @Test
    public void createNoteNameAndContentTest() {

        JsonPath responseBody = getRequest();
        String token = getAccessToken(responseBody);


        ArrayList<Map<String, String>> arrayList = new ArrayList<>();
        Map<String, String> createNoteBody = new HashMap<>();
        createNoteBody.put("name", "Автотесты");
        createNoteBody.put("content", "это круто!");
        arrayList.add(createNoteBody);




        RestAssured.given(requestSpecification)
                .post()
                .then().spec(responseSpecification);

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

