package com.nandhu.membership;

import java.util.List;

import com.nandhu.impl.MembershipPlanImpl;

//import java.util.Scanner;

public class ExpiryDateInfo {

	public static void main(String[] args) {

		MembershipPlanImpl mp=new MembershipPlanImpl();
		List<MembershipPlanImpl> list = mp.getExpiryDateDetails();
		for (MembershipPlanImpl r : list) {
			System.out.println(r.toString2());
		}
		
	}

}
