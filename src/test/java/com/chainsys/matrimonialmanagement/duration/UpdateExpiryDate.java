package com.chainsys.matrimonialmanagement.duration;

import java.util.Scanner;

import com.chainsys.matrimonialmanagement.duration.MembershipDurationImpl;

public class UpdateExpiryDate {

	public static void main(String[] args) {
		
		MembershipDurationImpl md=new MembershipDurationImpl();
		Scanner s=new Scanner(System.in);
		System.out.println("user_id=");
		md.mdUserId=s.nextInt();
		System.out.println("plan_id=");
		md.mdPlanId=s.nextInt();
		System.out.println("Month Validity=");
		md.monthValidity=s.nextInt();
		md.updateExpiryDate(md);
		
	}

}
