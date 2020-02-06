package com.nandhu.membership;

import java.util.Scanner;

import com.nandhu.impl.Logger;
import com.nandhu.impl.MembershipPlanImpl;


public class UpdatePlanInfo {
	   @SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {

		MembershipPlanImpl mp=new MembershipPlanImpl();
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		Logger.debug("Enter ID:");
		int planId=s.nextInt();
		Logger.debug("Enter Amount:");
		int amount=s.nextInt();
		mp.updatePlan(amount,planId);
		
	}

}
