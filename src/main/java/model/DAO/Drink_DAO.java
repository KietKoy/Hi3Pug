package model.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.BEAN.*;
public class Drink_DAO {
	static String NAME_DB = "com.mysql.jdbc.Driver";
	static String URL = "jdbc:mysql://localhost/ltmang";
	public ResultSet excute_querry(String sql)
	{
		ResultSet rs = null;
		try 
		{
			Class.forName(NAME_DB) ; 
			String url= URL; 
			Connection con=DriverManager.getConnection(url,"root","") ; 
			Statement stmt=con.createStatement() ;
			String sql1= sql; 
			rs = stmt.executeQuery(sql1) ; 
			
		} catch (Exception e)
		{
			System.out.println("err "+e);
		} ; 
		return rs;
	}
	public void excute_update(String sql)
	{
		try 
		{
			Class.forName(NAME_DB) ; 
			String url= URL; 
			Connection con=DriverManager.getConnection(url,"root","") ; 
			Statement stmt=con.createStatement() ;
			String sql1= sql; 
			stmt.executeUpdate(sql1) ; 
			
		} catch (Exception e)
		{
			System.out.println("err "+e);
		} ; 
		
	}
	public boolean checkDoUong(String MaDoUong) {
		List<Drink> res = getAllDoUong();
		for(Drink a : res)
		{
			if(a.getID_Drink().equals(MaDoUong)) return false;
		}
		return true;
	}
	public boolean isValid(String MaDoUong) {
		List<Drink> res = getAllDoUong();
		for(Drink a : res)
		{
			if(a.getID_Drink().equals(MaDoUong)) return true;
		}
		return false;
	}
	public List<Drink> getAllDoUong()
	{
		List<Drink> res = new ArrayList<Drink>();
		//CoSoDuLieu
		try {
			String sql = "select * from drink";
			ResultSet temp = excute_querry(sql);
			while(temp.next())
			{
				String id_drink = temp.getString(1);
				String name_drink = temp.getString(2);
				String type = temp.getString(3);
				String ingredient = temp.getString(4);
				Double price = temp.getDouble(5);
				String img = temp.getString(6);
				Drink d = new Drink(id_drink, name_drink, type, ingredient, img, price);
				res.add(d);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return res;
	}
	public Drink getDoUong (String MaDoUong) {
		List<Drink> temp  = getAllDoUong();
		for(Drink a : temp)
		{
			if(a.getID_Drink().equals(MaDoUong)) return a;
		}
		return null;
	}
	public List<Drink> getDrinkbyNameandType(String nameSearch, String typeDrinkSearch) {
		List<Drink> res = new ArrayList<Drink>();
		//CoSoDuLieu
		try {
			String sql = "SELECT * FROM drink WHERE Type = '"+ typeDrinkSearch +"' AND Name_Drink LIKE '%" + nameSearch + "%'";
			ResultSet temp = excute_querry(sql);
			while(temp.next())
			{
				String id_drink = temp.getString(1);
				String name_drink = temp.getString(2);
				String type = temp.getString(3);
				String ingredient = temp.getString(4);
				Double price = temp.getDouble(5);
				String img = temp.getString(6);
				Drink d = new Drink(id_drink, name_drink, type, ingredient, img, price);
				res.add(d);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return res;
	}
	
	public List<String> getAllTypeDrink()
	{
		List<String> res = new ArrayList<String>();
		//CoSoDuLieu
		try {
			String sql = "select DISTINCT Type from drink";
			ResultSet temp = excute_querry(sql);
			while(temp.next())
			{
				String type = temp.getString(1);
				res.add(type);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return res;
	}
	public List<Drink> getDrinkByType(String typeSearch) {
		List<Drink> res = new ArrayList<Drink>();
		//CoSoDuLieu
		try {
			String sql = "SELECT * FROM drink WHERE Type = '" +typeSearch+"'";
			ResultSet temp = excute_querry(sql);
			while(temp.next())
			{
				String id_drink = temp.getString(1);
				String name_drink = temp.getString(2);
				String type = temp.getString(3);
				String ingredient = temp.getString(4);
				Double price = temp.getDouble(5);
				String img = temp.getString(6);
				Drink d = new Drink(id_drink, name_drink, type, ingredient, img, price);
				res.add(d);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return res;
	}

	public void delDrink(String MaDoUong) 
	{
		String sql = "delete from drink where ID_Drink = '" + MaDoUong + "'";
		excute_update(sql);
	}
	public void addDoUong(String MaDoUong, String TenDoUong,String type, String NguyenLieu, double Gia, String img) 
	{
		String sql = "INSERT INTO `drink`(`ID_Drink`, `Name_Drink`, `Type`,`Ingredient`, `Price`, `IMG`) VALUES ('"+MaDoUong+"','"+TenDoUong+"','"+type+"','"+NguyenLieu+"','"+Gia+"','"+img+"')";
		excute_update(sql);
	}
	public void updateDoUong(String MaDoUong, String TenDoUong,String Type, String NguyenLieu, double Gia, String img) {
		String sql = "UPDATE `drink` SET `Name_Drink`='"+TenDoUong+"',`Type`='"+Type+"',"
				+ "`Ingredient`='"+NguyenLieu+"',`Price`='"+Gia+"',`IMG`='"+img+"' WHERE ID_Drink = '" + MaDoUong + "'";
		excute_update(sql);
		System.out.println("update_DAO");
	}
}
