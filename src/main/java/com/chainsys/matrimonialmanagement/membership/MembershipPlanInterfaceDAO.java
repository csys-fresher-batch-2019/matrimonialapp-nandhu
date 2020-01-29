package com.chainsys.matrimonialmanagement.membership;

public interface MembershipPlanInterfaceDAO {
	
	public String[] getMembershipPlanDetails();

	//public void deletePlan(int planId);
	
	public void savePlan(MembershipPlanImpl mp);
	
	public String[] getExpiryDateDetails();


}
