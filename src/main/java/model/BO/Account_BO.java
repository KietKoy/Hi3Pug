package model.BO;
import model.BEAN.Account;
import model.DAO.*;
public class Account_BO {
	public Account isValidAccount(String username, String password) {
		return new Account_DAO().getAccount(username, password);
	}
}
