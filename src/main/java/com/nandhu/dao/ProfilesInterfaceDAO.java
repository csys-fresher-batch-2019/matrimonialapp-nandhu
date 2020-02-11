package com.nandhu.dao;

import java.util.List;

import com.nandhu.impl.ProfilesImpl;

public interface ProfilesInterfaceDAO {
	int getTotalCount();
	
	public List<ProfilesImpl> getProfile(String userName);
	
	public void changePassword(String userEmail,String pass,String userpassword);

	public List<ProfilesImpl> getGenderProfile(String gender);
	
	public List<ProfilesImpl> getHeight(double height, String gender);
	
	public List<ProfilesImpl> getSalaryDetails(int salary,String gender);
	
	public List<ProfilesImpl> getOccupation(String gender, String occupation);
	
	public List<ProfilesImpl> getNotInOccupation(String gender, String occupation);

	public List<ProfilesImpl> getCityProfile(String gender,String city);
	
	public void save(ProfilesImpl p);
	
	public void delete(int id);
	
	public void updateProfiles(String occupation,int salary,String userName,Long mobNo);

	public void updateActive(int userId,int active);
	
	public String userLogin(String mail,String pass);
	
	public List<ProfilesImpl> getReligion(String gender, String religion);
	
	public List<ProfilesImpl> getFullProfile();

	
}
