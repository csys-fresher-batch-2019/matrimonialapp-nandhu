package com.chainsys.matrimonialmanagement.duration;

import java.util.Scanner;

import com.chainsys.matrimonialmanagement.duration.MembershipDurationImpl;

public class MembershipDuartionSave {

	public static void main(String[] args) {
		MembershipDurationImpl md=new MembershipDurationImpl();
		Scanner s=new Scanner(System.in);
		//System.out.println("membership_id=");
		//md.memberId=s.nextInt();	
		System.out.println("membership_user_id=");
		md.mdUserId=s.nextInt();
		System.out.println("membership_plan_id=");
		md.mdPlanId=s.nextInt();
		md.saveMembershipDurationDetails(md);
	}

}
