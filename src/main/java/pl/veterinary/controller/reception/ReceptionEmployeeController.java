package pl.veterinary.controller.reception;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.veterinary.model.Employee;
import pl.veterinary.persistence.EmployeeDAO;

@Controller
public class ReceptionEmployeeController {

	@Autowired
	private EmployeeDAO employeeDAO;

	@RequestMapping("/reception/employee/list")
	public ModelAndView listEmployees() {
		ModelAndView mav = new ModelAndView("employee/list");

		List<Employee> employees = employeeDAO.findAll();
		mav.addObject("employees", employees);

		return mav;
	}

	@RequestMapping("/reception/employee/add")
	public ModelAndView addEmployee() {
		ModelAndView mav = new ModelAndView("employee/add");
		return mav;
	}

	@RequestMapping(value = "/reception/employee/added", method = RequestMethod.POST)
	public ModelAndView addedEmployee(
			@ModelAttribute("employee") Employee employee) {
		ModelAndView mav = new ModelAndView("employee/added");

		employeeDAO.save(employee);

		return mav;
	}

	@RequestMapping("/reception/employee/delete/{employeeId}")
	public ModelAndView deleteEmployee(
			@PathVariable("employeeId") Long employeeId) {
		ModelAndView mav = new ModelAndView("employee/delete");
		employeeDAO.deleteById(employeeId);
		return mav;
	}

	@RequestMapping("/reception/employee/edit/{employeeId}")
	public ModelAndView editEmployee(@PathVariable("employeeId") Long employeeId) {
		ModelAndView mav = new ModelAndView("employee/edit");

		Employee employee = employeeDAO.getOne(employeeId);
		mav.addObject("employee", employee);

		return mav;
	}

	@RequestMapping(value = "/reception/employee/edited", method = RequestMethod.POST)
	public ModelAndView editedEmployee(
			@ModelAttribute("employee") Employee employee) {
		ModelAndView mav = new ModelAndView("employee/edited");

		employeeDAO.save(employee);

		return mav;
	}

}
