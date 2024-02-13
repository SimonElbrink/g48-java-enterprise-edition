package se.lexicon.lecturejpa.dao;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import se.lexicon.lecturejpa.entity.Student;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
class StudentDaoImplTest {

    @Autowired
    StudentDao studentDao;


    @Test
    public void testPersistStudent(){

        //Arrange
        Student student = new Student("John","Smith","john.smith@test.te");

        //Act
        Student persistedStudent = studentDao.persist(student);

        //Assert
        assertNotNull(persistedStudent);

    }


    //TODO: Add more test cases.







}