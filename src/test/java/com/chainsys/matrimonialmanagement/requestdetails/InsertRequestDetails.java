package com.chainsys.matrimonialmanagement.requestdetails;

import java.util.Scanner;

import com.chainsys.matrimonialmanagement.requestdetails.RequestStatusImpl;

public class InsertRequestDetails {

	public static void main(String[] args) {
		RequestStatusImpl rs=new RequestStatusImpl();
Scanner s=new Scanner(System.in);
System.out.println("Enter user id1:");
rs.userId1=s.nextInt();
System.out.println("Enter user id2:");
rs.userId2=s.nextInt();
s.nextLine();
System.out.println("Enter status:");
rs.status=s.nextLine();
s.nextLine();

rs.saveRequestDetails(rs);

	}

}
