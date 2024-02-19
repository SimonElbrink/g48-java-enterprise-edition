package se.lexicon.lecturejpa.dao;

import se.lexicon.lecturejpa.entity.Student;

import java.util.Collection;
import java.util.Optional;

public interface StudentDao {

    //CRUD

    Student persist(Student student);

    Optional<Student> findById(String id);

    Optional<Student> findByEmail(String email);

    Student findByEmailIgnoreCase(String email);

    boolean isStudentStatusTrue(String studentId);

    Collection<Student> findByStatusTrue();

    Collection<Student> findByFirstNameContains(String firstName);

    Collection<Student> findAll();

    void update(Student student);

    void updateStudentStatusToTrue(String studentId);

    void remove(Student student);

}
