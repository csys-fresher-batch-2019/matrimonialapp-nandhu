package com.nandhu.util;

public class ProfileUtil {
	private String aadharNo;
	public  String getAadhar()
	{
		return aadharNo;
	}
	public String setAadhar(String aadharNo)
	{
		if(aadharNo.length()<12)
		{
			throw new IllegalArgumentException("plz enter valid Aadhar Number");
		}
		return this.aadharNo=aadharNo;
	}

}
