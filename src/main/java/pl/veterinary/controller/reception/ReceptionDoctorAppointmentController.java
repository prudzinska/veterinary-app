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
import pl.veterinary.model.DoctorAppointment;
import pl.veterinary.model.Employee;
import pl.veterinary.persistence.AnimalDAO;
import pl.veterinary.persistence.DoctorAppointmentDAO;
import pl.veterinary.persistence.EmployeeDAO;

@Controller
public class ReceptionDoctorAppointmentController {

	@Autowired
	private AnimalDAO animalDAO;

	@Autowired
	private EmployeeDAO employeeDAO;

	@Autowired
	private DoctorAppointmentDAO doctorAppointmentDAO;

	@RequestMapping("/reception/doctorAppointment/list")
	public ModelAndView listDoctorAppointments() {
		ModelAndView mav = new ModelAndView("doctorAppointment/list");

		List<DoctorAppointment> doctorAppointments = doctorAppointmentDAO
				.findAll();
		mav.addObject("doctorAppointments", doctorAppointments);

		return mav;
	}

	@RequestMapping("/reception/doctorAppointment/add")
	public ModelAndView addDostorAppointments() {
		ModelAndView mav = new ModelAndView("doctorAppointment/add");

		List<Animal> animals = animalDAO.findAll();
		List<Employee> employees = employeeDAO.findAll();
		mav.addObject("animals", animals);
		mav.addObject("employees", employees);

		return mav;
	}

	@RequestMapping(value = "/reception/doctorAppointment/added", method = RequestMethod.POST)
	public ModelAndView addedDoctorAppointment(
			@ModelAttribute("doctorAppointment") DoctorAppointment doctorAppointment) {
		ModelAndView mav = new ModelAndView("doctorAppointment/added");

		doctorAppointmentDAO.save(doctorAppointment);

		return mav;
	}

	@RequestMapping("/reception/doctorAppointment/delete/{doctorAppointmentId}")
	public ModelAndView deletedoctorAppointment(
			@PathVariable("doctorAppointmentId") Long doctorAppointmentId) {
		ModelAndView mav = new ModelAndView("doctorAppointment/delete");
		doctorAppointmentDAO.deleteById(doctorAppointmentId);
		return mav;
	}

	@RequestMapping("/reception/doctorAppointment/edit/{doctorAppointmentId}")
	public ModelAndView editdoctorAppointment(
			@PathVariable("doctorAppointmentId") Long doctorAppointmentId) {
		ModelAndView mav = new ModelAndView("doctorAppointment/edit");

		DoctorAppointment doctorAppointment = doctorAppointmentDAO
				.getOne(doctorAppointmentId);
		List<Employee> employees = employeeDAO.findAll();
		List<Animal> animals = animalDAO.findAll();
		mav.addObject("employees", employees);
		mav.addObject("animals", animals);

		mav.addObject("doctorAppointment", doctorAppointment);

		return mav;
	}

	@RequestMapping(value = "/reception/doctorAppointment/edited", method = RequestMethod.POST)
	public ModelAndView editedDoctorAppointment(
			@ModelAttribute("doctorAppointment") DoctorAppointment doctorAppointment) {
		ModelAndView mav = new ModelAndView("doctorAppointment/edited");

		doctorAppointmentDAO.save(doctorAppointment);

		return mav;
	}
}
