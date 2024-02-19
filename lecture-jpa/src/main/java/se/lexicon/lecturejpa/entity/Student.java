package se.lexicon.lecturejpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

//@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@NamedQuery(name = "findByStatus", query = "SELECT s FROM Student s where s.status = ?1")
//@Entity(name = "TBL_STUDENTS")
@Entity
public class Student {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // For id number generations
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Setter
    @Column(nullable = false, length = 100)
    private String firstName;

    @Setter
    @Column(nullable = false, length = 100)
    private String lastName;

    @Setter
    @Column(nullable = false, unique = true)
    private String email;

//    @Column(name = "_STATUS") // Custom Name in Table
    private boolean status;
    private LocalDateTime createDate;

    @Setter
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

    //One Student can be part of many courses.
    @OneToMany(mappedBy = "student", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Course> courses = new HashSet<>();

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.createDate = LocalDateTime.now();
    }

    //Convenience Methods

    public void addCourse(Course course){
        courses.add(course);
        course.setStudent(this);
    }

    public void removeCourse(Course course){
        courses.remove(course);
        course.setStudent(null);
    }


}
