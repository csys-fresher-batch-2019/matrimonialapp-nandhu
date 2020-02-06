package com.nandhu.dao;

import com.nandhu.impl.MembershipDurationImpl;

public interface MembershipDurationDAO {
	
	public String[] getMembershipDetails();

	public void saveMembershipDurationDetails(MembershipDurationImpl md);
	
	public String[] updateExpiryDate(MembershipDurationImpl md);
	
	public void deleteDuration(int memberId);
	
	public String[] getRemainingDays(int userId);
	
	public void calculateExpiryDuration(int userId,int mdplanId,int monthValidity);
}
