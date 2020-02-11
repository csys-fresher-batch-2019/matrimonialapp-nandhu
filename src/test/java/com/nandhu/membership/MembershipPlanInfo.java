package com.nandhu.membership;


import java.util.List;

import com.nandhu.impl.MembershipPlanImpl;


public class MembershipPlanInfo {
	public static void main(String[] args) {
		
		MembershipPlanImpl m=new MembershipPlanImpl();
		
		List<MembershipPlanImpl> list = m.getMembershipPlanDetails();
		for (MembershipPlanImpl r : list) {
			System.out.println(r.toString1());
		}
		
	}

	}
