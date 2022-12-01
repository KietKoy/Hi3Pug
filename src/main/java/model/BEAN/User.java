package model.BEAN;

import java.sql.Date;

public class User {
	String 	
	ID_User, Name, Email, Phone, IMG;
	Date dateOfBirth;
	
	public User(String iD_User, String name, String email, String phone, String iMG, Date dateOfBirth) {
		super();
		ID_User = iD_User;
		Name = name;
		Email = email;
		Phone = phone;
		IMG = iMG;
		this.dateOfBirth = dateOfBirth;
	}
	public String getID_User() {
		return ID_User;
	}
	public void setID_User(String iD_User) {
		ID_User = iD_User;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getIMG() {
		return IMG;
	}
	public void setIMG(String iMG) {
		IMG = iMG;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	
}
