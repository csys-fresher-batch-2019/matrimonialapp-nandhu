package com.nandhu.dao;

import java.util.List;

import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.nandhu.impl.MembershipDurationImpl;

public interface MembershipDurationDAO {
	
	@SqlQuery("select * from membership_duration")
	public List<MembershipDurationImpl> getMembershipDetails();

	@SqlUpdate("insert into membership_duration(member_id,md_user_id,md_plan_id)values(m_id_sq.nextval,?,?)")
	public void saveMembershipDurationDetails(@BindBean MembershipDurationImpl md);
	
	@SqlUpdate("update membership_duration set expiry_date=add_months(expiry_date,?),md_plan_id=? where md_user_id=?")
	public String[] updateExpiryDate(@BindBean MembershipDurationImpl md);
	
	@SqlUpdate("delete from membership_duration where member_id=?")
	public void deleteDuration(int memberId);
	
	@SqlQuery("select user_name,((select expiry_date from membership_duration where md_user_id=?)-(select registerd_date from profiles where user_id=?))as remaining_days	from profiles where user_id=?")
	public List<MembershipDurationImpl> getRemainingDays(int userId);
	
	@SqlUpdate("update membership_duration set expiry_date=add_months((select registerd_date from profiles where user_id=?),?)where md_user_id=? and md_plan_id=?")
	public void calculateExpiryDuration(int userId,int mdplanId,int monthValidity);
}
