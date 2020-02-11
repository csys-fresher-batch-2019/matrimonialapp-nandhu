package com.nandhu.dao;

import java.util.List;

import com.nandhu.impl.RequestStatusImpl;

public interface RequestStatusDAO {

	public void insertRequest(RequestStatusImpl r);
	
	public List<RequestStatusImpl> getRequestStatus(String requestor, String status);
	
	public List<RequestStatusImpl> getRequestorList(String requestor);
	
	public List<RequestStatusImpl> getAcceptorList(String acceptor);
	
	public void updateStatus(String requestor,String acceptor,String status);

	
}
