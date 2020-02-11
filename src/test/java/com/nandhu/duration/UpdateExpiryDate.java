package com.nandhu.duration;

import java.util.Scanner;

import com.nandhu.impl.Logger;
import com.nandhu.impl.MembershipDurationImpl;


public class UpdateExpiryDate {
	   @SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {
		MembershipDurationImpl md=new MembershipDurationImpl();
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		Logger.debug("user_id=");
		md.setMdUserId(s.nextInt());
		Logger.debug("plan_id=");
		md.setMdPlanId(s.nextInt());
		Logger.debug("Month Validity=");
		md.setMonthValidity(s.nextInt());
		md.updateExpiryDate(md);
		
	}

}
