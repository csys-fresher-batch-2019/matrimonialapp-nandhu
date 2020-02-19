package com.nandhu.dao;

import java.util.List;

import com.nandhu.impl.MembershipDurationImpl;

public interface MembershipDurationDAO {
	
	public List<MembershipDurationImpl> getMembershipDetails();

	public void saveMembershipDurationDetails(MembershipDurationImpl md);
	
	public String[] updateExpiryDate(MembershipDurationImpl md);
	
	public void deleteDuration(int memberId);
	
	public List<MembershipDurationImpl> getRemainingDays(int userId);
	
	public void calculateExpiryDuration(int userId,int mdplanId,int monthValidity);
}
