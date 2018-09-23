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
import pl.veterinary.model.Employee;
import pl.veterinary.persistence.AnimalDAO;
import pl.veterinary.persistence.CustomerDAO;
import pl.veterinary.persistence.EmployeeDAO;

@Controller
public class ReceptionController {

	@RequestMapping("/reception")
	public ModelAndView reception() {
		ModelAndView mav = new ModelAndView("reception");
		return mav;
	}

}
