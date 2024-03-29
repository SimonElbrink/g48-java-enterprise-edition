package se.lexicon.lecturejpa.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.lecturejpa.entity.Student;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;


    @Transactional
    @Test
    public void testSaveAndFindById() {
        Student student = new Student("Test", "Testsson", "test@test.se");
        Student savedStudent = studentRepository.save(student);
        Assertions.assertNotNull(savedStudent);
        Assertions.assertNotNull(savedStudent.getId());
    }
}
