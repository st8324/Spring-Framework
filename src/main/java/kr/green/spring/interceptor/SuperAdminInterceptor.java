package kr.green.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.spring.vo.AccountVo;

public class SuperAdminInterceptor extends HandlerInterceptorAdapter {

  public boolean preHandle(
      HttpServletRequest request, 
      HttpServletResponse response, 
      Object handler)
      throws Exception {
    HttpSession session = request.getSession();
    AccountVo user 
      = (AccountVo)session.getAttribute("user");
    if(user == null || !user.getAuthor().equals("super admin")) {
      response.sendRedirect(request.getContextPath());
      //return이 false이면 컨트롤러를 방문하지 않는다.
      return false;
    }
    return true;
  }
}
