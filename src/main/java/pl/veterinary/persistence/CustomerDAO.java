package pl.veterinary.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.veterinary.model.Customer;

@Transactional
public interface CustomerDAO extends JpaRepository<Customer, Long> {

}
