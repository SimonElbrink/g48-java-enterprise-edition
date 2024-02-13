package se.lexicon.lecturejpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.lecturejpa.dao.StudentDao;
import se.lexicon.lecturejpa.entity.Student;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    StudentDao studentDao;
    @Override
    public void run(String... args) throws Exception {

        Student student = new Student("test", "Testsson","Test@Test.te");

        studentDao.persist(student);


    }
}
