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

import model.BEAN.User;
import model.BO.Drink_BO;
import model.BO.User_BO;
@WebServlet("/DrinkControllerServlet")
public class DrinkControllerServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User_BO user_BO = new User_BO();
		if(request.getParameter("mod1")!=null) {
			String iduser = request.getParameter("iduser");
			String role = request.getParameter("Role");
			User user = user_BO.getUser(iduser);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("role", role);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddDrink.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("update")!=null) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/UpdateDrink.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
