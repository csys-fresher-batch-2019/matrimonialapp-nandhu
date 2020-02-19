package com.nandhu.duration;

import java.util.Scanner;


import com.nandhu.impl.Logger;
import com.nandhu.impl.MembershipDurationImpl;

public class TestAdd  {
	
	//jdbi.onDemand(MembershipDurationDAO.class);
	public static void main(String[] args) throws Exception {
		MembershipDurationImpl md=new MembershipDurationImpl();
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		Logger.debug("membership_user_id=");
		md.setMdUserId(s.nextInt());
		Logger.debug("membership_plan_id=");
		md.setMdPlanId(s.nextInt());
		md.saveMembershipDurationDetails(md);
	}

	}


