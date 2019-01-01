package pl.veterinary.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.veterinary.model.Employee;

@Transactional
@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Long> {

}
