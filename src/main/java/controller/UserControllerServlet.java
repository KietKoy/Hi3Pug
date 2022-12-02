package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		HttpSession session = request.getSession();
		User_BO user_BO = new User_BO();
		Drink_BO drink_BO = new Drink_BO();
		if(request.getParameter("mod1")!=null) {
//			String iduser = request.getParameter("iduser");
//			String role = request.getParameter("Role");
//			User user = user_BO.getUser(iduser);
			List<User> listUser = new ArrayList<User>();
			listUser = user_BO.getAllUser();
//			session.setAttribute("user", user);
//			session.setAttribute("role", role);
			session.setAttribute("listuser", listUser);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminNV.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("mod2")!=null) {
//			String iduser = request.getParameter("iduser");
//			String role = request.getParameter("Role");
//			User user = user_BO.getUser(iduser);
			List<Drink> listDrink = new ArrayList<Drink>();
			List<String> listTypeDrink = new ArrayList<String>();
			listTypeDrink = drink_BO.getAllTypeDrink();
			listDrink = drink_BO.getAllDrink();
//			session.setAttribute("user", user);
//			session.setAttribute("role", role);
			session.setAttribute("list_drink", listDrink);
			session.setAttribute("list_type_drink", listTypeDrink);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminMenu.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("add") != null) {
//			String iduser = request.getParameter("iduser");
//			String role = request.getParameter("Role");
//			User user = user_BO.getUser(iduser);
//			session.setAttribute("user", user);
//			session.setAttribute("role", role);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddNV.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("update")!=null) {
			String iduserUpdate = request.getParameter("update");
//			String iduser = request.getParameter("iduser");
//			String role = request.getParameter("Role");
			User userupdate = user_BO.getUser(iduserUpdate);
//			User user = user_BO.getUser(iduser);
//			session.setAttribute("user", user);
//			session.setAttribute("role", role);
			session.setAttribute("userupdate", userupdate);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/UpdateNV.jsp");
			rd.forward(request, response);
		}
		Account_BO account_BO = new Account_BO();
		if(request.getParameter("acc") != null) {
			User user = (User) session.getAttribute("user");
			Account acccount = account_BO.getAccountbyID_Account(user.getID_User());
			request.setAttribute("user", user);
			request.setAttribute("account", acccount);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Account.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User_BO user_BO = new User_BO();
		Account_BO account_BO = new Account_BO();
		if(request.getParameter("add") != null) {
			System.out.println("addd");
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String date = request.getParameter("day");
			String email = request.getParameter("email");
			String img = request.getParameter("img");
//			String iduser = request.getParameter("iduser");
//			String role = request.getParameter("role");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date date1 = null;
			try {
				date1 = sdf.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date sqlDate = new Date(date1.getTime());
			if(user_BO.checkAdd(id, name,sqlDate, email, phone, img)) {
				boolean a = account_BO.checkAdd(id, id, id, 0);
				List<User> listUser = new ArrayList<User>();
				listUser = user_BO.getAllUser();
//				User user = user_BO.getUser(iduser);
//				session.setAttribute("user", user);
//				session.setAttribute("role", role);
				session.setAttribute("listuser", listUser);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminNV.jsp");
				rd.forward(request, response);
			}
		}
		if(request.getParameter("update1") != null) {
			System.out.println("hihi");
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String date = request.getParameter("date");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String img = request.getParameter("img");
//			String iduser =request.getParameter("iduser");
//			String role = request.getParameter("role");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date date1 = null;
			try {
				date1 = sdf.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date sqlDate = new Date(date1.getTime());
			if(user_BO.checkUpdate(id, name, sqlDate, email, phone, img)) {
				List<User> listUser = new ArrayList<User>();
				listUser = user_BO.getAllUser();
//				User user = user_BO.getUser(iduser);
//				session.setAttribute("user", user);
//				session.setAttribute("role", role);
				session.setAttribute("listuser", listUser);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminNV.jsp");
				rd.forward(request, response);
			}
		}
		if(request.getParameter("search") != null) {
			String txtSearch = request.getParameter("txt_search");
			System.out.println(txtSearch);
			String typeSearch = request.getParameter("typeSearch");
			System.out.println(typeSearch);
//			String iduser = request.getParameter("iduser");
//			String role = request.getParameter("role");
//			User user = user_BO.getUser(iduser);
			List<User> listUser = new ArrayList<User>();
			listUser = user_BO.getUserbySearch(txtSearch, typeSearch);
//			session.setAttribute("user", user);
//			session.setAttribute("role", role);
			session.setAttribute("listuser", listUser);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminNV.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("save") != null) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String date = request.getParameter("date");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String img = request.getParameter("img");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date date1 = null;
			try {
				date1 = sdf.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date sqlDate = new Date(date1.getTime());
			if(user_BO.checkUpdate(id, name, sqlDate, email, phone, img) && account_BO.checkUpdate(username, password)) {
				List<User> listUser = new ArrayList<User>();
				listUser = user_BO.getAllUser();
				User user = user_BO.getUser(id);
				session.setAttribute("user", user);
				session.setAttribute("listuser", listUser);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminNV.jsp");
				rd.forward(request, response);
			}
		}
	}
}
