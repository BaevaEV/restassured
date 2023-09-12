import io.restassured.RestAssured;
import org.junit.Test;

public class HomeworkTwo {
    @Test
    public void homeworkPrettyTest(){
        RestAssured.given()
                .get("http://172.24.120.5:8081/api/users/login_user_lesson/notes/archive")
                .andReturn()
                .prettyPrint();
    }

    @Test
    public void homeworkLogTest(){
        RestAssured.given()
                .log().all()
                .get("http://172.24.120.5:8081/api/users/login_user_lesson/notes/archive")
                .then()
                .log().all()
                .statusCode(403);
    }

    @Test
    public void homeworkFailedTest(){
        RestAssured.given()
                .get("http://172.24.120.5:8081/api/users/login_user_lesson/notes/archive")
                .then()
                .log().ifValidationFails()
                .statusCode(200);
    }

    @Test
    public void homeworkBodyTest(){
        RestAssured.given()
                .get("http://172.24.120.5:8081/api/users/login_user_lesson/notes/archive")
                .then()
                .log().body()
                .statusCode(403);
    }

    @Test
    public void homeworkHeadersTest(){
        RestAssured.given()
                .get("http://172.24.120.5:8081/api/users/login_user_lesson/notes/archive")
                .then()
                .log().headers()
                .statusCode(403);
    }
}
