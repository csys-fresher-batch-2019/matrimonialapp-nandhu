package com.nandhu.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.nandhu.util.ConnectionUtil;

public class AdminLoginImpl {

	private String userName;
	private String password;
	@Override
	public String toString() {
		return "AdminLoginImpl [userName=" + userName + ", password=" + password + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void adminLogin(AdminLoginImpl al) {
		String sql = "select user_name,password from login where user_name='"+userName+"' and password='"+password+"'";
		try(Connection con = ConnectionUtil.getConnect();Statement stmt = con.createStatement();ResultSet rs = stmt.executeQuery(sql))
		{
			if (rs.next()) {
				String userName1 = rs.getString("user_name");
				//LOGGER.debug("Name="+mail);
				String password1 = rs.getString("password");
				//LOGGER.debug("Age="+password);
				if(userName1.equals(userName)&& password1.equals(password))
						Logger.debug("Logged In...");
			}	else {
			Logger.debug("Login Failed...");}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

