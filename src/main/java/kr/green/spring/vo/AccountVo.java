package kr.green.spring.vo;

public class AccountVo {
	private String id;
	private String pw;
	private String email;
	private String gender;
	private String author;
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public String getEmail() {
		return email;
	}
	public String getGender() {
		return gender;
	}
	public String getAuthor() {
		return author;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "AccountVo [id=" + id + ", pw=" + pw + ", email=" + email + ", gender=" + gender + ", author=" + author
				+ "]";
	}
}
