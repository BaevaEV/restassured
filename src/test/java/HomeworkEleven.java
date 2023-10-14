import io.restassured.RestAssured;
import org.junit.Test;

import pojo.User;
import pojo.UserCreationDTO;



public class HomeworkEleven {

    @Test
    public void createNoteTest() {

        User newUser = new User();
        newUser.setLogin("Maria");
        newUser.setPassword("Marimaria");
        newUser.setEmail("Marimaria@ria.ru");
        newUser.setNewNote("Новая заметка", "Невозможно постоянно придумывать контент", "зеленый", Integer.parseInt("7"));

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
