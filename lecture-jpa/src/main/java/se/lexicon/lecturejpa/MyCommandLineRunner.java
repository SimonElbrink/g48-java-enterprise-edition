package se.lexicon.lecturejpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.lecturejpa.dao.AddressDao;
import se.lexicon.lecturejpa.dao.StudentDao;
import se.lexicon.lecturejpa.entity.Address;
import se.lexicon.lecturejpa.entity.Course;
import se.lexicon.lecturejpa.entity.Student;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    StudentDao studentDao;

    @Autowired
    AddressDao addressDao;
    @Override
    public void run(String... args) throws Exception {

        Course javaDev = new Course("JAVA system developer");
        Course python = new Course("Python Course");
        Course sec = new Course("Security Course");

        Address address = new Address("SomeStreet1","SomeCity", "123456");

        Student student = new Student("test", "Testsson","Test@Test.te");

        student.setAddress(address);
        student.addCourse(javaDev);
        student.addCourse(python);
        student.addCourse(sec);

        studentDao.persist(student);

        studentDao.findAll().forEach(System.out::println);

    }
}
