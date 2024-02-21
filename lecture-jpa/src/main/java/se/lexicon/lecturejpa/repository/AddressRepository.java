package se.lexicon.lecturejpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.lexicon.lecturejpa.entity.Address;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address,Long> {
    // Method query to find addresses by city
    List<Address> findByCity(String city);

    // Method query to find addresses by zip code
    List<Address> findByZipCode(String zipCode);

    // JPQL query to find addresses by street
    @Query("SELECT a FROM Address a WHERE a.street = :street")
    List<Address> findAddressesByStreet(@Param("street") String street);

    // JPQL query to find addresses by city and zip code
    @Query("SELECT a FROM Address a WHERE a.city = :city AND a.zipCode = :zipCode")
    List<Address> findAddressesByCityAndZipCode(@Param("city") String city, @Param("zipCode") String zipCode);

    // JPQL query to find addresses associated with a student by student id
    @Query("SELECT a FROM Address a WHERE a.student.id = :studentId")
    Address findAddressByStudentId(@Param("studentId") Long studentId);
}
