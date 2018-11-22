package kr.green.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.green.spring.vo.AccountVo;

public interface AccountService {
	public AccountVo signin(AccountVo accountVo);
	public boolean signup(AccountVo accountVo);
  public List<AccountVo> getAccounts();
  public void setAuthor(HttpServletRequest request,String id, String author);
}
