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
			String checkAdmin = request.getParameter("isAdmin");
			List<User> listUser = new ArrayList<User>();
			listUser = user_BO.getAllUser();
			session.setAttribute("listuser", listUser);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminNV.jsp");
				rd.forward(request, response);
		}
		if(request.getParameter("mod2")!=null) {
			List<Drink> listDrink = new ArrayList<Drink>();
			List<String> listTypeDrink = new ArrayList<String>();
			listTypeDrink = drink_BO.getAllTypeDrink();
			listDrink = drink_BO.getAllDrink();
			session.setAttribute("list_drink", listDrink);
			session.setAttribute("list_type_drink", listTypeDrink);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminMenu.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("add") != null) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddNV.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("update")!=null) {
			String iduserUpdate = request.getParameter("update");
			User userupdate = user_BO.getUser(iduserUpdate);
			session.setAttribute("userupdate", userupdate);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/UpdateNV.jsp");
			rd.forward(request, response);
		}
		Account_BO account_BO = new Account_BO();
		if(request.getParameter("acc") != null) {
			User user = (User) session.getAttribute("user");
			String checkAdmin = request.getParameter("isAdmin");
			int isAdmin = Integer.parseInt(checkAdmin);
			Account acccount = account_BO.getAccountbyID_Account(user.getID_User());
			request.setAttribute("user", user);
			request.setAttribute("account", acccount);
			request.setAttribute("isAdmin", isAdmin);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Account.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("logout") != null) {
			session.invalidate();
			List<Drink> listDrink = drink_BO.getAllDrink();
			List<String> listTypeDrink = drink_BO.getAllTypeDrink();
			request.setAttribute("list_drink", listDrink);
			request.setAttribute("list_type_drink", listTypeDrink);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/NoLogin.jsp");
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
				session.setAttribute("listuser", listUser);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminNV.jsp");
				rd.forward(request, response);
			}
		}
		if(request.getParameter("update1") != null) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String date = request.getParameter("date");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String img = request.getParameter("img");
			if(img == "") {
				User user = (User)session.getAttribute("user");
				img = user.getIMG();
				}
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
			List<User> listUser = new ArrayList<User>();
			listUser = user_BO.getUserbySearch(txtSearch, typeSearch);
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
			String checkAdmin = request.getParameter("isAdmin");
			int isAdmin = Integer.parseInt(checkAdmin);
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
				if(isAdmin == 1) {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminNV.jsp");
					rd.forward(request, response);
				}
				else {
					Drink_BO drink_BO = new Drink_BO();
					List<Drink> listDrink = drink_BO.getAllDrink();
					List<String> listTypeDrink = drink_BO.getAllTypeDrink();
					session.setAttribute("list_drink", listDrink);
					session.setAttribute("list_type_drink", listTypeDrink);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/NV.jsp");
					rd.forward(request, response);
				}
			}
		}
	}
}
