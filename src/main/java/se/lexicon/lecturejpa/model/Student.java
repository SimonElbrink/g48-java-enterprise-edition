package se.lexicon.lecturejpa.model;

import lombok.*;

import java.time.LocalDateTime;

//@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Student {

    private int id;
    @Setter
    private String firstName;
    @Setter
    private String lastName;
    @Setter
    private String email;

    private boolean status;
    private LocalDateTime createDate;
}
