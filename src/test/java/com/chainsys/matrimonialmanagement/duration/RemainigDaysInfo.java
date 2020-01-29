package com.chainsys.matrimonialmanagement.duration;

import java.util.Scanner;

import com.chainsys.matrimonialmanagement.duration.MembershipDurationImpl;

public class RemainigDaysInfo {

	public static void main(String[] args) {
		MembershipDurationImpl md=new MembershipDurationImpl();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter id=");
		int UserId=s.nextInt();	
		md.getRemainingDays(UserId);
		
	}

}
