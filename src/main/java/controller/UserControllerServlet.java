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

import model.BEAN.*;
import model.BO.*;
@WebServlet("/UserControllerServlet")
public class UserControllerServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User_BO user_BO = new User_BO();
		if(request.getParameter("mod1")!=null) {
			String iduser = request.getParameter("iduser");
			String role = request.getParameter("Role");
			User user = user_BO.getUser(iduser);
			List<User> listUser = new ArrayList<User>();
			listUser = user_BO.getAllUser();
			HttpSession session = request.getSession();
			session.invalidate();
			session.setAttribute("user", user);
			session.setAttribute("role", role);
			request.setAttribute("listuser", listUser);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminNV.jsp");
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
