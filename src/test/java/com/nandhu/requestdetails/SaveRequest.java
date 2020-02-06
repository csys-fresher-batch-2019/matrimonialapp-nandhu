package com.nandhu.requestdetails;

import java.util.Scanner;

import com.nandhu.impl.Logger;
import com.nandhu.impl.RequestStatusImpl;


public class SaveRequest {
	   @SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {
RequestStatusImpl rs=new RequestStatusImpl();
@SuppressWarnings("resource")
Scanner s=new Scanner(System.in);
Logger.debug("Enter Requestor Mail ID=");
rs.setRequestor(s.nextLine());
Logger.debug("Enter Acceptor Mail ID=");
rs.setAcceptor(s.next());
rs.insertRequest(rs);



	}

}
