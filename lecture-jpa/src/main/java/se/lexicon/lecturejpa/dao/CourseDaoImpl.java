package se.lexicon.lecturejpa.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import se.lexicon.lecturejpa.entity.Course;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class CourseDaoImpl implements CourseDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Course> findCoursesByInstructorId(Long instructorId) {
        return entityManager.createQuery("SELECT c FROM Course c JOIN c.instructors i WHERE i.id = :Id", Course.class)
                .setParameter("Id", instructorId)
                .getResultList();
    }

    @Transactional
    @Override
    public Course persist(Course course) {
        entityManager.persist(course);
        return course;
    }

    @Override
    public Optional<Course> findById(Long id) {
        Course course = entityManager.find(Course.class, id);
        return Optional.ofNullable(course);
    }

    @Override
    public Collection<Course> findAll() {
        return entityManager.createQuery("SELECT c FROM Course c", Course.class)
                .getResultList();
    }

    @Transactional
    @Override
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Transactional
    @Override
    public void remove(Long id) {
        Course course = entityManager.find(Course.class, id);
        if (course != null) {
            entityManager.remove(course);
        }
    }
}
