package com.resfinder.web.dao;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

import com.resfinder.web.model.Login;

public class LoginDao implements java.sql.Driver{
	//public Login getLogin(int id)
//	{
//		Login l= new Login();
//		l.setId(3);
//		l.setUsername("mahesh11");
//		l.setPassword("mahesh11");
		
//		return l;
//	}
	String url="jdbc:localhost:3306/resfinderdb";
	String username="root";
	String password = "root";
	public boolean check(String uname,String pass)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			
			PreparedStatement st= con.prepareStatement(url);
			st.setString(1, uname);
			st.setString(2, pass);
			
			ResultSet rs=st.executeQuery();
			
			if(rs.next()) {
				return true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public Connection connect(String url, Properties info) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean acceptsURL(String url) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getMajorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getMinorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean jdbcCompliant() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}
}
