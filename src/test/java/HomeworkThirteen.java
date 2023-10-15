import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.parsing.Parser;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import pojo.GetMeDTO;
import pojo.Note;
import pojo.User;
import pojo.UserCreationDTO;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;

public class HomeworkThirteen {

    @Test
    public void dtoTest() throws IOException {

        User newUser = new User();
        newUser.setLogin("Mua");
        newUser.setPassword("2563987");
        newUser.setEmail("mail@mail.ru");
        newUser.setNewNote("Придумать текст", "Сложно придумать текст", "зеленый", Integer.parseInt("7"));

        UserCreationDTO userCreationDTO = new UserCreationDTO();
        userCreationDTO.setLogin(newUser.getLogin());
        userCreationDTO.setPassword(newUser.getPassword());
        userCreationDTO.setEmail(newUser.getEmail());
        userCreationDTO.setNotes(newUser.getNotes());

        GetMeDTO getMeDTOExpected = new GetMeDTO();
        getMeDTOExpected.setLogin("Mua");
        getMeDTOExpected.setPassword("2563987");
        getMeDTOExpected.setEmail("mail@mail.ru");
        getMeDTOExpected.setNotes(newUser.setNewNote("Придумать текст", "Сложно придумать текст", "зеленый", Integer.parseInt("7")));

//        GetMeDTO getMeDTOExpected = new ObjectMapper()
//                .readValue(new File("target/newUserAnaNote.json"),GetMeDTO.class);

        RestAssured.defaultParser = Parser.JSON;

        String urlRegistry = "http://172.24.120.5:8081/api/registration";

        GetMeDTO getMeDTOActual = RestAssured.given()
                .log().all()
                .body(userCreationDTO)
                .contentType("application/json")
                .post(urlRegistry)
                .then().log().all()
                .statusCode(201).extract().body().as(GetMeDTO.class);

        Assertions.assertEquals(getMeDTOExpected,getMeDTOActual);
    }

    @Test
    public void schemaTest() throws IOException {

        User newUser = new User();
        newUser.setLogin("Moa");
        newUser.setPassword("2563987");
        newUser.setEmail("mail@mail.ru");
        newUser.setNewNote("Придумать текст", "Сложно придумать текст", "зеленый", Integer.parseInt("7"));

        UserCreationDTO userCreationDTO = new UserCreationDTO();
        userCreationDTO.setLogin(newUser.getLogin());
        userCreationDTO.setPassword(newUser.getPassword());
        userCreationDTO.setEmail(newUser.getEmail());
        userCreationDTO.setNotes(newUser.getNotes());

        RestAssured.defaultParser = Parser.JSON;

        String urlRegistry = "http://172.24.120.5:8081/api/registration";

        RestAssured.given()
                .log().all()
                .body(userCreationDTO)
                .contentType("application/json")
                .post(urlRegistry)
                .then().log().all()
                .statusCode(201).assertThat()
                        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("me_schema.json"));

    }

}
