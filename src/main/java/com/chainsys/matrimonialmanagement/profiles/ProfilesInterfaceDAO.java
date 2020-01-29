package com.chainsys.matrimonialmanagement.profiles;

import java.util.ArrayList;

public interface ProfilesInterfaceDAO {
	int getTotalCount();
	
	public String[] getProfile(String userName);

	//public String[] getFemaleProfile(String gender);
	
	public String[] getGenderProfile(String gender);
	
	//public String[] getFemaleHeight(double height,String gender);
	
	public String[] getHeight(double height,String gender);
	
	public String[] getSalaryDetails(int salary,String gender);
	
	public String[] getOccupation(String gender,String occupation);
	
	public String[] getNotInOccupation(String gender,String occupation);

	public String[] getCityProfile(String gender,String city);
	
	public String[] getAgeDetails();
	
	public void save(ProfilesImpl p);
	
	public void delete(int id);
	
	public void updateProfiles(String occupation,int salary,String userName,Long mobNo);

	public void updateActive(int userId,int active);
	
	public void userLogin(String userEmail,String userpassword);
	
	public String[] getReligion(String gender,String religion);
	}
