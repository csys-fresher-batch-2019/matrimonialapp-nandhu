package com.chainsys.matrimonialmanagement.duration;

import com.chainsys.matrimonialmanagement.profiles.ProfilesImpl;

public interface MembershipDurationDAO {
	
	public String[] getMembershipDetails();

	public void saveMembershipDurationDetails(MembershipDurationImpl md);
	
	public String[] updateExpiryDate(MembershipDurationImpl md);
	
	public void deleteDuration(int memberId);
	
	public String[] getRemainingDays(int userId);
	
	public void calculateExpiryDuration(int userId,int mdplanId,int monthValidity);
}
