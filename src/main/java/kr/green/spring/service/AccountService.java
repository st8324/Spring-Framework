package kr.green.spring.service;

public interface AccountService {
	public boolean signin(String id, String pw);
	public boolean signup(String id, String pw,
			String email, String gender);
}
