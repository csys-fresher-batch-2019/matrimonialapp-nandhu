package com.chainsys.matrimonialmanagement.membership;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class MembershipPlanImpl implements MembershipPlanInterfaceDAO {
	
int planId;
String membershipType;
int totalMonths;
int amount;
String userName;
LocalDate registerdDate;
LocalDate expiryDate;
int userId;

public static Connection getConnect() throws Exception 
{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
	System.out.println(con);
	return con;
}


@Override
public String toString() {
	return "MembershipPlan [planId=" + planId + ", membershipType=" + membershipType + ", totalMonths=" + totalMonths
			+ ", amount=" + amount + ", userName=" + userName + ", registerdDate=" + registerdDate + ", expiryDate="
			+ expiryDate + ", userId=" + userId + "]";
}



public String[] getMembershipPlanDetails()
{
	try {
		Connection con = getConnect();
		Statement stmt = con.createStatement();
	String sql="select membership_type,total_months,amount from plan";
	//System.out.println(sql);
	ResultSet rs = stmt.executeQuery(sql);
	while(rs.next())
	{
		membershipType=rs.getString("membership_type");
		System.out.println(membershipType);
		totalMonths=rs.getInt("total_months");
		System.out.println(totalMonths);
		amount=rs.getInt("amount");
		System.out.println(amount);
		System.out.println();
	}
	int row=stmt.executeUpdate(sql);
	//System.out.println(row);
	con.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return null;
	}
public void updatePlan(int amount,int planId)
{
	try {
		Connection con = getConnect();
		Statement stmt = con.createStatement();
		String sql = "update plan set amount="+amount+" where plan_id="+planId;
		//System.out.println(sql);
		int row=stmt.executeUpdate(sql);
		System.out.println(row);
		System.out.println("Updated Success");
		System.out.println();
		con.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	

}


public void savePlan(MembershipPlanImpl mp) {
	try {
		Connection con = getConnect();
		Statement stmt = con.createStatement();
		String sql="insert into plan(plan_id,membership_type,total_months,amount)values(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		//System.out.println(sql);
	ps.setInt(1,planId);
	ps.setString(2,membershipType);
	ps.setInt(3,totalMonths);
	ps.setInt(4,amount);
	int row=ps.executeUpdate();
	System.out.println(row);
}
	catch(Exception e) {
		e.printStackTrace();
	}
}

public String[] getExpiryDateDetails() {
	
	try
	{
		Connection con = getConnect();
		Statement stmt = con.createStatement();
	String sql = "select p.user_name,p.registerd_date,m.expiry_date,l.membership_type from profiles p,plan l,membership_duration m where p.user_id=m.md_user_id and l.plan_id=m.md_plan_id";
			
	//System.out.println(sql);
	ResultSet rs = stmt.executeQuery(sql);
	while (rs.next())
	{
		userName=rs.getString("user_name");
		System.out.println(userName);
	    String registerdDate=rs.getString("registerd_date");
		System.out.println(registerdDate);
		String expiryDate=rs.getString("expiry_date");
		System.out.println(expiryDate);
		membershipType=rs.getString("membership_type");
		System.out.println(membershipType);
		System.out.println();
		
	}
	con.close();
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
}
}
/*
create table plan(
plan_id number,
membership_type varchar2(20)not null,
total_months number not null,
amount number not null,
constraint plan_id_pk primary key (plan_id),
constraint membership_type_cq check(membership_type in('platinum','gold','silver')),
constraint total_months_cq check(total_months in (12,6,3))
)*/