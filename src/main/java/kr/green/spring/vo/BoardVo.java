package kr.green.spring.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardVo {
	private int num;
	private String title;
	private String contents;
	private String author;
	private String file;
	private Date register_date;

	public int getNum() {
		return num;
	}


	public String getTitle() {
		return title;
	}


	public String getContents() {
		return contents;
	}


	public String getAuthor() {
		return author;
	}


	public String getFile() {
		return file;
		
	}
	public String getOriFile() {
		if(file == null)
			return "";
		return file.substring(file.indexOf('_')+1);
	}

	public String getRegister_date() {
		SimpleDateFormat format 
			= new SimpleDateFormat("yyyy-MM-dd");
		return format.format(register_date);
	}

	public void setNum(int num) {
		this.num = num;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public void setFile(String file) {
		this.file = file;
	}


	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}


	@Override
	public String toString() {
		return "BoardVo [num=" + num + ", title=" + title + ", contents=" + contents + ", author=" + author + ", file="
				+ file + ", register_date=" + register_date + "]";
	}
}
