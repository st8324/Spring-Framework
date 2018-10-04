package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.AccountDao;

@Service
public class AccountServiceImp implements AccountService{
	@Autowired
	AccountDao accountDao;
	
	@Override
	public boolean signin(String id, String pw) {
		String dbPw = accountDao.getPw(id);
		if(dbPw == null || dbPw.compareTo(pw) != 0)
			return false;
		return true;
	}

	@Override
	public boolean signup(String id, String pw, String email, String gender) {
		//DB에서 email값에 null값 허용하지 않은 경우만 사용 가능
		String emails = accountDao.getEmail(id);
		if(emails != null)
			return false;
		accountDao.setAccount(id, pw, email, gender);
		return true;
	}
}






