package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BEAN.Account;
import model.BEAN.User;
import model.BO.Account_BO;
import model.BO.Drink_BO;
import model.BO.User_BO;
import model.BEAN.*;
@WebServlet("/CheckLoginServlet")
public class CheckLoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String destination = "";
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		Account_BO account_BO = new Account_BO();
		User_BO user_BO = new User_BO();
		Account acc = account_BO.isValidAccount(userName, password);
		Drink_BO drink_bo = new Drink_BO();
		if(acc != null) {
			User user = user_BO.getUser(acc.getID_Account());
			List<Drink> listDrink = new ArrayList<Drink>();
			List<String> listTypeDrink = new ArrayList<String>();
			listDrink = drink_bo.getAllDrink();
			listTypeDrink = drink_bo.getAllTypeDrink();
			if(acc.getIsAdmin()) {
				HttpSession session = req.getSession();
				session.setAttribute("user", user);
				session.setAttribute("role", "admin");
				session.setAttribute("list_drink", listDrink);
				session.setAttribute("list_type_drink", listTypeDrink);
				destination = "/AdminMenu.jsp";
				RequestDispatcher rd = req.getRequestDispatcher(destination);
				rd.forward(req, resp);
				}
			else {
				HttpSession session = req.getSession();
				session.setAttribute("user", user);
				session.setAttribute("role", "nhanvien");
				session.setAttribute("list_drink", listDrink);
				session.setAttribute("list_type_drink", listTypeDrink);
				destination = "/NV.jsp";
				RequestDispatcher rd = req.getRequestDispatcher(destination);
				rd.forward(req, resp);
			}
		}
		else {
			destination = "/NoLogin.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(destination);
			rd.forward(req, resp);
		}
	}
}
