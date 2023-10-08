package pojo;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Data
public class User {

    private String login;

    private String password;

    private String email;

    private List<Note> notes;

    public void setNewNoteAmy(){
        Note newNoteRa = new Note();
        newNoteRa.setName("radium");
        newNoteRa.setContent("radium is Ra");
        newNoteRa.setColor("оранжевый");
        newNoteRa.setPriority("0");

        Note newNoteCr = new Note();
        newNoteCr.setName("chrome");
        newNoteCr.setContent("chrome is Cr");
        newNoteCr.setColor("зеленый");
        newNoteCr.setPriority("0");

        List<Note> newListNote = new ArrayList<>();
        newListNote.add(newNoteCr);
        newListNote.add(newNoteRa);


        this.notes = newListNote;

    }
    public void setNewNotePenny(){

        Note newNoteNY = new Note();
        newNoteNY.setName("Что я сделаю в Новом году");
        newNoteNY.setContent("Брошу пить алгкоголь, И глинтвейн, И аппероль");
        newNoteNY.setColor("красный");
        newNoteNY.setPriority("0");

        List<Note> newListNote = new ArrayList<>();
        newListNote.add(newNoteNY);

        this.notes = newListNote;

    }

}


