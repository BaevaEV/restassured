import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.text.IsEqualIgnoringWhiteSpace.equalToIgnoringWhiteSpace;

public class HomeworkTwelveAssertions {

    public String token;
    private String urlLogin = "http://172.24.120.5:8081/api/login";
    private String urlNotes = "http://172.24.120.5:8081/api/users/Penny/notes";

    @Before
    public void goToPennyPage() {
        Map<String, String> params = new HashMap<>();
        params.put("username", "Penny");
        params.put("password", "123123");

        JsonPath response = RestAssured.given()
                .log().uri()
                .formParams(params)
                .get(urlLogin)
                .jsonPath();

        token = response.get("access_token");
    }

    @Test
    public void getPenniesNotes() {

        RestAssured.given().header("Authorization", "Bearer " + token)
                .get(urlNotes)
                .then().log().body()
                .statusCode(200)
                .body("[0].name", equalTo("Что я сделаю в Новом году"),
                        "[0].name", equalToIgnoringCase("что я сделаю в новом году"),
                        "[0].name", equalToIgnoringWhiteSpace("Что я  сделаю в Новом  году"),
                        "[0].content", containsString("глинтвейн"),
                        "[0].content", startsWith("Брошу"),
                        "[0].content", endsWith("аппероль"),
                        "[0].priority", equalTo(0),
                        "[0].priority", greaterThan(-1),
                        "[0].priority", greaterThanOrEqualTo(0),
                        "[0].priority", lessThan(2),
                        "[0].priority", lessThanOrEqualTo(5));

    }
}
