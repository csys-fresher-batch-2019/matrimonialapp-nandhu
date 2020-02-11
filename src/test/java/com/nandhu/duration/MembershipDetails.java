package com.nandhu.duration;

import java.util.List;

import com.nandhu.impl.MembershipDurationImpl;

public class MembershipDetails {

	public static void main(String[] args) {

		MembershipDurationImpl md=new MembershipDurationImpl();
		List<MembershipDurationImpl> list = md.getMembershipDetails();
for(MembershipDurationImpl MembershipDurationImpl : list) {
	System.out.println(MembershipDurationImpl.toString2());
}
	}

}
