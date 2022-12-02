package model.DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.BEAN.*;
public class User_DAO {
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
	public boolean isValid(String MaUser) {
		List<User> res = getAllUser();
		for(User a : res)
		{
			if(a.getID_User().equals(MaUser)) return true;
		}
		return false;
	}
	public List<User> getAllUser()
	{
		List<User> res = new ArrayList<User>();
		try 
		{
			String sql="SELECT * FROM user" ; 
			ResultSet rs= excute_querry(sql);
			while (rs.next())
			{
				String id=rs.getString(1) ; 
				String name = rs.getString(2);
				Date date = rs.getDate(3);
				String email =rs.getString(4);
				String phone = rs.getString(5);
				String img = rs.getString(6);
				User user = new User(id, name, email, phone, img, date);
				res.add(user);
			}
			rs.close();
			
		} catch (Exception e)
		{
			System.out.println("err "+e);
		} ;  
		return res;
	}
	public User getUser(String MaUser) {
		List<User> temp  = getAllUser();
		for(User a : temp)
		{
			if(a.getID_User().equals(MaUser)) return a;
		}
		return null;
	}
//	public List<User> getUserbyName(String nameSearch) {
//		List<User> res = new ArrayList<User>();
//		try 
//		{
//			String sql="SELECT * FROM user where " ; 
//			ResultSet rs= querry(sql);
//			while (rs.next())
//			{
//				String id=rs.getString(1) ; 
//				String name = rs.getString(2);
//				Date date = rs.getDate(3);
//				String email =rs.getString(4);
//				String phone = rs.getString(5);
//				String img = rs.getString(6);
//				User user = new User(id, name, email, phone, img, date);
//				res.add(user);
//			}
//			rs.close();
//			
//		} catch (Exception e)
//		{
//			System.out.println("err "+e);
//		} ;  
//		return res;
//	}
	public void delUser(String MaUser) 
	{
		String sql = "delete from user where MaTK = " + MaUser;
		excute_update(sql);
	}
	public void addUser(String MaUser, String HoTen, Date NgaySinh, String Email, String SDT, String img) 
	{
		String sql = "INSERT INTO `user`(`ID_User`, `Name`, `DateOfBirth`, `Email`, `Phone`, `IMG`) VALUES ('"+MaUser+"','"+HoTen+"','"+NgaySinh+"','"+Email+"','"+SDT+"','"+img+"')";
		excute_update(sql);
	}
	public void updateUser(String MaUser, String HoTen, Date NgaySinh, String Email, String SDT, String img) {
		String sql = "UPDATE `user` SET `Name`='"+HoTen+"',`DateOfBirth`='"+NgaySinh+"',`Email`='"+Email+"',`Phone`='"+SDT+"',`IMG`='"+img+"' WHERE ID_User = '" + MaUser + "'";
		excute_update(sql);
	}
	public List<User> getUserbySearch(String txtSearch, String typeSearch) {
		System.out.println("search_DAO");
		List<User> res = new ArrayList<User>();
		try 
		{
			String sql=""; 
			if(typeSearch.equals("ID_User")) {
				sql = "SELECT * FROM user WHERE ID_User = '" +txtSearch+"'";
			}
			else if(typeSearch.equals("Name")) {
				sql = "SELECT * FROM user WHERE Name LIKE '%" + txtSearch + "%'";
			}
			else {
				sql = "SELECT * FROM user WHERE Phone LIKE '%" + txtSearch + "%'";
			}
			ResultSet rs= excute_querry(sql);
			while (rs.next())
			{
				String id=rs.getString(1) ; 
				String name = rs.getString(2);
				Date date = rs.getDate(3);
				String email =rs.getString(4);
				String phone = rs.getString(5);
				String img = rs.getString(6);
				User user = new User(id, name, email, phone, img, date);
				res.add(user);
			}
			rs.close();
			
		} catch (Exception e)
		{
			System.out.println("err "+e);
		} ;  
		return res;
	}
}
