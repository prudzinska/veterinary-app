package pl.veterinary.controller.reception;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.veterinary.model.Customer;
import pl.veterinary.persistence.CustomerDAO;

@Controller
public class ReceptionCustomerController {

	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping("/reception/customer/list")
	public ModelAndView listCustomers() {
		ModelAndView mav = new ModelAndView("customer/list");

		List<Customer> customers = customerDAO.findAll();
		mav.addObject("customers", customers);

		return mav;
	}

	@RequestMapping("/reception/customer/add")
	public ModelAndView addCustomer() {
		ModelAndView mav = new ModelAndView("customer/add");
		return mav;
	}

	@RequestMapping(value = "/reception/customer/added", method = RequestMethod.POST)
	public ModelAndView addedCustomer(
			@ModelAttribute("customer") Customer customer) {
		ModelAndView mav = new ModelAndView("customer/added");
		try {
			customerDAO.save(customer);
		} catch (Exception e) {
			System.out.println("juz jest taka osoba");
		}
		return mav;
	}

	@RequestMapping("/reception/customer/delete/{customerId}")
	public ModelAndView deleteCustomer(
			@PathVariable("customerId") Long customerId) {
		ModelAndView mav = new ModelAndView("customer/delete");
		customerDAO.deleteById(customerId);
		return mav;
	}

	@RequestMapping("/reception/customer/edit/{customerId}")
	public ModelAndView editCustomer(@PathVariable("customerId") Long customerId) {
		ModelAndView mav = new ModelAndView("customer/edit");

		Customer customer = customerDAO.getOne(customerId);
		mav.addObject("customer", customer);

		return mav;
	}

	@RequestMapping(value = "/reception/customer/edited", method = RequestMethod.POST)
	public ModelAndView editedCustomer(
			@ModelAttribute("customer") Customer customer) {
		ModelAndView mav = new ModelAndView("customer/edited");

		customerDAO.save(customer);

		return mav;
	}
}
