package se.lexicon.lecturejpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;

    //Course is the owner relationship.
    //Many courses can be assigned to one student
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Course(String courseName) {
        this.courseName = courseName;
    }
}
