package kr.green.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.green.spring.service.AccountService;
import kr.green.spring.vo.AccountVo;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
  
  @Autowired
  private AccountService accountService;
  
 
  @RequestMapping(value="/cms/user")
  public String cmsUser(Model model) {
    List<AccountVo> list = accountService.getAccounts();
    model.addAttribute("list", list);
    return "admin/userManagement";
  }
  @RequestMapping(value="/cms/user/modify")
  public String cmsUserModify(HttpServletRequest request, Model model,String author, String id) {
    HttpSession session = request.getSession();
    AccountVo loginUser = (AccountVo) 
          session.getAttribute("user");
    //로그인한 아이디와 수정하려는 아이디가 같으면
    //세션에 있는 user 정보를 지우고 새로운 user 정보로 설정한다.
    if(loginUser.getId().equals(id)) {
      session.removeAttribute("user");
      loginUser.setAuthor(author);
      session.setAttribute("user", loginUser);
    }
    accountService.setAuthor(id,author);
    return "redirect:/admin/cms/user";
  }
}
