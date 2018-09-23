package pl.veterinary.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.veterinary.model.Employee;

@Transactional
public interface EmployeeDAO extends JpaRepository<Employee, Long> {

}
