package pl.veterinary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomepageController {

	@RequestMapping("/")
	public ModelAndView homepage() {
		ModelAndView mav = new ModelAndView("homepage");
		return mav;
	}

}
