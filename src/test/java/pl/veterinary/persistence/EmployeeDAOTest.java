package pl.veterinary.persistence;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.veterinary.VeterinaryApplication;
import pl.veterinary.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = VeterinaryApplication.class)
public class EmployeeDAOTest {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Test
	@Transactional
	@Rollback(true)
	public void shouldSaveEmployee() {

		// given
		Employee employee = new Employee();
		employee.setName("Eric");
		employee.setSurname("Cartman");
		employee.setSalary(new BigDecimal(2000));

		// when
		employeeDAO.save(employee);
		Employee employeeFromDB = employeeDAO.findById(employee.getId()).get();

		// then
		Assert.assertEquals(employee.getName(), employeeFromDB.getName());
		Assert.assertEquals(employee.getSurname(), employeeFromDB.getSurname());
	}

}