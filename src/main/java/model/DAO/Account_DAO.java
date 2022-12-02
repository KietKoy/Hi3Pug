package model.DAO;
import java.sql.* ; 
import javax.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.BEAN.*;
public class Account_DAO {
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
	public Account getAccountbyID_Account(String id_account) {
		System.out.println("DAO");
		List<Account> temp = getAllAccount();
		for(Account acc : temp) {
			if(acc.getID_Account().equals(id_account)) return acc;
		}
		return null;
	}
	public boolean isValid(String useraname ) {
		List<Account> res = getAllAccount();
		for(Account a : res)
		{
			if(a.getUsername().equals(useraname)) return true;
		}
		return false;
	}
	public int isValidAccount(String username, String password)  {
		List<Account> res = getAllAccount();
		for(Account a : res)
		{
			if(a.getUsername().equals(username) && a.getPassword().equals(password)) {
				if(a.getIsAdmin() == 1) return 1;
				else return 0;
			}
		}
		return -1;
	}
	public List<Account> getAllAccount()
	{
		List<Account> res = new ArrayList<Account>();
		try 
		{
			String sql="SELECT * FROM account" ; 
			ResultSet rs= excute_querry(sql);
			while (rs.next())
			{
				String id=rs.getString(1) ; 
				String userName = rs.getString(2);
				String passWord = rs.getString(3);
				int isAdmin =rs.getInt(4);
				Account acc = new Account(id, userName, passWord, isAdmin);
				res.add(acc);
			}
			rs.close();
			
		} catch (Exception e)
		{
			System.out.println("err "+e);
		} ;  
		return res;
	}
	public Account getAccount(String user, String password) {
		List<Account> l = new ArrayList<Account>();
		try 
		{

			String sql="SELECT * FROM `account`" ; 
			ResultSet rs= excute_querry(sql);
			while (rs.next())
			{
				String id=rs.getString(1) ; 
				String userName = rs.getString(2);
				String passWord = rs.getString(3);
				int isAdmin =rs.getInt(4);
				Account acc = new Account(id, userName, passWord, isAdmin);
				l.add(acc);
			}
			rs.close();
			
		} catch (Exception e)
		{
			System.out.println("err "+e);
		} ;  
		for(Account a : l)
		{
			if(a.getUsername().equals(user) && a.getPassword().equals(password)) return a;
		}
		return null;
	}
	public void AddAccount(String id_account,String userName,String password, int isAdmin ) {
		String sql = "INSERT INTO `account`(`ID_Account`, `Username`, `Password`, `isAdmin`) VALUES ('"+id_account+"','"+userName+"','"+ password+"','"+isAdmin+"')";
		excute_update(sql);
	}
	public void delAcccount(String MaTK) {
		String sql = "delete from account where MaTK = " + MaTK;
		excute_update(sql);
	}
	public void updateAcccount(String id_account,String userName,String password, int isAdmin ) {
		String sql  = "UPDATE account SET Username = " + userName + ",Password = "+ password + ", isAdmin = " + isAdmin + "Where ID_Account= '" + id_account+"'";
		excute_update(sql);
	}
}
