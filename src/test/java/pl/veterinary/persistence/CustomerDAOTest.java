package pl.veterinary.persistence;

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
import pl.veterinary.model.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = VeterinaryApplication.class)
public class CustomerDAOTest {

	@Autowired
	private CustomerDAO customerDAO;

	@Test
	@Transactional
	@Rollback(true)
	public void shouldSaveCustomer() {
		// given
		Customer user = new Customer();
		user.setName("Kubus");
		user.setSurname("Puchatek");

		// when
		customerDAO.save(user);
		Customer userFromDatabase = customerDAO.findById(user.getId()).get();

		// then
		Assert.assertEquals(user.getName(), userFromDatabase.getName());
		Assert.assertEquals(user.getSurname(), userFromDatabase.getSurname());

	}

	@Test
	@Transactional
	@Rollback(true)
	public void shouldSaveCustomerWithAnimals() {
		Customer user = new Customer();
		user.setName("Kubus");
		user.setSurname("Puchatek");

		Animal reksio = new Animal();
		reksio.setAge(1);
		reksio.setBreed("German Shepherd");
		reksio.setName("Reksio");
		reksio.setType("Dog");

		Animal azor = new Animal();
		azor.setAge(1);
		azor.setBreed("German Shepherd");
		azor.setName("Azor");
		azor.setType("Dog");

		user.getAnimals().add(reksio);
		user.getAnimals().add(azor);
		reksio.setOwner(user);
		azor.setOwner(user);

		// when
		customerDAO.save(user);
		Customer customerFromDB = customerDAO.findById(user.getId()).get();

		// then
		Assert.assertEquals(2, customerFromDB.getAnimals().size());
	}

}
