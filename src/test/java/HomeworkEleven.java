import io.restassured.RestAssured;
import lombok.*;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Test;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import pojo.User;
import pojo.UserCreationDTO;

import static io.restassured.RestAssured.given;
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class HomeworkEleven {

    @Test
    public void createNoteTest() {

        User newUser = new User();
        newUser.setLogin("Amy");
        newUser.setPassword("Farrah_Fowler");
        newUser.setEmail("amy-amy@amy.ru");
        newUser.setNewNoteAmy();

        UserCreationDTO userCreationDTO = new UserCreationDTO();
        userCreationDTO.setLogin(newUser.getLogin());
        userCreationDTO.setPassword(newUser.getPassword());
        userCreationDTO.setEmail(newUser.getEmail());
        userCreationDTO.setNotes(newUser.getNotes());

        String urlRegistry = "http://172.24.120.5:8081/api/registration";

        RestAssured.given()
                .log().all()
                .body(userCreationDTO)
                .contentType("application/json")
                .post(urlRegistry)
                .then().log().all()
                .statusCode(201);
    }

}
