package com.nandhu.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nandhu.util.ConnectionUtil;

public class RequestStatusImpl implements com.nandhu.dao.RequestStatusDAO {
	private static final Logger LOGGER = Logger.getInstance();
	private String requestor;
	private String acceptor;
	private String status;

	public String getRequestor() {
		return requestor;
	}

	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}

	public String getAcceptor() {
		return acceptor;
	}

	public void setAcceptor(String acceptor) {
		this.acceptor = acceptor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	@Override
	public String toString() {
		return "RequestStatusImpl [requestor=" + requestor + ", acceptor=" + acceptor + ", status=" + status + "]";
	}
	public String toString1() {
		return "RequestStatusImpl [requestor=" + requestor + ", acceptor=" + acceptor + "]";
	}
	public String toString2() {
		return "RequestStatusImpl [ acceptor=" + acceptor + ", status=" + status + "]";
	}
	public String toString3() {
		return "RequestStatusImpl [requestor=" + requestor + ", status=" + status + "]";
	}
	public void insertRequest(RequestStatusImpl r) {
		String sql = "insert into request(requestor,acceptor)values(?,?)";
		@SuppressWarnings("unused")
		String errorMessage = null;
		try (Connection con = ConnectionUtil.getConnect(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, r.getRequestor());
			ps.setString(2, r.getAcceptor());
			int row = ps.executeUpdate();
			Logger.debug(row + "Rows Inserted");
		} catch (Exception e) {
			errorMessage = "Unable to insert";
		}
	}

	public List<RequestStatusImpl> getRequestStatus(String requestor, String status) {
		List<RequestStatusImpl> list=new ArrayList<RequestStatusImpl>();
		String sql = "select * from request where requestor='" + requestor + "' and status='" + status + "'";
		try (Connection con = ConnectionUtil.getConnect();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String acc = rs.getString("acceptor");
				String sts = rs.getString("status");
				RequestStatusImpl r=new RequestStatusImpl();
				r.setAcceptor(acc);
				r.setRequestor(requestor);
				list.add(r);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<RequestStatusImpl> getRequestorList(String requestor) {
		List<RequestStatusImpl> list=new ArrayList<RequestStatusImpl>();
		String sql = "select * from request where requestor='" + requestor + "'";
		try (Connection con = ConnectionUtil.getConnect();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String acc = rs.getString("acceptor");
				String sts = rs.getString("status");
				RequestStatusImpl r=new RequestStatusImpl();
				r.setAcceptor(acc);
				r.setStatus(sts);
				list.add(r);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<RequestStatusImpl> getAcceptorList(String acceptor) {
		List<RequestStatusImpl> list=new ArrayList<RequestStatusImpl>();
		String sql = "select * from request where acceptor='" + acceptor + "'";
		try (Connection con = ConnectionUtil.getConnect();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String req = rs.getString("requestor");
				String sts = rs.getString("status");
				RequestStatusImpl r=new RequestStatusImpl();
				r.setRequestor(req);
				r.setStatus(sts);
list.add(r);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void updateStatus(String requestor, String acceptor,String status) {
		String sql="update request set status=? where requestor=? and acceptor=?";
		@SuppressWarnings("unused")
		String error=null;
		int row=0;
		try(Connection con =  ConnectionUtil.getConnect();PreparedStatement ps=con.prepareStatement(sql))
		{
				ps.setString(1, status);
				ps.setString(2, requestor);
				ps.setString(3, acceptor);
			 row=ps.executeUpdate();
			 if(row==1) {
					Logger.debug(row+"Rows Updated");

				}
				else
				{
					Logger.debug("Invalid input");

				}
				}
		catch(Exception e)
		{
			error="unalble to update";
		}		

		
		
			
	}

}
/*
 * create table request_status ( user_1_id number, user_2_id number, status
 * varchar2(20)not null, request_starts_by number(20)not null, constraint
 * user_1_id_fk foreign key(user_1_id)references profiles(user_id), constraint
 * user_2_id_fk foreign key(user_2_id)references profiles(user_id), constraint
 * status_cq check(status in ('accepted','rejected')) );
 */