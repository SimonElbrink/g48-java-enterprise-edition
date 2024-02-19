package se.lexicon.lecturejpa.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import se.lexicon.lecturejpa.entity.Address;

import java.util.Collection;
import java.util.Optional;

@Component
public class AddressDaoImpl implements AddressDao {


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
        Address address = entityManager.find(Address.class, id);
        return Optional.ofNullable(address);
    }

    @Override
    public Collection<Address> findAll() {
        return entityManager.createQuery("SELECT a FROM Address a", Address.class)
                .getResultList();
    }

    @Transactional
    @Override
    public void update(Address address) {
        entityManager.merge(address);
    }

    @Transactional
    @Override
    public void remove(Long id) {
        Address address = entityManager.find(Address.class, id);
        if (address != null) {
            entityManager.remove(address);
        }

    }
}
