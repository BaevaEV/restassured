import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.hamcrest.text.IsEqualIgnoringWhiteSpace;
import org.junit.Before;
import org.junit.Test;
import pojo.User;
import pojo.UserCreationDTO;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.text.IsEqualIgnoringWhiteSpace.equalToIgnoringWhiteSpace;

public class HomeworkTwelve {
    @Test
    public void createNoteTest() {

        User newUser = new User();
        newUser.setLogin("Velma");
        newUser.setPassword("256325");
        newUser.setEmail("so@cool.ru");
        newUser.setNewNote("Вот снова", "Невозможно постоянно придумывать контент", "зеленый", Integer.parseInt("7"));

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

