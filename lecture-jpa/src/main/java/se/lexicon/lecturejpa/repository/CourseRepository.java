package se.lexicon.lecturejpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.lecturejpa.entity.Course;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

    //SQL Query: SELECT * FROM course c JOIN courses_instructors ci ON c.id = ci.course_id join instructor i on i.id = ci.instructor_id where ci.instructor_id = ?;

    // Method query to find courses by instructor id
    List<Course> findByInstructors_Id(Long instructorId);

    //JPQL query to find courses by instructor id
    @Query("SELECT c FROM Course c JOIN c.instructors i WHERE i.id = :Id")
    List<Course> findCoursesByInstructorId(@Param("Id") Long instructorId);
}
