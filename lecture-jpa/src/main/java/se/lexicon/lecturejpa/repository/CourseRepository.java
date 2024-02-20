package se.lexicon.lecturejpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.lecturejpa.entity.Course;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

    //SQL Query: SELECT * FROM course c JOIN courses_instructors ci ON c.id = ci.course_id join instructor i on i.id = ci.instructor_id where ci.instructor_id = ?;
    List<Course> findByInstructors_Id(Long instructorId);
}
