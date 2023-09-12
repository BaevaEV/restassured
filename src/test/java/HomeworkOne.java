import io.restassured.RestAssured;
import org.junit.Test;

public class HomeworkOne {
    @Test
    public void homeworkOneTest(){
        RestAssured.when()
                .get("http://172.24.120.5:8081/api/users/login_user_lesson/notes/archive")
                .then()
                .statusCode(403);
    }
}
