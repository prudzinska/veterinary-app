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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = VeterinaryApplication.class)
public class AnimalDAOTest {

	@Autowired
	private AnimalDAO animalDAO;

	@Test
	@Transactional
	@Rollback(true)
	public void shouldSaveAnimal() {

		// given
		Animal animal = new Animal();
		animal.setName("burek");
		animal.setAge(4);
		animal.setBreed("german sheperd");

		// when
		animalDAO.save(animal);
		Animal animalFromDB = animalDAO.findById(animal.getId()).get();

		// then
		Assert.assertEquals(animal.getBreed(), animalFromDB.getBreed());
		Assert.assertEquals(animal.getName(), animalFromDB.getName());

	}
}
