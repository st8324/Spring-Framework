package kr.green.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.AccountVo;

public interface AccountDao {
	public String getEmail(String id);
	public String getPw(String id);
	public void setAccount(AccountVo accountVo);
	public AccountVo getAccount(String id);
  public List<AccountVo> getAccounts();
  public void setAuthor(@Param("id")String id, 
      @Param("author")String author);
}
