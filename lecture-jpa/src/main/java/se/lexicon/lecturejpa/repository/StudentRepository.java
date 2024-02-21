package se.lexicon.lecturejpa.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.lecturejpa.entity.Student;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface StudentRepository extends CrudRepository<Student, String> {

    //select * from student where first_name = 'test'
    // Method query to find students by first name and last name
    List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    // Method query to find students by first name
    List<Student> findByFirstName(String firstName);

    // JPQL query to find students by first name
    @Query("select s from Student s where s.firstName =:firstName")
    List<Student> findStudentByFirstName(String firstName);

    // Method query to find students by first name containing a specific string
    List<Student> findByFirstNameContaining(String name);

    // Method query to find student by email ignoring case
    Student findByEmailIgnoreCase(String email);

    // Method query to find students created after a specific date
    List<Student> findByCreateDateAfter(LocalDateTime createDate);

    // JPQL query to update student status to true based on student id
    @Modifying
    @Query("UPDATE Student s set s.status = true where s.id = :studentId")
    void updateStudentByStatusTrue(@Param("studentId") String id);

    // Method query to find students by course name
    List<Student> findByCourses_CourseName(String courseName);

    // Method query to find students by city in the address
    List<Student> findByAddress_City(String city);


}
