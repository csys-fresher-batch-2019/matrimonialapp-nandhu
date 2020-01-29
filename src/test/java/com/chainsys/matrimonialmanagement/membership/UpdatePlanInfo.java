package com.chainsys.matrimonialmanagement.membership;

import java.util.Scanner;

import com.chainsys.matrimonialmanagement.membership.MembershipPlanImpl;

public class UpdatePlanInfo {

	public static void main(String[] args) {

		MembershipPlanImpl mp=new MembershipPlanImpl();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter ID:");
		int planId=s.nextInt();
		System.out.println("Enter Amount:");
		int amount=s.nextInt();
		mp.updatePlan(amount,planId);
		
	}

}
