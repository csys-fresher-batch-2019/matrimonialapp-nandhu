package com.nandhu.requestdetails;

import java.util.Scanner;

import com.nandhu.impl.Logger;
import com.nandhu.impl.RequestStatusImpl;


public class UpdateStatus {
	   @SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {
		RequestStatusImpl rs=new RequestStatusImpl();
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		Logger.debug("Enter Requestor Mail ID=");
		String requestor=s.nextLine();
		Logger.debug("Enter Acceptor Mail ID=");
		String acceptor=s.nextLine();
		Logger.debug("Enter Status=");
		String status=s.nextLine();
		rs.updateStatus(requestor,acceptor,status);
	}

}
