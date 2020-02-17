package com.nandhu.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.nandhu.dao.MembershipPlanInterfaceDAO;
import com.nandhu.util.ConnectionUtil;

public class MembershipPlanImpl implements MembershipPlanInterfaceDAO {
	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getInstance();
	private int planId;
	private String membershipType;
	private int totalMonths;
	private int amount;
	private String userName;
	private Date registerdDate;
	private Date expiryDate;
	private int userId;

	@Override
	public String toString() {
		return "MembershipPlan [planId=" + planId + ", membershipType=" + membershipType + ", totalMonths="
				+ totalMonths + ", amount=" + amount + ", userName=" + userName + ", registerdDate=" + registerdDate
				+ ", expiryDate=" + expiryDate + ", userId=" + userId + "]";
	}

	public String toString1() {
		return "MembershipPlan [planId=" + planId + ",membershipType=" + membershipType + ", totalMonths=" + totalMonths + ", amount="
				+ amount + "]";
	}

	public String toString2() {
		return "MembershipPlan [membershipType=" + membershipType + ",userName=" + userName + ", registerdDate=" + registerdDate
				+ ", expiryDate=" + expiryDate + "]";
	}
	public List<MembershipPlanImpl> getMembershipPlanDetails() {
		List<MembershipPlanImpl> list = new ArrayList<MembershipPlanImpl>();
		String sql = "select * from plan";
		try (Connection con = ConnectionUtil.getConnect();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				planId=rs.getInt("plan_id");
				membershipType = rs.getString("membership_type");
				totalMonths = rs.getInt("total_months");
				amount = rs.getInt("amount");
				MembershipPlanImpl m = new MembershipPlanImpl();
				m.setPlanId(planId);
				m.setMembershipType(membershipType);
				m.setTotalMonths(totalMonths);
				m.setAmount(amount);
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void updatePlan(int amount, int planId) {
		try (Connection con = ConnectionUtil.getConnect(); Statement stmt = con.createStatement()) {
			String sql = "update plan set amount=" + amount + " where plan_id=" + planId;
			int row = stmt.executeUpdate(sql);
			Logger.debug(row);
			Logger.debug("Updated Success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public int getTotalMonths() {
		return totalMonths;
	}

	public void setTotalMonths(int totalMonths) {
		this.totalMonths = totalMonths;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getRegisterdDate() {
		return registerdDate;
	}

	public void setRegisterdDate(Date registerdDate) {
		this.registerdDate = registerdDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	public List<MembershipPlanImpl> getExpiryDateDetails() {
		List<MembershipPlanImpl> list = new ArrayList<MembershipPlanImpl>();

		String sql = "select p.user_name,p.registerd_date,m.expiry_date,l.membership_type from profiles p,plan l,membership_duration m where p.user_id=m.md_user_id and l.plan_id=m.md_plan_id";
		try (Connection con = ConnectionUtil.getConnect();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				userName = rs.getString("user_name");
				registerdDate = rs.getDate("registerd_date");
				expiryDate = rs.getDate("expiry_date");
				membershipType = rs.getString("membership_type");
				MembershipPlanImpl p = new MembershipPlanImpl();
				p.setUserName(userName);
				p.setRegisterdDate(registerdDate);
				p.setExpiryDate(expiryDate);
				p.setMembershipType(membershipType);
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
/*
 * create table plan( plan_id number, membership_type varchar2(20)not null,
 * total_months number not null, amount number not null, constraint plan_id_pk
 * primary key (plan_id), constraint membership_type_cq check(membership_type
 * in('platinum','gold','silver')), constraint total_months_cq
 * check(total_months in (12,6,3)) )
 */