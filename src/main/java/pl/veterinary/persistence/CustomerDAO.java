package pl.veterinary.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.veterinary.model.Customer;

@Transactional
@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long> {

}
