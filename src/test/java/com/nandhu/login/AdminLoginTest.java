package com.nandhu.login;

import java.util.Scanner;

import com.nandhu.impl.AdminLoginImpl;
import com.nandhu.impl.Logger;

public class AdminLoginTest {

	public static void main(String[] args) {
AdminLoginImpl al=new AdminLoginImpl();
@SuppressWarnings("resource")
Scanner s=new Scanner(System.in);
Logger.debug("User Name=");
al.setUserName(s.nextLine());
Logger.debug("Password=");
al.setPassword(s.nextLine());
al.adminLogin(al);
	}

}
