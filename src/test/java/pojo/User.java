package pojo;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class User {

    private String login;

    private String password;

    private String email;

    private List<Note> notes;

    public List<Note> setNewNote(String name, String content, String color, int priority){

        Note newNote = new Note();
        newNote.setName(name);
        newNote.setContent(content);
        newNote.setColor(color);
        newNote.setPriority(String.valueOf(priority));


        List<Note> newListNote = new ArrayList<>();
        newListNote.add(newNote);


        this.notes = newListNote;

        return newListNote;
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


