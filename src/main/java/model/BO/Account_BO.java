package model.BO;
import model.BEAN.Account;
import model.DAO.*;
public class Account_BO {
	public Account isValidAccount(String username, String password) {
		return new Account_DAO().getAccount(username, password);
	}
	public boolean isValid(String id_account ) {
		return new Account_DAO().isValid(id_account);
	}
	public boolean checkAdd(String id_account,String userName,String password, int isAdmin ) {
		Account_DAO account_DAO = new Account_DAO();
		if(isValid(id_account) == false) {
			account_DAO.AddAccount(id_account, userName, password, isAdmin);;
			return true;
		}
		return false;
	}
	public boolean checkUpdate(String userName,String password) {
		Account_DAO account_DAO = new Account_DAO();
		if(isValid(userName) == true) {
			account_DAO.updateAcccount(password, userName, password, 0);;
			return true;
		}
		return false;
	}
	public Account getAccountbyID_Account(String id_account) {
		System.out.println("BO");
		return new Account_DAO().getAccountbyID_Account(id_account);
	}
}
