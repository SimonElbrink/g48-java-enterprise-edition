package se.lexicon.lecturejpa.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import se.lexicon.lecturejpa.entity.Course;

import java.util.List;

public class CourseDaoImpl implements CourseDao{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Course> findCoursesByInstructorId(Long instructorId) {
        return entityManager.createQuery("select c FROM Course c JOIN Instructor i WHERE i.id = :instructorId", Course.class)
                .setParameter("instructorId", instructorId)
                .getResultList();
    }
}
