public class HomeworkThree {
    public static class Note {
        public String title;
        public String content;

        public static class Builder {
            private Note newNote;

            public Builder() {
                newNote = new Note();
            }

            public Builder withTitle(String title) {
                newNote.title = title;
                return this;
            }

            public Builder withContent(String content) {
                newNote.content = content;
                return this;
            }

            public Note build() {
                return newNote;
            }
        }

    }

    public static void main(String[] args) {
        Note note1 = new Note.Builder()
                .withTitle("Пиу пиу")
                .withContent("ПиуПиуПиу")
                .build();


        Note note2 = new Note.Builder()
                .withTitle("Туц туц")
                .withContent("ТуцТуцТуц")
                .build();


        Note note3 = new Note.Builder()
                .withTitle("Ла Ла")
                .withContent("ЛаЛаЛа")
                .build();

        System.out.println(note1.title+ " " +note1.content);
        System.out.println(note2.title+ " " +note2.content);
        System.out.println(note3.title+ " " +note3.content);
    }
}
