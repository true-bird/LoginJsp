package login.model;

import java.sql.Date;

public class LoginDTO {
	private String id;
	private String password;
	private String name;
	private int gender;
	private Date birth;
	public LoginDTO() {}
	public LoginDTO(String id, String password, String name, int gender, Date birth) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "LoginDTO [id=" + id + ", password=" + password + ", name=" + name + ", gender=" + gender + ", birth="
				+ birth + "]";
	}
	
}
