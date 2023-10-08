package pojo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Data
public class Note {

    private String name;
    private String content;
    private String color;
    private String priority;


}
