package model.DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.BEAN.*;
public class Drink_DAO {
	static String NAME_DB = "com.mysql.jdbc.Driver";
	static String URL = "jdbc:mysql://localhost/ltm";
	public ResultSet querry(String sql)
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
	public boolean checkDoUong(String MaDoUong) throws SQLException {
		List<Drink> res = getAllDoUong();
		for(Drink a : res)
		{
			if(a.getID_Drink().equals(MaDoUong)) return false;
		}
		return true;
	}
	public List<Drink> getAllDoUong()
	{
		List<Drink> res = new ArrayList<Drink>();
		//CoSoDuLieu
		try {
			String sql = "select * from drink";
			ResultSet temp = querry(sql);
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
	public Drink getDoUong (String MaDoUong) throws SQLException {
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
			String sql = "select * from drink where Type = "+ typeDrinkSearch +" and Name_Drink LIKE '%" + nameSearch + "%'";
			ResultSet temp = querry(sql);
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
			ResultSet temp = querry(sql);
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
	public void delDoUong(String MaDoUong) 
	{
		String sql = "delete from drink where MaTK = " + MaDoUong;
		ResultSet rs = querry(sql);
	}
	public void addDoUong(String MaDoUong, String TenDoUong, String NguyenLieu, double Gia, String img) 
	{
		String sql = "INSERT INTO `drink`(`ID_Drink`, `Name_Drink`, `Ingredient`, `Price`, `IMG`) VALUES ('"+MaDoUong+"','"+TenDoUong+"','"+NguyenLieu+"','"+Gia+"','"+img+"')";
		ResultSet rs = querry(sql);
	}
//	public void updateDoUong(String MaDoUong, String TenDoUong, String NguyenLieu, double Gia, String img) {
//		String sql = "UPDATE `drink` SET Name_Drink`='"+TenDoUong+"',`Ingredient`='"+NguyenLieu+"',`Price`='"+Gia+"',`IMG`='"+img+"' WHERE ID_Drink = " + MaDoUong;
//	}
	
	public void updateDoUong(String MaDoUong, String TenDoUong, String NguyenLieu, double Gia, String img) {
		try {
			Class.forName(NAME_DB);  
			Connection con=DriverManager.getConnection(URL,"root","");  
			PreparedStatement pstmt = null;
			pstmt = con.prepareStatement("UPDATE DRINK SET Name_Drink =?, Ingredient =?, Price =?, IMG =?  WHERE ID_Drink =? ");
			pstmt.setString(1,TenDoUong);
			pstmt.setString(2,NguyenLieu);
			pstmt.setDouble(3,Gia);
			pstmt.setString(4,img);
			pstmt.setString(5,MaDoUong);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
