package com.chainsys.matrimonialmanagement.requestdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.chainsys.matrimonialmanagement.profiles.ProfilesImpl;

public class RequestStatusImpl implements RequestStatusDAO{
int userId1;
int userId2;
String status;
//int requestInit;


@Override
public String toString() {
	return "RequestStatus [userId1=" + userId1 + ", userId2=" + userId2 + ", status=" + status + "]";
}

public static Connection getConnect() throws Exception 
{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
	System.out.println(con);
	return con;
}

	public String[] getRequestSts()
	{
		try
		{
		Connection con = getConnect();
		Statement stmt = con.createStatement();
		String sql="select * from request_status";
		System.out.println(sql);
		ResultSet rs=stmt.executeQuery(sql);
		while (rs.next()) {
			int userId1= rs.getInt("user_1_id");
			System.out.println("Requestor:"+userId1);
			int userId2= rs.getInt("user_2_id");
			System.out.println("Acceptor="+userId2);
			String status= rs.getString("status");
			System.out.println("Status="+status);
			
		}
		con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				return null;
	}
	
	public void saveRequestDetails(RequestStatusImpl rs)
	{
		try {
			Connection con = getConnect();
			Statement stmt = con.createStatement();
			String sql = "insert into  request_status(user_1_id,user_2_id,status)values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println(sql);
			ps.setInt(1,userId1 );
			ps.setInt(2,userId2 );
			ps.setString(3,status );
		
			int row = ps.executeUpdate();
			System.out.println(row);
			con.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
}
	public void deleteRequestDetails(RequestStatusImpl rs) {
		try {
			Connection con = getConnect();
			Statement stmt = con.createStatement();
			String sql = "delete from request_status where status='"+status+"'";
			System.out.println(sql);
			int row = stmt.executeUpdate(sql);
			System.out.println(row);
			con.close();
		} catch (Exception e) {
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