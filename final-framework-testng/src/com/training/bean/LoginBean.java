package com.training.bean;

public class LoginBean {
	private String your_name;
	private String your_mail;
	private String your_subject;
	private String your_message;

	public LoginBean() {
	}

	public LoginBean(String your_name, String your_mail, String your_subject, String your_message) {
		super();
		this.your_name = your_name;
		this.your_mail = your_mail;
		this.your_subject = your_subject;
		this.your_message = your_message;
	}

	public String getUserName() {
		return your_name;
	}

	public void setUserName(String your_name) {
		this.your_name = your_name;
	}

	public String getMail() {
		return your_mail;
	}

	public void setMail(String your_mail) {
		this.your_mail = your_mail;
	}
	
	public String getSubject() {
		return your_subject;
	}

	public void setSubject(String your_subject) {
		this.your_subject = your_subject;
	}
	
	public String getMessage() {
		return your_message;
	}

	public void setMessage(String your_message) {
		this.your_message = your_message;
	}
	
	@Override
	public String toString() {
		return "LoginBean [userName=" + your_name + ", email=" + your_mail + ", Subject=" + your_subject + ", Message=" + your_message + "]";
	}

}
