package com.nandhu.dao;

import java.util.List;

import com.nandhu.impl.MembershipPlanImpl;

public interface MembershipPlanInterfaceDAO {
	
	public List<MembershipPlanImpl> getMembershipPlanDetails();
	
	public void updatePlan(int amount,int planId);
	
	public List<MembershipPlanImpl> getExpiryDateDetails();


}
