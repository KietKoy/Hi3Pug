package model.BO;


import java.sql.Date;
import java.util.List;

import model.BEAN.User;
import model.DAO.User_DAO;

public class User_BO {
	public User getUser(String mauser) {
		return new User_DAO().getUser(mauser);
	}
	public List<User> getAllUser() {
		return new User_DAO().getAllUser();
	}
	public boolean isValid(String mauser) {
		return new User_DAO().isValid(mauser);
	}
	public List<User> getUserbySearch(String txtSearch, String typeSearch) {
		System.out.println("search_BO");
		return new User_DAO().getUserbySearch(txtSearch, typeSearch);
	}
	public boolean checkAdd(String MaUser, String HoTen, Date NgaySinh, String Email, String SDT, String img) {
		User_DAO user_DAO = new User_DAO();
		if(user_DAO.isValid(MaUser) == false) {
			user_DAO.addUser(MaUser, HoTen, NgaySinh, Email, SDT, img);
			return true;
		}
		return false;
	}
	public boolean checkUpdate(String MaUser, String HoTen, Date NgaySinh, String Email, String SDT, String img) {
		User_DAO user_DAO = new User_DAO();
		if(user_DAO.isValid(MaUser) == true) {
			user_DAO.updateUser(MaUser, HoTen, NgaySinh, Email, SDT, img);;
			return true;
		}
		return false;
	}
}
