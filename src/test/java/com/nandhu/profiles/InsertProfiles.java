package com.nandhu.profiles;



import java.util.Scanner;

import com.nandhu.impl.Logger;
import com.nandhu.impl.ProfilesImpl;


public class InsertProfiles {

	public static void main(String[] args) {
		ProfilesImpl p=new ProfilesImpl();
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		Logger.debug("Enter user name=");
		p.setUserName(s.nextLine());
		Logger.debug("Enter Dob=");
		p.setDob(java.sql.Date.valueOf((s.nextLine())));
		s.nextLine();
		Logger.debug("Enter gender(M/F)=");
		p.setGender(s.nextLine());
		Logger.debug("Enter religion=");
		p.setReligion(s.nextLine());
		Logger.debug("Enter caste=");
		p.setCaste(s.nextLine());
		Logger.debug("Enter country=");
		p.setCountry(s.nextLine());
		Logger.debug("Enter State=");
		p.setState(s.nextLine());
		Logger.debug("Enter city=");
		p.setCity(s.nextLine());
		Logger.debug("Enter mobNo=");
		p.setMobNo(s.nextLong());
		Logger.debug("Enter AadharNo=");
		p.setAadharNo(s.nextLong());
		s.nextLine();
		Logger.debug("Enter Mail Id=");
		p.setMail(s.nextLine());
		Logger.debug("Enter Height=");
		p.setHeight(s.nextDouble());
		s.nextLine();
		Logger.debug("Enter Education=");
		p.setEducation(s.nextLine());
		Logger.debug("Enter Occupation=");
		p.setOccupation(s.nextLine());
		Logger.debug("Enter Salary=");
		p.setSalary(s.nextInt());
		s.nextLine();
		Logger.debug("Enter Marital Status=");
		p.setMaritalSts(s.nextLine());
		Logger.debug("Enter Membership Type(platinum/gold/silver)=");
		p.setMembershipType(s.nextLine());
		Logger.debug("Enter Password=");
		p.setPass(s.nextLine());
		Logger.debug("Upload picture=");
		p.setPass(s.nextLine());
		p.save(p);
	}
}
