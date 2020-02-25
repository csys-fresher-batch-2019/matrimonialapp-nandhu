package com.nandhu.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nandhu.dao.MembershipDurationDAO;
import com.nandhu.util.ConnectionUtil;

public class MembershipDurationImpl implements MembershipDurationDAO {
	private static final Logger LOGGER = Logger.getInstance();
	private int memberId;
	private int mdUserId;
	private int mdPlanId;
	private String expiryDate;
	private int monthValidity;
	private int remainingDays;
	private String userName;
	private int UserId;
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getMdUserId() {
		return mdUserId;
	}

	public void setMdUserId(int mdUserId) {
		this.mdUserId = mdUserId;
	}

	public int getMdPlanId() {
		return mdPlanId;
	}

	public void setMdPlanId(int mdPlanId) {
		this.mdPlanId = mdPlanId;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getMonthValidity() {
		return monthValidity;
	}

	public void setMonthValidity(int monthValidity) {
		this.monthValidity = monthValidity;
	}

	public int getRemainingDays() {
		return remainingDays;
	}

	public void setRemainingDays(int remainingDays) {
		this.remainingDays = remainingDays;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	
	
	@Override
	public String toString() {
		return "MembershipDurationImpl [memberId=" + memberId + ", mdUserId=" + mdUserId + ", mdPlanId=" + mdPlanId
				+ ", expiryDate=" + expiryDate + ", monthValidity=" + monthValidity + ", remainingDays=" + remainingDays
				+ ", userName=" + userName + ", UserId=" + UserId + "]";
	}
	public String toString2() {
		return "MembershipDurationImpl [memberId=" + memberId + ", mdUserId=" + mdUserId + ", mdPlanId=" + mdPlanId
				+ ", expiryDate=" + expiryDate + "]";
	}
	public String toString1() {
		return "MembershipDurationImpl [ remainingDays=" + remainingDays
				+ ", userName=" + userName +"]";
	}
	public List<MembershipDurationImpl> getMembershipDetails() {
		List<MembershipDurationImpl> list = new ArrayList<MembershipDurationImpl>();
		String sql = "select * from membership_duration";
		try (Connection con = ConnectionUtil.getConnect();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				memberId = rs.getInt("member_id");
				mdUserId = rs.getInt("md_user_id");
				mdPlanId = rs.getInt("md_plan_id");
				String expiryDate = rs.getString("expiry_date");
				MembershipDurationImpl m=new MembershipDurationImpl();
				m.setMemberId(memberId);
				m.setMdUserId(mdUserId);
				m.setMdPlanId(mdPlanId);
				m.setExpiryDate(expiryDate);
				list.add(m);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void saveMembershipDurationDetails(MembershipDurationImpl md) {
		String sql = "insert into membership_duration(member_id,md_user_id,md_plan_id)values(memb_id_sq.nextval,?,?)";
		try (Connection con = ConnectionUtil.getConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, md.getMdUserId());
			ps.setInt(2, md.getMdPlanId());
			int row = ps.executeUpdate();
			Logger.debug(row);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteDuration(int memberId) {
		try (Connection con = ConnectionUtil.getConnect(); Statement stmt = con.createStatement()) {
			String sql = "delete from membership_duration where member_id=" + memberId;
			// LOGGER.debug(sql);
			int row = stmt.executeUpdate(sql);
			Logger.debug(row);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<MembershipDurationImpl> getRemainingDays(int userId) {
		List<MembershipDurationImpl> list = new ArrayList<MembershipDurationImpl>();
		String sql = "select user_name,((select expiry_date from membership_duration where md_user_id=" + userId
				+ ")-(sysdate))as remaining_days	from profiles where user_id=" + userId;
		try (Connection con = ConnectionUtil.getConnect();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				userName = rs.getString("user_name");
				remainingDays = rs.getInt("remaining_days");
				MembershipDurationImpl m=new MembershipDurationImpl();
m.setUserName(userName);
m.setRemainingDays(remainingDays);
list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public String[] updateExpiryDate(MembershipDurationImpl md) {
		try (Connection con = ConnectionUtil.getConnect(); Statement stmt = con.createStatement()) {
			String sql = "update membership_duration set expiry_date=add_months(expiry_date," + monthValidity
					+ "),md_plan_id=" + mdPlanId + " where md_user_id=" + mdUserId;
			int row = stmt.executeUpdate(sql);
			Logger.debug(row);
			Logger.debug(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void calculateExpiryDuration(int userId, int mdplanId, int monthValidity) {
		try (Connection con = ConnectionUtil.getConnect(); Statement stmt = con.createStatement()) {
			String sql = "update membership_duration set expiry_date=add_months((select registerd_date from profiles where user_id="
					+ userId + ")," + monthValidity + ")where md_user_id=" + userId + " and md_plan_id=" + mdplanId;
			int row = stmt.executeUpdate(sql);
			Logger.debug(row);
			Logger.debug(sql);
		} catch (Exception e) {
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