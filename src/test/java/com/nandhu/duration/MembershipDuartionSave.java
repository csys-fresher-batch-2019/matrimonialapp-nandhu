package com.nandhu.duration;

import java.util.Scanner;

import com.nandhu.impl.Logger;
import com.nandhu.impl.MembershipDurationImpl;


public class MembershipDuartionSave {
	   @SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {
		MembershipDurationImpl md=new MembershipDurationImpl();
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		//LOGGER.debug("membership_id=");
		//md.memberId=s.nextInt();	
		Logger.debug("membership_user_id=");
		md.setMdUserId(s.nextInt());
		Logger.debug("membership_plan_id=");
		md.setMdPlanId(s.nextInt());
		md.saveMembershipDurationDetails(md);
	}

}
