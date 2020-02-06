package com.nandhu.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.nandhu.util.ConnectionUtil;


public class RequestStatusImpl implements com.nandhu.dao.RequestStatusDAO{
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

	public void insertRequest(RequestStatusImpl r) {
		String sql="insert into request(requestor,acceptor)values(?,?)";

		try(Connection con =  ConnectionUtil.getConnect();PreparedStatement ps=con.prepareStatement(sql);)
{
			ps.setString(1,r.getRequestor());
			ps.setString(2, r.getAcceptor());
			int row=ps.executeUpdate();
			Logger.debug(row+"Rows Inserted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			}

	public String[] getRequestStatus(String requestor, String status) {
		String sql="select * from request where requestor='"+requestor+"' and status='"+status+"'";
try(Connection con =  ConnectionUtil.getConnect();Statement stmt = con.createStatement();ResultSet rs=stmt.executeQuery(sql))
{
		while(rs.next())
		{
			
			String acc=rs.getString("acceptor");
			Logger.debug("acceptor="+acc);
			String sts=rs.getString("status");
			Logger.debug("Status="+sts);
			//Logger.debug();
		}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return null;
	}

	public String[] getRequestorList(String requestor) {
		String sql="select * from request where requestor='"+requestor+"'";
		try(Connection con =  ConnectionUtil.getConnect();Statement stmt = con.createStatement();ResultSet rs=stmt.executeQuery(sql))
		{
				while(rs.next())
				{
					
					String acc=rs.getString("acceptor");
					Logger.debug("acceptor="+acc);
					String sts=rs.getString("status");
					Logger.debug("status="+sts);
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		return null;
	}

	public String[] getAcceptorList(String acceptor) {
		String sql="select * from request where acceptor='"+acceptor+"'";
		try(Connection con =  ConnectionUtil.getConnect();Statement stmt = con.createStatement();ResultSet rs=stmt.executeQuery(sql))
		{
				while(rs.next())
				{
					String req=rs.getString("requestor");
					Logger.debug("Requestor="+req);
					
					String sts=rs.getString("status");
					Logger.debug("Status="+sts);
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}		return null;
	}

	public void updateStatus(String requestor, String acceptor,String status) {
		String sql="update request set status=? where requestor=? and acceptor=?";
		try(Connection con =  ConnectionUtil.getConnect();PreparedStatement ps=con.prepareStatement(sql))
		{
				ps.setString(1, status);
				ps.setString(2, requestor);
				ps.setString(3, acceptor);
				int row=ps.executeUpdate();
				Logger.debug(row+"Rows Updated");
				}
			catch(Exception e)
			{
				e.printStackTrace();
			}		
	}

}
/*create table request_status
(
user_1_id  number,
user_2_id number,
status varchar2(20)not null,
request_starts_by number(20)not null,
constraint user_1_id_fk foreign key(user_1_id)references profiles(user_id),
constraint user_2_id_fk foreign key(user_2_id)references profiles(user_id),
constraint status_cq check(status in ('accepted','rejected'))
);*/