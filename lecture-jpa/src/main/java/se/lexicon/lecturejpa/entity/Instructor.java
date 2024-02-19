package se.lexicon.lecturejpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //Collection of courses
    @ManyToMany(mappedBy = "instructors")
    private Set<Course> courses = new HashSet<>();

}
