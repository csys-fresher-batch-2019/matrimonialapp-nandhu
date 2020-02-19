package com.nandhu.dao;

	import org.jdbi.v3.sqlobject.statement.SqlQuery;

import com.nandhu.impl.AdminLoginImpl;

	public interface AdminLoginDAO 
	{
@SqlQuery("select user_name,password from login where user_name=? and password=?")
public String adminLogin(AdminLoginImpl al);
	}