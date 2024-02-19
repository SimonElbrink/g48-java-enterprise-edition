package se.lexicon.lecturejpa.dao;

import se.lexicon.lecturejpa.entity.Course;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CourseDao {

    List<Course> findCoursesByInstructorId(Long instructorId);

    Course persist(Course course);

    Optional<Course> findById(Long id);

    Collection<Course> findAll();

    void update(Course course);

    void remove(Long id);

}
