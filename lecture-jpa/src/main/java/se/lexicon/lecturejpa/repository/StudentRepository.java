package se.lexicon.lecturejpa.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.lecturejpa.entity.Student;

import java.util.List;


@Repository
public interface StudentRepository extends CrudRepository<Student, String> {

    //select * from student where first_name = 'test'
    List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    //Writing method using Query Methods
    List<Student> findByFirstName(String firstName);

    //Writing method using JPQL Query
    @Query("select s from Student s where s.firstName =:firstName")
    List<Student> findStudentByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    @Modifying
    @Query("UPDATE Student s set s.status = true where s.id = :studentId")
    void updateStudentByStatusTrue(@Param("studentId") String id);

}
