package com.nandhu.duration;

import java.util.Scanner;

import org.jdbi.v3.core.Jdbi;

import com.nandhu.dao.MembershipDurationDAO;
import com.nandhu.impl.Logger;
import com.nandhu.impl.MembershipDurationImpl;
import com.nandhu.util.ConnectionUtil;

public class TestAdd  {
	
	//jdbi.onDemand(MembershipDurationDAO.class);
	public static void main(String[] args) throws Exception {
	     Jdbi jdbi=ConnectionUtil.getJdbi();
		 MembershipDurationDAO dd=new MembershipDurationImpl();
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


