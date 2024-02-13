package se.lexicon.lecturejpa.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import se.lexicon.lecturejpa.entity.Student;

import java.util.Collection;
import java.util.Optional;

@Repository
public class StudentDaoImpl implements StudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Student persist(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    public Optional<Student> findById(String id) {
        Student student = entityManager.find(Student.class, id);
        return Optional.ofNullable(student);
    }

    @Override
    public Optional<Student> findByEmail(String email) {

        return entityManager.createQuery("SELECT s FROM Student s WHERE s.email = :em", Student.class)
                .setParameter("em", email)
                .getResultList()
                .stream()
                .findFirst();
    }

    @Override
    public Collection<Student> findByFirstNameContains(String firstName) {
        return null; // TODO - Implement this method...
    }

    @Override
    public Collection<Student> findAll() {
        return entityManager.createQuery("select s from Student s", Student.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void remove(Student student) {
        entityManager.remove(student);
    }
}
