package kr.green.spring.service;

import java.util.List;

import kr.green.spring.vo.AccountVo;

public interface AccountService {
	public AccountVo signin(AccountVo accountVo);
	public boolean signup(AccountVo accountVo);
  public List<AccountVo> getAccounts();
  public void setAuthor(String id, String author);
}
