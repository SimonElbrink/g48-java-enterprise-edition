package se.lexicon.lecturejpa.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import se.lexicon.lecturejpa.entity.Address;

import java.util.Collection;
import java.util.Optional;

@Component
public class AddressDaoImpl implements AddressDao{

    // todo: implement crud operations of the address dao interface

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public Address persist(Address address) {
        entityManager.persist(address);
        return address;
    }

    @Override
    public Optional<Address> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Collection<Address> findAll() {
        return null;
    }

    @Override
    public void update(Address address) {

    }

    @Override
    public void remove(Long id) {

    }
}
