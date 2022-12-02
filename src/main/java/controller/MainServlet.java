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

import model.BEAN.Drink;
import model.BO.Drink_BO;
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet{
	public MainServlet() {
		// TODO Auto-generated constructor stub
		super();
	}
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Drink_BO drink_BO = new Drink_BO();
		List<Drink> listDrink = new ArrayList<Drink>();
		List<String> listTypeDrink = new ArrayList<String>();
		listDrink = drink_BO.getAllDrink();
		listTypeDrink = drink_BO.getAllTypeDrink();
		session.setAttribute("list_drink", listDrink);
		session.setAttribute("list_type_drink", listTypeDrink);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/NoLogin.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
