package com.nandhu.dao;

public interface MembershipPlanInterfaceDAO {
	
	public String[] getMembershipPlanDetails();
	
	public void updatePlan(int amount,int planId);


	//public void deletePlan(int planId);
	
	//public void savePlan(MembershipPlanImpl mp);
	
	public String[] getExpiryDateDetails();


}
