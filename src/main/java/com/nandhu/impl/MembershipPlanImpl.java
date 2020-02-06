package com.nandhu.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

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
	private LocalDate registerdDate;
	private LocalDate expiryDate;
	private int userId;

	@Override
	public String toString() {
		return "MembershipPlan [planId=" + planId + ", membershipType=" + membershipType + ", totalMonths="
				+ totalMonths + ", amount=" + amount + ", userName=" + userName + ", registerdDate=" + registerdDate
				+ ", expiryDate=" + expiryDate + ", userId=" + userId + "]";
	}

	public String[] getMembershipPlanDetails() {
		String sql = "select membership_type,total_months,amount from plan";
		try (Connection con = ConnectionUtil.getConnect(); Statement stmt = con.createStatement();ResultSet rs = stmt.executeQuery(sql)) {
						while (rs.next()) {
				membershipType = rs.getString("membership_type");
				Logger.debug(membershipType);
				totalMonths = rs.getInt("total_months");
				Logger.debug(totalMonths);
				amount = rs.getInt("amount");
				Logger.debug("Amount=\n" + amount);
				// Logger.debug();
			}
			@SuppressWarnings("unused")
			int row = stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updatePlan(int amount, int planId) {
		try (Connection con = ConnectionUtil.getConnect(); Statement stmt = con.createStatement()) {
			String sql = "update plan set amount=" + amount + " where plan_id=" + planId;
			// LOGGER.debug(sql);
			int row = stmt.executeUpdate(sql);
			Logger.debug(row);
			Logger.debug("Updated Success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String[] getExpiryDateDetails() {
		String sql = "select p.user_name,p.registerd_date,m.expiry_date,l.membership_type from profiles p,plan l,membership_duration m where p.user_id=m.md_user_id and l.plan_id=m.md_plan_id";
		try (Connection con = ConnectionUtil.getConnect(); Statement stmt = con.createStatement();ResultSet rs = stmt.executeQuery(sql)) {
						while (rs.next()) {
				userName = rs.getString("user_name");
				Logger.debug(userName);
				String registerdDate = rs.getString("registerd_date");
				Logger.debug(registerdDate);
				String expiryDate = rs.getString("expiry_date");
				Logger.debug(expiryDate);
				membershipType = rs.getString("membership_type");
				Logger.debug(membershipType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
/*
 * create table plan( plan_id number, membership_type varchar2(20)not null,
 * total_months number not null, amount number not null, constraint plan_id_pk
 * primary key (plan_id), constraint membership_type_cq check(membership_type
 * in('platinum','gold','silver')), constraint total_months_cq
 * check(total_months in (12,6,3)) )
 */