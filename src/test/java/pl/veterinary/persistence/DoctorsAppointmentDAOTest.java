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
import pl.veterinary.model.Animal;
import pl.veterinary.model.DoctorAppointment;
import pl.veterinary.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = VeterinaryApplication.class)
public class DoctorsAppointmentDAOTest {

	@Autowired
	private DoctorAppointmentDAO doctorsAppointmentDAO;

	@Autowired
	private AnimalDAO animalDAO;

	@Autowired
	private EmployeeDAO employeeDAO;

	@Test
	@Transactional
	@Rollback(true)
	public void shouldSaveDoctorsAppointment() {

		// given
		Animal animal = createTestAnimal();
		Employee doctor = createTestDoctor();
		animalDAO.save(animal);
		employeeDAO.save(doctor);

		DoctorAppointment appointment = new DoctorAppointment();

		// when
		appointment.setAnimal(animal);
		appointment.setEmployee(doctor);
		doctorsAppointmentDAO.save(appointment);

		DoctorAppointment doctorsAppointmentsFromDB = doctorsAppointmentDAO.getOne(appointment.getId());

		// then
		Assert.assertEquals(doctorsAppointmentsFromDB.getAnimal().getName(), animal.getName());
		Assert.assertEquals(doctorsAppointmentsFromDB.getEmployee().getName(), doctor.getName());

	}

	private Employee createTestDoctor() {
		Employee employee = new Employee();
		employee.setName("Test");
		employee.setSurname("Doctor");
		employee.setSalary(new BigDecimal(123));

		return employee;
	}

	private Animal createTestAnimal() {
		Animal animal = new Animal();
		animal.setAge(1);
		animal.setBreed("Persian");
		animal.setType("Cat");
		animal.setName("Kitty");

		return animal;
	}

}
