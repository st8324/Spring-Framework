package kr.green.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.spring.service.AccountService;
import kr.green.spring.vo.AccountVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeGet() {
		return "member/signin";
	}
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homePost(AccountVo accountVo, Model model) {
		AccountVo user = accountService.signin(accountVo);
		
		if(user == null)
			return "redirect:/";
		model.addAttribute("user", user);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public String signupGet() {
		return "member/signup";
	}
	/*
	 * 매개변수를 AccountVo 객체를 이용하면 jsp에서 name이 id에 해당하는 정보가
	 * AccountVo의 멤버변수 id에 저장이 된다.
	 * */
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public String signupPost(AccountVo accountVo) {
		if(accountService.signup(accountVo))
			return "redirect:/";
		return "redirect:/signup";
	}
	
	@RequestMapping(value="/signout")
	public String signout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return "redirect:/";
	}
}












