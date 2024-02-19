package se.lexicon.lecturejpa.dao;

import se.lexicon.lecturejpa.entity.Course;

import java.util.List;

public interface CourseDao {

    List<Course> findCoursesByInstructorId(Long instructorId);

}
