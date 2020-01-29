package com.chainsys.matrimonialmanagement.duration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.chainsys.matrimonialmanagement.profiles.ProfilesImpl;

public class MembershipDurationImpl implements MembershipDurationDAO {

	int memberId;
	int mdUserId;
	int mdPlanId;
	String expiryDate;
	int monthValidity;
	int remainingDays;
	String userName;
	int UserId;

	@Override
	public String toString() {
		return "MembershipDuration [member_id=" + memberId + ", md_user_id=" + mdUserId + ", md_plan_id=" + mdPlanId
				+ ", expiry_date=" + expiryDate + "]";
	}

	public static Connection getConnect() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		//System.out.println(con);
		return con;
	}

	public String[] getMembershipDetails() {
		try {
			Connection con = getConnect();
			Statement stmt = con.createStatement();
			String sql = "select * from membership_duration ";
			//System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				memberId = rs.getInt("member_id");
				System.out.println("Member ID="+memberId);
				mdUserId = rs.getInt("md_user_id");
				System.out.println("User ID="+mdUserId);
				mdPlanId = rs.getInt("md_plan_id");
				System.out.println("Plan ID="+mdPlanId);
				String expiryDate = rs.getString("expiry_date");
				System.out.println("Expiry Date="+expiryDate);
				System.out.println();
			}con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void saveMembershipDurationDetails(MembershipDurationImpl md) {
		try {
			Connection con = getConnect();
			Statement stmt = con.createStatement();
			String sql = "insert into membership_duration(member_id,md_user_id,md_plan_id)values(m_id_sq.nextval,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			//.out.println(sql);
			// ps.setInt(1, memberId);
			ps.setInt(1, mdUserId);
			ps.setInt(2, mdPlanId);
			int row = ps.executeUpdate();
			System.out.println(row);
			con.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	public void deleteDuration(int memberId) {
		try {
			Connection con = getConnect();
			Statement stmt = con.createStatement();
			String sql = "delete from membership_duration where member_id=" + memberId;
			//System.out.println(sql);
			int row = stmt.executeUpdate(sql);
			System.out.println(row);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String[] getRemainingDays(int userId) {
		try {
			Connection con = getConnect();
			Statement stmt = con.createStatement();
			String sql = "select user_name,((select expiry_date from membership_duration where md_user_id=" + userId
					+ ")-(select registerd_date from profiles where user_id=" + userId
					+ "))as remaining_days	from profiles where user_id=" + userId;
			//System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				userName = rs.getString("user_name");
				System.out.println("User name="+userName);
				remainingDays = rs.getInt("remaining_days");
				System.out.println("Remaining Days="+remainingDays);
			
			}	con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public void calculateExpiryDuration(MembershipDurationImpl md) {
		try {
			Connection con = getConnect();
			Statement stmt = con.createStatement();
			String sql = "update membership_duration set expiry_date=add_months((select registerd_date from profiles where user_id="
					+ mdUserId + ")," + monthValidity + ")where md_user_id=" + mdUserId + " and md_plan_id=" + mdPlanId;
			//update  membership_duration set expiry_date=add_months((select registerd_date from profiles where user_id=27),3)where md_user_id=27 and md_plan_id=3 ;

			//System.out.println(sql);
			int row = stmt.executeUpdate(sql);
			System.out.println(row);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String[] updateExpiryDate(MembershipDurationImpl md) {
		try {
			Connection con = getConnect();
			Statement stmt = con.createStatement();
			String sql = "update membership_duration set expiry_date=add_months(expiry_date," + monthValidity
					+ "),md_plan_id="+mdPlanId+" where md_user_id="+mdUserId;
			//*******************
			//update membership_duration set expiry_date=add_months(expiry_date,12)
			//where md_user_id=101; 
			// PreparedStatement ps=con.prepareStatement(sql);
			//System.out.println(sql);
			int row = stmt.executeUpdate(sql);
			System.out.println(row);
			con.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void calculateExpiryDuration(int userId, int mdplanId, int monthValidity) {
		try {
			Connection con = getConnect();
			Statement stmt = con.createStatement();
			String sql = "update membership_duration set expiry_date=add_months((select registerd_date from profiles where user_id="
					+ userId + ")," + monthValidity + ")where md_user_id=" + userId + " and md_plan_id=" + mdplanId;
			//update  membership_duration set expiry_date=add_months((select registerd_date from profiles where user_id=27),3)where md_user_id=27 and md_plan_id=3 ;

			//System.out.println(sql);
			int row = stmt.executeUpdate(sql);
			System.out.println(row);
		
		}	 
		catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
/*
 * create table membership_duration( member_id number, md_user_id number,
 * md_plan_id number, expiry_date date, constraint member_id_pk primary
 * key(member_id), constraint md_user_id_fk foreign key(md_user_id)references
 * profiles(user_id), constraint md_plan_id_fk foreign key(md_plan_id)references
 * plan(plan_id) );
 * 
 */