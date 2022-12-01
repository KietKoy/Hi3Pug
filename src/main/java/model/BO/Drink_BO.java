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
	public void updateDoUong(String MaDoUong, String TenDoUong, String NguyenLieu, double Gia, String img) {
		new Drink_DAO().updateDoUong(MaDoUong, TenDoUong, NguyenLieu, Gia, img);
	}
}

