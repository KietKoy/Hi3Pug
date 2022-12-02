package model.BO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DAO.*;

import model.BEAN.*;
public class Drink_BO {
	public List<Drink> getAllDrink() {
		return new Drink_DAO().getAllDoUong();
	}
	public List<String> getAllTypeDrink(){
		return new Drink_DAO().getAllTypeDrink();
	}
	public List<Drink> getDrinkbyNameandType(String nameSearch, String typeSearch) {
		return new Drink_DAO().getDrinkbyNameandType(nameSearch, typeSearch);
	}
	public boolean checkDoUong(String madouong) {
		return new Drink_DAO().checkDoUong(madouong);
	}
	public boolean isValid(String madouong) {
		return new Drink_DAO().isValid(madouong);
	}
	public boolean addDrink(String MaDoUong, String TenDoUong,String type, String NguyenLieu, double Gia, String img) {
		Drink_DAO drink_DAO = new Drink_DAO();
		if(checkDoUong(MaDoUong)) {
			drink_DAO.addDoUong(MaDoUong, TenDoUong, type, NguyenLieu, Gia, img);
			return true;
		}
		return false;
	}
	public Drink getDoUong(String madouong) {
		return new Drink_DAO().getDoUong(madouong);
	}
	public boolean CheckUpdate(String MaDoUong, String TenDoUong,String Type, String NguyenLieu, double Gia, String img) {
		Drink_DAO drink_DAO = new Drink_DAO();
		System.out.println("Do Nho BO");
		System.out.println(MaDoUong);
		if(isValid(MaDoUong)) {

			drink_DAO.updateDoUong(MaDoUong, TenDoUong, Type, NguyenLieu, Gia, img);
			return true;
		}
		return false;
	}
	public List<Drink> getDrinkByType(String typeSearch){
		return new Drink_DAO().getDrinkByType(typeSearch);
	}
	public void delDrink(String MaDoUong) {
		Drink_DAO drink_DAO = new Drink_DAO();
		if(isValid(MaDoUong)) {
			drink_DAO.delDrink(MaDoUong);
		}
	}
	
}
