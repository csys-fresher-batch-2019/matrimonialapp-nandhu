package com.nandhu.dao;

import com.nandhu.impl.RequestStatusImpl;

public interface RequestStatusDAO {

	public void insertRequest(RequestStatusImpl r);
	
	String[] getRequestStatus(String requestor,String status);
	
	String[] getRequestorList(String requestor);
	
	String[] getAcceptorList(String acceptor);
	
	public void updateStatus(String requestor,String acceptor,String status);

	
}
