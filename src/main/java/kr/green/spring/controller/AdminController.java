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
    
    accountService.setAuthor(request,id,author);
    return "redirect:/admin/cms/user";
  }
  @RequestMapping(value="/cms/board")
  public String cmsBoard(Model model) {
    return "admin/boardManagement";
  }
}
