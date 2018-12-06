package kr.green.spring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.green.spring.service.AccountService;
import kr.green.spring.vo.AccountVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeGet(Integer loginOk,Integer signup, Model model) {
		if(loginOk == null)
			loginOk = -1;
		if(signup == null)
			signup = -1;
		model.addAttribute("signup", signup);
		model.addAttribute("loginOk", loginOk);
		return "member/signin";
	}
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homePost(AccountVo accountVo, Model model) {
		AccountVo user = accountService.signin(accountVo);
		
		if(user == null) {
			model.addAttribute("loginOk", 0);
			return "redirect:/";
		}
		model.addAttribute("user", user);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public String signupGet(Model model, Integer signup) {
		if(signup == null) {
			signup = -1;
		}
		model.addAttribute("signup", signup);
		return "member/signup";
	}
	/*
	 * 매개변수를 AccountVo 객체를 이용하면 jsp에서 name이 id에 해당하는 정보가
	 * AccountVo의 멤버변수 id에 저장이 된다.
	 * */
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public String signupPost(AccountVo accountVo, Model model) {
		if(accountService.signup(accountVo)) {
			model.addAttribute("signup", 1);
			return "redirect:/";
		}
		model.addAttribute("signup", 0);
		return "redirect:/signup";
	}
	
	@RequestMapping(value="/signout")
	public String signout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return "redirect:/";
	}
	@RequestMapping(value ="/dup")
	@ResponseBody
	public Map<Object, Object> idcheck(@RequestBody String id){
	    Map<Object, Object> map = new HashMap<Object, Object>();
	    //서비스를 이용하여 주어진 id에 대한 회원  정보를 가져온다.
	    //가져온 정보가 null이면 dup에 false를 null이 아니면 dup에 true를 입력하여 넘겨준다.
	    boolean dup = accountService.isDuplicated(id);
	    map.put("dup", dup);
	    return map;
	}
	@RequestMapping(value="/find/password", method=RequestMethod.GET)
	public String findPasswordGet(Model model, Boolean fail) {
	  if(fail == null)
	    fail = false;
	  model.addAttribute("fail", fail);
	  return "member/findPassword";
	}
	@RequestMapping(value="/find/password", method=RequestMethod.POST)
  public String findPasswordPost(String id, String email, Model model) {
	  //아이디와 email이 일치하는지 확인
	  //일치하지 않으면 redirect로 /로 보냄
	  if(!accountService.checkAccount(id, email)) {
	    model.addAttribute("fail", true);
	    return "redirect:/find/password";
	  }
	  //비밀번호 8자리 영문자와 숫자를 포함하여 랜덤으로 생성
	  //1. 0~61까지 랜덤한 수를 생성
	  //2. 0~9까지는 0~9로
	  //   10~35까지는 A~Z
	  //   36~61까지는 a~z
	  //3. pw에 위에서 구한 문자를 추가한다.
	  //4. 1~3과정을 8번 반복한다.
	  String pw="";
	  for(int i = 0; i<8; i++) {
	    int ran = (int)(Math.random()*62);
	    if(ran <10) {
	      pw += ran;
	    }else if(ran <36) {
	      pw += (char)(65 + ran - 10);
	    }else {
	      pw += (char)(97 + ran - 35);
	    }
	  }
	  accountService.updatePw(id, pw);
	  String setfrom = "stajun@gmail.com";
    String tomail  = email;     // 받는 사람 이메일
    String title   = "비밀번호 찾기";      // 제목
    String content = "임시 발급 비밀번호는 "+pw+" 입니다.";    // 내용
    //비밀번호 변경
    
    try {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper 
            = new MimeMessageHelper(message, true, "UTF-8");

        messageHelper.setFrom(setfrom);  // 
        messageHelper.setTo(tomail);     // 받는사람 이메일
        messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
        messageHelper.setText(content);  // 메일 내용

        mailSender.send(message);
    } catch(Exception e){
        System.out.println(e);
    }
    
    return "redirect:/";
  }
}












