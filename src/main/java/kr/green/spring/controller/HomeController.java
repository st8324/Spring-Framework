package kr.green.spring.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model
			,Integer num, Integer num2, Integer res) {
		model.addAttribute("num", num);
		model.addAttribute("num2", num2);
		model.addAttribute("res", res);
		return "home";
	}
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String testGet(Model model) {
		model.addAttribute("company","그린");
		return "test/test";
	}
	@RequestMapping(value="/test", method=RequestMethod.POST)
	public String testPost(Model model,
			Integer num, Integer num2) {
		System.out.println("숫자1 : " + num);
		System.out.println("숫자1 : " + num2);
		if(num == null) num = 0;
		if(num2 == null) num2 = 0;
		Integer res = num + num2;
		model.addAttribute("num", num);
		model.addAttribute("num2", num2);
		model.addAttribute("res", res);
		return "redirect:/";
	}
}












