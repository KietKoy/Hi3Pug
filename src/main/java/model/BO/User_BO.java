package model.BO;

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
}
