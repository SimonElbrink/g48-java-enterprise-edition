package se.lexicon.lecturejpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.lecturejpa.entity.Instructor;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor,Long> {
    //Todo: Implement more methods using method queries or JPQL
}
