package model.BEAN;

public class Account {
	String ID_Account, Username, Password;
	Boolean isAdmin;
	
	public Account(String ID_Account, String username, String password, Boolean isAdmin) {
		super();
		this.ID_Account = ID_Account;
		Username = username;
		Password = password;
		this.isAdmin = isAdmin;
	}
	public String getID_Account() {
		return ID_Account;
	}
	public void setID_Account(String ID_Account) {
		this.ID_Account = ID_Account;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}
