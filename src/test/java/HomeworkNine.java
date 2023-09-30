import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import pojo.Note;
import java.io.File;
import java.io.IOException;

public class HomeworkNine {
    @Test
    public void serializationNoteTest() throws IOException {
        Note newNote = new Note();
        newNote.setName("Осень");
        newNote.setContent("сентябрь");
        newNote.setColor("красный");
        newNote.setPriority("0");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("target/note.json"), newNote);

    }
    @Test
    public void deserializationNoteTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Note newNote = objectMapper.readValue(new File("target/note.json"),Note.class);
        System.out.println(newNote);
    }
}
