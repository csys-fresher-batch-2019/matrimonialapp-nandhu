package com.chainsys.matrimonialmanagement.requestdetails;

public interface RequestStatusDAO {

	public String[] getRequestSts();
	
	public void saveRequestDetails(RequestStatusImpl rs);
	
	public void deleteRequestDetails(RequestStatusImpl rs);

	
}
