package kr.green.spring.dao;

import org.apache.ibatis.annotations.Param;

public interface AccountDao {
	public String getEmail(String id);
	public String getPw(String id);
	public void setAccount(@Param("id")String id, 
			@Param("pw")String pw,@Param("email")String email,
			@Param("gender")String gender );
}
