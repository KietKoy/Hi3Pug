package controller;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.BEAN.Drink;
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
		HttpSession session = request.getSession();
		User_BO user_BO = new User_BO();
		Drink_BO drink_BO = new Drink_BO();
		if(request.getParameter("again")!=null) {
			response.sendRedirect("./AdminMenu.jsp");
		}
		if(request.getParameter("mod1")!=null) {
			String checkAdmin = request.getParameter("isAdmin");
			int isAdmin = Integer.parseInt(checkAdmin);
			List<String> listTypeDrink = new ArrayList<String>();
			listTypeDrink = drink_BO.getAllTypeDrink();
			session.setAttribute("listTypeDrink", listTypeDrink);
			request.setAttribute("isAdmin", isAdmin);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddDrink.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("update")!=null) {
			String iddrink = request.getParameter("update");
			Drink drink = drink_BO.getDoUong(iddrink);
			List<String> listTypeDrink = drink_BO.getAllTypeDrink();
			request.setAttribute("isAdmin", 1);
			session.setAttribute("drink", drink);
			session.setAttribute("listTypeDrink", listTypeDrink);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/UpdateDrink.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("update2")!=null) {
			String iddrink = request.getParameter("update2");
			Drink drink = drink_BO.getDoUong(iddrink);
			List<String> listTypeDrink = drink_BO.getAllTypeDrink();
			request.setAttribute("isAdmin", 0);
			session.setAttribute("drink", drink);
			session.setAttribute("listTypeDrink", listTypeDrink);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/UpdateDrink.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("add") != null) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String ingredient = request.getParameter("ingredient");
			String type = request.getParameter("typedrink");
			String price = request.getParameter("price");
			String img = request.getParameter("img");
			String checkAdmin = request.getParameter("isAdmin");
			int isAdmin = Integer.parseInt(checkAdmin);
			System.out.println(isAdmin);
			if(drink_BO.addDrink(id, name, type, ingredient,Double.parseDouble(price), img)) {
				List<Drink> listDrink = new ArrayList<Drink>();
				List<String> listTypeDrink = new ArrayList<String>();
				listDrink = drink_BO.getAllDrink();
				listTypeDrink = drink_BO.getAllTypeDrink();
				session.setAttribute("list_drink", listDrink);
				session.setAttribute("list_type_drink", listTypeDrink);
				if(isAdmin == 1) {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminMenu.jsp");
					rd.forward(request, response);
				}
				else {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/NV.jsp");
					rd.forward(request, response);
				}
			} else {
				request.setAttribute("isAdmin", isAdmin);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddDrink.jsp");
				rd.forward(request, response);
			}
		}
		if(request.getParameter("delete")!=null) {
			String iduser = request.getParameter("iduser");
			String role = request.getParameter("Role");
			User user = user_BO.getUser(iduser);
			drink_BO.delDrink(request.getParameter("delete"));
			List<Drink> list_drink = new ArrayList<Drink>();
			list_drink = drink_BO.getAllDrink();
			session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("role", role);
			session.setAttribute("list_drink", list_drink);
			String checkAdmin = request.getParameter("isAdmin");
			int isAdmin = Integer.parseInt(checkAdmin);
			if(isAdmin == 1 ) {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminMenu.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/NV.jsp");
				rd.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User_BO user_BO = new User_BO();
		Drink_BO drink_BO = new Drink_BO();
		if(request.getParameter("add") != null) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String ingredient = request.getParameter("ingredient");
			String type = request.getParameter("typedrink");
			String price = request.getParameter("price");
			String img = request.getParameter("img");
			if(drink_BO.addDrink(id, name, type, ingredient,Double.parseDouble(price), img)) {
				List<Drink> listDrink = new ArrayList<Drink>();
				List<String> listTypeDrink = new ArrayList<String>();
				listDrink = drink_BO.getAllDrink();
				listTypeDrink = drink_BO.getAllTypeDrink();
				session.setAttribute("list_drink", listDrink);
				session.setAttribute("list_type_drink", listTypeDrink);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminMenu.jsp");
				rd.forward(request, response);
			}
		}
		if(request.getParameter("update1") != null) { 
			String id = request.getParameter("iddrink");
			String name = request.getParameter("name");
			String ingredient = request.getParameter("ingredient");
			String type = request.getParameter("typedrink");
			String price = request.getParameter("price");
			String img = request.getParameter("img");
			String checkAdmin = request.getParameter("isAdmin");
			int isAdmin = Integer.parseInt(checkAdmin);
			if(img == "") {
				Drink drink = (Drink)session.getAttribute("drink");
				img = drink.getIMG();
			}
			if(drink_BO.CheckUpdate(id, name, type, ingredient, Double.parseDouble(price), img)) {
				List<Drink> listDrink = new ArrayList<Drink>();
				List<String> listTypeDrink = new ArrayList<String>();
				listDrink = drink_BO.getAllDrink();
				listTypeDrink = drink_BO.getAllTypeDrink();
				session.setAttribute("list_drink", listDrink);
				session.setAttribute("list_type_drink", listTypeDrink);
				if(isAdmin == 1 ) {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminMenu.jsp");
					rd.forward(request, response);
				}
				else {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/NV.jsp");
					rd.forward(request, response);
				}
			}
		}
		if(request.getParameter("search") != null) {
			System.out.println("search");
			String txtSearch = request.getParameter("txt_search");
			System.out.println(txtSearch);
			String typeSeatch = request.getParameter("typedrink");
			System.out.println(typeSeatch);
			String checkAdmin = request.getParameter("isAdmin");
			int isAdmin = Integer.parseInt(checkAdmin);
			List<Drink> listDrink = new ArrayList<Drink>();
			List<String> listTypeDrink = new ArrayList<String>();
			listDrink = drink_BO.getDrinkbyNameandType(txtSearch, typeSeatch);
			listTypeDrink = drink_BO.getAllTypeDrink();
			session.setAttribute("list_drink", listDrink);
			session.setAttribute("list_type_drink", listTypeDrink);
			if(isAdmin == 1) {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminMenu.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/NV.jsp");
				rd.forward(request, response);
			}
		}
		if(request.getParameter("search_no_login") != null) {
			String typeSearch = request.getParameter("typedrink");
			System.out.println(typeSearch);
			List<Drink> listDrink = new ArrayList<Drink>();
			List<String> listTypeDrink = new ArrayList<String>();
			listDrink = drink_BO.getDrinkByType(typeSearch);
			listTypeDrink = drink_BO.getAllTypeDrink();
			request.setAttribute("list_drink", listDrink);
			request.setAttribute("list_type_drink", listTypeDrink);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/NoLogin.jsp");
			rd.forward(request, response);
		}
	}
}
