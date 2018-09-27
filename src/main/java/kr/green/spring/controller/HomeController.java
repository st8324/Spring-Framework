package kr.green.spring.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.spring.dao.AccountDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private AccountDao accountDao;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeGet() {
		return "member/signin";
	}
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homePost(String id,String pw) {
		String dbPw = accountDao.getPw(id);
		if(dbPw.compareTo(pw) != 0)
			return "redirect:/";
		return "redirect:/test";
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
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public String signupGet() {
		return "member/signup";
	}
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public String signupPost(String id, String pw, 
		String pwConfirm, String gender, String email) {
		String emails = accountDao.getEmail(id);
		if(emails != null)
			return "redirect:/signup";
		accountDao.setAccount(id, pw, email, gender);
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		System.out.println("pwConfirm : " + pwConfirm);
		System.out.println("gender : " + gender);
		System.out.println("email : " + email);
		return "redirect:/";
	}
	@RequestMapping(value="/signin", method=RequestMethod.GET)
	public String signinGet() {
		return "member/signin";
	}
	@RequestMapping(value="/signin", method=RequestMethod.POST)
	public String signinPost(String id, String pw) {
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		return "redirect:/signin";
	}
}












