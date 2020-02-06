package com.nandhu.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
		return "MembershipDuration [member_id=" + memberId + ", md_user_id=" + mdUserId + ", md_plan_id=" + mdPlanId
				+ ", expiry_date=" + expiryDate + "]";
	}

	public String[] getMembershipDetails() {
		String sql = "select * from membership_duration ";
		try (Connection con = ConnectionUtil.getConnect();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				memberId = rs.getInt("member_id");
				Logger.debug("Member ID=" + memberId);
				mdUserId = rs.getInt("md_user_id");
				Logger.debug("User ID=" + mdUserId);
				mdPlanId = rs.getInt("md_plan_id");
				Logger.debug("Plan ID=" + mdPlanId);
				String expiryDate = rs.getString("expiry_date");
				Logger.debug("Expiry Date=\n" + expiryDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void saveMembershipDurationDetails(MembershipDurationImpl md) {
		String sql = "insert into membership_duration(member_id,md_user_id,md_plan_id)values(m_id_sq.nextval,?,?)";
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

	public String[] getRemainingDays(int userId) {
		String sql = "select user_name,((select expiry_date from membership_duration where md_user_id=" + userId
				+ ")-(select registerd_date from profiles where user_id=" + userId
				+ "))as remaining_days	from profiles where user_id=" + userId;
		try (Connection con = ConnectionUtil.getConnect();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				userName = rs.getString("user_name");
				Logger.debug("User name=" + userName);
				remainingDays = rs.getInt("remaining_days");
				Logger.debug("Remaining Days=" + remainingDays);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void calculateExpiryDuration(MembershipDurationImpl md) {
		try (Connection con = ConnectionUtil.getConnect(); Statement stmt = con.createStatement()) {
			String sql = "update membership_duration set expiry_date=add_months((select registerd_date from profiles where user_id="
					+ mdUserId + ")," + monthValidity + ")where md_user_id=" + mdUserId + " and md_plan_id=" + mdPlanId;
			int row = stmt.executeUpdate(sql);
			Logger.debug(row);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String[] updateExpiryDate(MembershipDurationImpl md) {
		try (Connection con = ConnectionUtil.getConnect(); Statement stmt = con.createStatement()) {
			String sql = "update membership_duration set expiry_date=add_months(expiry_date," + monthValidity
					+ "),md_plan_id=" + mdPlanId + " where md_user_id=" + mdUserId;
			int row = stmt.executeUpdate(sql);
			Logger.debug(row);
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