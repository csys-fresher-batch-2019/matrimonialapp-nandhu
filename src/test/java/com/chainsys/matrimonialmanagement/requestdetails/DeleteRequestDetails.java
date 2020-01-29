package com.chainsys.matrimonialmanagement.requestdetails;

import java.util.Scanner;

import com.chainsys.matrimonialmanagement.profiles.ProfilesImpl;
import com.chainsys.matrimonialmanagement.requestdetails.RequestStatusImpl;

public class DeleteRequestDetails {

public static void main(String[] args) {
RequestStatusImpl rs=new RequestStatusImpl();
Scanner s=new Scanner(System.in);
System.out.println("Enter Status=");
rs.status=s.nextLine();
rs.deleteRequestDetails(rs);

	}
}
