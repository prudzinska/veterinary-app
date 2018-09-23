package pl.veterinary.controller.reception;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.veterinary.model.Animal;
import pl.veterinary.model.Customer;
import pl.veterinary.persistence.AnimalDAO;
import pl.veterinary.persistence.CustomerDAO;

@Controller
public class ReceptionAnimalController {

	@Autowired
	private AnimalDAO animalDAO;

	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping("/reception/animal/list")
	public ModelAndView listAnimals() {
		ModelAndView mav = new ModelAndView("animal/list");

		List<Animal> animals = animalDAO.findAll();
		mav.addObject("animals", animals);

		return mav;
	}

	@RequestMapping("/reception/animal/add")
	public ModelAndView addAnimal() {
		ModelAndView mav = new ModelAndView("animal/add");
		List<Customer> customers = customerDAO.findAll();
		mav.addObject("customers", customers);
		return mav;
	}

	@RequestMapping(value = "/reception/animal/added", method = RequestMethod.POST)
	public ModelAndView addedAnimal(@ModelAttribute("animal") Animal animal) {
		ModelAndView mav = new ModelAndView("animal/added");
		try {
			animalDAO.save(animal);
		} catch (Exception e) {
			System.out.println("juz jest taka osoba");
		}
		return mav;
	}

	@RequestMapping("/reception/animal/delete/{animalId}")
	public ModelAndView deleteAnimal(@PathVariable("animalId") Long animalId) {
		ModelAndView mav = new ModelAndView("animal/delete");
		animalDAO.deleteById(animalId);
		return mav;
	}

	@RequestMapping("/reception/animal/edit/{animalId}")
	public ModelAndView editAnimal(@PathVariable("animalId") Long animalId) {
		ModelAndView mav = new ModelAndView("animal/edit");

		Animal animal = animalDAO.getOne(animalId);

		List<Customer> customers = customerDAO.findAll();

		mav.addObject("animal", animal);
		mav.addObject("customer", customers);

		return mav;
	}

	@RequestMapping(value = "/reception/animal/edited", method = RequestMethod.POST)
	public ModelAndView editedAnimal(@ModelAttribute("animal") Animal animal) {
		ModelAndView mav = new ModelAndView("animal/edited");

		animalDAO.save(animal);

		return mav;
	}
}
