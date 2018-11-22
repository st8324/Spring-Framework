package kr.green.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.AccountVo;

public interface AccountDao {
	public String getEmail(String id);
	public String getPw(String id);
	public void setAccount(AccountVo accountVo);
	public AccountVo getAccount(String id);
  public List<AccountVo> getAccounts(@Param("cri")Criteria cri, 
      @Param("id")String id);
  public void setAuthor(@Param("id")String id, 
      @Param("author")String author);
  public int getTotalCount(@Param("id")String id);
}
