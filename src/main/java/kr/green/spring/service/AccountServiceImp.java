package kr.green.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.AccountDao;
import kr.green.spring.pagination.Criteria;
import kr.green.spring.pagination.PageMaker;
import kr.green.spring.vo.AccountVo;

@Service
public class AccountServiceImp implements AccountService{
	@Autowired
	AccountDao accountDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public AccountVo signin(AccountVo accountVo) {
		AccountVo user = accountDao.getAccount(accountVo.getId());
		
		if(user == null || 
			!passwordEncoder.matches(accountVo.getPw(), user.getPw()))
			return null;
		return user;
	}

	@Override
	public boolean signup(AccountVo accountVo) {
		AccountVo user = accountDao.getAccount(accountVo.getId());
		if(user != null)
			return false;
		String encPw = passwordEncoder.encode(accountVo.getPw());
		accountVo.setPw(encPw);
		accountDao.setAccount(accountVo);
		return true;
	}

  @Override
  public List<AccountVo> getAccounts(HttpServletRequest request,Criteria cri) {
    AccountVo loginUser = getLoginUser(request);
    return accountDao.getAccounts(cri,loginUser.getId());
  }

  @Override
  public void setAuthor(HttpServletRequest request,String id, String author) {
    HttpSession session = request.getSession();
    AccountVo loginUser = (AccountVo) 
          session.getAttribute("user");
    //로그인한 아이디와 수정하려는 아이디가 같으면
    //세션에 있는 user 정보를 지우고 새로운 user 정보로 설정한다.
    if(loginUser != null && loginUser.getId().equals(id)) {
      session.removeAttribute("user");
      loginUser.setAuthor(author);
      session.setAttribute("user", loginUser);
    }
    accountDao.setAuthor(id, author);
    
  }

  @Override
  public PageMaker getPageMaker(HttpServletRequest request,Criteria cri,int displayPageNum) {
    AccountVo loginUser = getLoginUser(request);
    int totalCount = accountDao.getTotalCount(loginUser.getId());
    PageMaker pm = new PageMaker();
    pm.setDisplayPageNum(displayPageNum);
    pm.setCriteria(cri);
    pm.setTotalCount(totalCount);
    return pm;
  }

  @Override
  public AccountVo getLoginUser(HttpServletRequest request) {
    HttpSession session = request.getSession();
    AccountVo loginUser = (AccountVo) 
          session.getAttribute("user");
    return loginUser;
  }
}






