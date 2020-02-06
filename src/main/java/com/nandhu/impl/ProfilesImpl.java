package com.nandhu.impl;

import com.nandhu.dao.ProfilesInterfaceDAO;
import com.nandhu.impl.ProfilesImpl;
import com.nandhu.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProfilesImpl implements ProfilesInterfaceDAO {
	   private static final Logger LOGGER = Logger.getInstance();
	   public String userName;
	// DateFormat d= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	// Date now = new Date();
	// String dd=d.format(now);
	// String dob=dd;
	// String vDateMDY = dateFormatMDY.format(now);
	// String vDateMDYSQL = vDateMDY ;
	   public LocalDate dob;
	   public String gender;
	   private String religion;
	   private String caste;
	   private String country;
	   private String state;
	   private String city;
	   private Long mobNo;
	   private Long aadharNo;
	   private String mail;
	   private double height;
	   private String education;
	   private String registerdDate;
	   private String maritalSts;
	   private String occupation;
	   private int salary;
	   private String membershipType;
	   private String pass;
	   private int active=1;

	// display the total number of users
	public int getTotalCount() {
		String sql = "select count(*)as total_count from profiles where active="+active;

		try(Connection con = ConnectionUtil.getConnect();Statement stmt = con.createStatement();ResultSet rs = stmt.executeQuery(sql)) 
		{
			while (rs.next()) {
				int count = rs.getInt("total_count");
				Logger.debug("Total Count ="+count);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public String toString() {
		return "ProfilesImpl [userName=" + userName + ", dob=" + dob + ", gender=" + gender + ", religion=" + religion
				+ ", caste=" + caste + ", country=" + country + ", state=" + state + ", city=" + city + ", mobNo="
				+ mobNo + ", aadharNo=" + aadharNo + ", mail=" + mail + ", height=" + height + ", education="
				+ education + ", registerdDate=" + registerdDate + ", maritalSts=" + maritalSts + ", occupation="
				+ occupation + ", salary=" + salary + ", membershipType=" + membershipType + ", pass=" + pass
				+ ", active=" + active + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getMobNo() {
		return mobNo;
	}

	public void setMobNo(Long mobNo) {
		this.mobNo = mobNo;
	}

	public Long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(Long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getRegisterdDate() {
		return registerdDate;
	}

	public void setRegisterdDate(String registerdDate) {
		this.registerdDate = registerdDate;
	}

	public String getMaritalSts() {
		return maritalSts;
	}

	public void setMaritalSts(String maritalSts) {
		this.maritalSts = maritalSts;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	//Display user details for particular user
	public String[] getProfile(String userName) {
		String sql = "select * from profiles where user_name='"+userName+"' and active="+active;
		try(Connection con = ConnectionUtil.getConnect();Statement stmt = con.createStatement();ResultSet rs = stmt.executeQuery(sql)) {
		
			while (rs.next()) {
				String user_name = rs.getString("user_name");
				Logger.debug("Name= "+user_name);
				String dob = rs.getString("d_o_b");
				Logger.debug("DOB= "+dob);
				String gender = rs.getString("gender");
				Logger.debug("Gender= "+gender);
				String religion = rs.getString("religion");
				Logger.debug("Religion= "+religion);
				String country = rs.getString("country");
				Logger.debug("Country= "+country);
				String state= rs.getString("states");
				Logger.debug("State= "+state);
				String city = rs.getString("city");
				Logger.debug("City= "+city);
				Long aadharNo = rs.getLong("aadhar_no");
				Logger.debug("Aadhar No= "+aadharNo);
				String mail = rs.getString("mail_id");
				Logger.debug("MailId= "+mail);
				int height = rs.getInt("height");
				Logger.debug("Height= "+height);
				String education = rs.getString("education");
				Logger.debug("Education= "+education);
				String occupation = rs.getString("occupation");
				Logger.debug("Occupation= "+occupation);
				int salary = rs.getInt("salary");
				Logger.debug("Salary= "+salary);
				String marital_sts = rs.getString("marital_sts");
				Logger.debug("Marital Status= "+marital_sts);
				
				
				//file Write
				/*String result="Name= "+user_name+"\n"+"DOB= "+dob+"\n"+"Gender= "+gender+"\n"+"Religion= "+religion+"\n"+"Height= "+height+"\n"+"Education= "+education+"\n"+ "Occupation= "+occupation+"\n"+"Salary= "+salary+"\n"+"Marital Status="+marital_sts;  
				FileUtil.WriteToFile("ProfilePrint.txt", result);	
				LOGGER.debug("Write Successfully");
				
				//file Read
				String pro="ProfilePrint.txt";
				Path path=Paths.get(pro);
				
				byte[] bytes=Files.readAllBytes(path);
				String content=new String(bytes);
				LOGGER.debug(content);*/
				//LOGGER.debug("Read successfully");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	// Display all the bridegroom list
	public String[] getGenderProfile(String gender) {
		String sql = "select * from profiles where gender='" + gender + "'and active="+active;
		try(Connection con = ConnectionUtil.getConnect();Statement stmt = con.createStatement();ResultSet rs = stmt.executeQuery(sql)) {
						while (rs.next()) {
				String user_name = rs.getString("user_name");
				Logger.debug("Name= "+user_name);
				String dob = rs.getString("d_o_b");
				Logger.debug("DOB= "+dob);
				String gender1 = rs.getString("gender");
				Logger.debug("Gender= "+gender1);
				String religion = rs.getString("religion");
				Logger.debug("Religion= "+religion);
				String country = rs.getString("country");
				Logger.debug("Country= "+country);
				String state= rs.getString("states");
				Logger.debug("State= "+state);
				String city = rs.getString("city");
				Logger.debug("City= "+city);
				Long aadharNo = rs.getLong("aadhar_no");
				Logger.debug("Aadhar No= "+aadharNo);
				String mail = rs.getString("mail_id");
				Logger.debug("MailId= "+mail);
				int height = rs.getInt("height");
				Logger.debug("Height= "+height);
				String education = rs.getString("education");
				Logger.debug("Education= "+education);
				String occupation = rs.getString("occupation");
				Logger.debug("Occupation= "+occupation);
				int salary = rs.getInt("salary");
				Logger.debug("Salary= "+salary);
				String marital_sts = rs.getString("marital_sts");
				Logger.debug("Marital Status= "+marital_sts);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String[] getCityProfile(String gender,String city) {
		String sql = "select * from profiles where gender='" + gender + "' and city='"+city+"' and active="+active;

		try(Connection con = ConnectionUtil.getConnect();Statement stmt = con.createStatement();ResultSet rs = stmt.executeQuery(sql)){
		
			while (rs.next()) {
				String user_name = rs.getString("user_name");
				Logger.debug("Name= "+user_name);
				String dob = rs.getString("d_o_b");
				Logger.debug("DOB= "+dob);
				String gender1 = rs.getString("gender");
				Logger.debug("Gender= "+gender1);
				String religion = rs.getString("religion");
				Logger.debug("Religion= "+religion);
				String country = rs.getString("country");
				Logger.debug("Country= "+country);
				String state= rs.getString("states");
				Logger.debug("State= "+state);
				String city1 = rs.getString("city");
				Logger.debug("City= "+city1);
				Long aadharNo = rs.getLong("aadhar_no");
				Logger.debug("Aadhar No= "+aadharNo);
				String mail = rs.getString("mail_id");
				Logger.debug("MailId= "+mail);
				int height = rs.getInt("height");
				Logger.debug("Height= "+height);
				String education = rs.getString("education");
				Logger.debug("Education= "+education);
				String occupation = rs.getString("occupation");
				Logger.debug("Occupation= "+occupation);
				int salary = rs.getInt("salary");
				Logger.debug("Salary= "+salary);
				String marital_sts = rs.getString("marital_sts");
				Logger.debug("Marital Status= "+marital_sts);
				//Logger.debug();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// List all bridegroom with height specification
	public String[] getHeight(double height, String gender) {
		String sql = "select * from profiles where height >=" + height + " and gender='" + gender
				+ "'and active="+active;
		try(Connection con = ConnectionUtil.getConnect();Statement stmt = con.createStatement();ResultSet rs = stmt.executeQuery(sql)) {
						Logger.debug(sql);
						while (rs.next()) {
				String user_name = rs.getString("user_name");
				Logger.debug("Name= "+user_name);
				String dob = rs.getString("d_o_b");
				Logger.debug("DOB= "+dob);
				String gender1 = rs.getString("gender");
				Logger.debug("Gender= "+gender1);
				String religion = rs.getString("religion");
				Logger.debug("Religion= "+religion);
				String country = rs.getString("country");
				Logger.debug("Country= "+country);
				String state= rs.getString("states");
				Logger.debug("State= "+state);
				String city = rs.getString("city");
				Logger.debug("City= "+city);
				Long aadharNo = rs.getLong("aadhar_no");
				Logger.debug("Aadhar No= "+aadharNo);
				String mail = rs.getString("mail_id");
				Logger.debug("MailId= "+mail);
				int height1 = rs.getInt("height");
				Logger.debug("Height= "+height1);
				String education = rs.getString("education");
				Logger.debug("Education= "+education);
				String occupation = rs.getString("occupation");
				Logger.debug("Occupation= "+occupation);
				int salary = rs.getInt("salary");
				Logger.debug("Salary= "+salary);
				String marital_sts = rs.getString("marital_sts");
				Logger.debug("Marital Status= "+marital_sts);
				//Logger.debug();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Display all users name,education,occupation and their salary details
	public String[] getSalaryDetails(int salary,String gender) {
		String sql = "select * from profiles where salary>="+salary+" and gender='" + gender+"'and active="+active;
		try(Connection con = ConnectionUtil.getConnect();Statement stmt = con.createStatement();ResultSet rs = stmt.executeQuery(sql)){
						while (rs.next()) {
				String user_name = rs.getString("user_name");
				Logger.debug("Name="+user_name);
				String dob = rs.getString("d_o_b");
				Logger.debug("DOB= "+dob);
				String religion = rs.getString("religion");
				Logger.debug("Religion= "+religion);
				int height = rs.getInt("height");
				Logger.debug("Height= "+height);
				String education = rs.getString("education");
				Logger.debug("Education="+education);
				String occupation = rs.getString("occupation");
				Logger.debug("Occupation= "+occupation);
				int salary1 = rs.getInt("salary");
				Logger.debug("Salary= "+salary1);
				String marital_sts = rs.getString("marital_sts");
				Logger.debug("Marital Status= "+marital_sts);
				//Logger.debug();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// List the bridegroom list with the specific occupation

	public String[] getOccupation(String gender, String occupation) {

		String sql = "select * from profiles where gender='" + gender
				+ "' and occupation ='" + occupation + "' and active="+active;
		try(Connection con = ConnectionUtil.getConnect();Statement stmt = con.createStatement();ResultSet rs = stmt.executeQuery(sql)){
			
			while (rs.next()) {
				String user_name = rs.getString("user_name");
				Logger.debug("Name= "+user_name);
				String dob = rs.getString("d_o_b");
				Logger.debug("DOB= "+dob);
				String gender1 = rs.getString("gender");
				Logger.debug("Gender= "+gender1);
				String religion = rs.getString("religion");
				Logger.debug("Religion= "+religion);
				String country = rs.getString("country");
				Logger.debug("Country= "+country);
				String state= rs.getString("states");
				Logger.debug("State= "+state);
				String city = rs.getString("city");
				Logger.debug("City= "+city);
				Long aadharNo = rs.getLong("aadhar_no");
				Logger.debug("Aadhar No= "+aadharNo);
				String mail = rs.getString("mail_id");
				Logger.debug("MailId= "+mail);
				int height = rs.getInt("height");
				Logger.debug("Height= "+height);
				String education = rs.getString("education");
				Logger.debug("Education= "+education);
				String occupation1 = rs.getString("occupation");
				Logger.debug("Occupation= "+occupation1);
				int salary = rs.getInt("salary");
				Logger.debug("Salary= "+salary);
				String marital_sts = rs.getString("marital_sts");
				Logger.debug("Marital Status= "+marital_sts);
				//Logger.debug();
			}
								} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String[] getNotInOccupation(String gender, String occupation) {
		String sql = "select * from profiles where gender='" + gender
				+ "' and occupation not in '" + occupation + "' and active="+active;
		try(Connection con = ConnectionUtil.getConnect();Statement stmt = con.createStatement();ResultSet rs = stmt.executeQuery(sql)){
										while (rs.next()) {
				String user_name = rs.getString("user_name");
				Logger.debug("Name= "+user_name);
				String dob = rs.getString("d_o_b");
				Logger.debug("DOB= "+dob);
				String gender1 = rs.getString("gender");
				Logger.debug("Gender= "+gender1);
				String religion = rs.getString("religion");
				Logger.debug("Religion= "+religion);
				String country = rs.getString("country");
				Logger.debug("Country= "+country);
				String state= rs.getString("states");
				Logger.debug("State= "+state);
				String city = rs.getString("city");
				Logger.debug("City= "+city);
				Long aadharNo = rs.getLong("aadhar_no");
				Logger.debug("Aadhar No= "+aadharNo);
				String mail = rs.getString("mail_id");
				Logger.debug("MailId= "+mail);
				int height = rs.getInt("height");
				Logger.debug("Height= "+height);
				String education = rs.getString("education");
				Logger.debug("Education= "+education);
				String occupation1 = rs.getString("occupation");
				Logger.debug("Occupation= "+occupation1);
				int salary = rs.getInt("salary");
				Logger.debug("Salary= "+salary);
				String marital_sts = rs.getString("marital_sts");
				Logger.debug("Marital Status= "+marital_sts);
							}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// list all the users with their age and marital status

	public String[] getAgeDetails() {
		String sql = "select user_name,extract(year from sysdate)-extract(year from d_o_b)as Age,marital_sts from profiles";

		try(Connection con = ConnectionUtil.getConnect();Statement stmt = con.createStatement();ResultSet rs = stmt.executeQuery(sql)){
						while (rs.next()) {
				String user_name = rs.getString("user_name");
				Logger.debug("Name="+user_name);
				int age1 = rs.getInt("Age");
				Logger.debug("Age="+age1);
				String marital_sts = rs.getString("marital_sts");
				Logger.debug("Marital Status= "+marital_sts);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void delete(int number) {
		try(Connection con = ConnectionUtil.getConnect();Statement stmt = con.createStatement()){
						String sql = "delete from profiles where user_id=" + number;
				int row = stmt.executeUpdate(sql);
			Logger.debug(row);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void save(ProfilesImpl p) {
		try(Connection con = ConnectionUtil.getConnect();Statement stmt = con.createStatement()) {
					String sql = "insert into profiles(user_id,user_name,d_o_b,gender,religion,caste,country,states,city,mob_no,aadhar_no,mail_id,height,education,occupation,salary,marital_sts,membership_type,pass)"
					+ "values(user_id_sq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1,p.getUserName());
					ps.setDate(2, java.sql.Date.valueOf(p.getDob()));
			ps.setString(3, p.getGender());
			ps.setString(4,p.getReligion());
			ps.setString(5,p.getCaste());
			ps.setString(6,p.getCountry());
			ps.setString(7,p.getState());
			ps.setString(8,p.getCity());
			ps.setLong(9,p.getMobNo());
			ps.setLong(10,p.getAadharNo());
			ps.setString(11, p.getMail());
			ps.setDouble(12, p.getHeight());
			ps.setString(13,p.getEducation());
			ps.setString(14, p.getOccupation());
			ps.setInt(15, p.getSalary());
			ps.setString(16,p.getMaritalSts());
			ps.setString(17, p.getMembershipType());
			ps.setString(18, p.getPass());
			int row = ps.executeUpdate();
			Logger.debug(row+" row inserted");
				}	
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateProfiles(String occupation,int salary,String userName,Long mobNo)
	{
			try(Connection con = ConnectionUtil.getConnect();Statement stmt = con.createStatement()) {
			
			String sql = "update profiles set occupation='"+occupation+"',salary="+salary+" where user_name='"+userName+"' and mob_no="+mobNo;
			int row=stmt.executeUpdate(sql);
			Logger.debug(row);
			Logger.debug("Updated Success");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			}
	public void updateActive(int userId, int active) {
		try(Connection con = ConnectionUtil.getConnect();Statement stmt = con.createStatement())
		{
			String sql = "update profiles  set active = "+active+" where user_id="+userId;
			//LOGGER.debug(sql);
			int row=stmt.executeUpdate(sql);
			Logger.debug(row);
			Logger.debug("Updated Success");
					}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public String[] getReligion(String gender,String religion) {
		String sql = "select * from profiles where gender='"+gender+"' and religion='"+religion+"' and active="+active;

		try(Connection con = ConnectionUtil.getConnect();Statement stmt = con.createStatement();ResultSet rs = stmt.executeQuery(sql))
		{
						while (rs.next()) {
				String user_name = rs.getString("user_name");
				Logger.debug("Name= "+user_name);
				String dob = rs.getString("d_o_b");
				Logger.debug("DOB= "+dob);
				String gender1 = rs.getString("gender");
				Logger.debug("Gender= "+gender1);
				String religion1 = rs.getString("religion");
				Logger.debug("Religion= "+religion1);
				String country = rs.getString("country");
				Logger.debug("Country= "+country);
				String state= rs.getString("states");
				Logger.debug("State= "+state);
				String city = rs.getString("city");
				Logger.debug("City= "+city);
				Long aadharNo = rs.getLong("aadhar_no");
				Logger.debug("Aadhar No= "+aadharNo);
				String mail = rs.getString("mail_id");
				Logger.debug("MailId= "+mail);
				int height = rs.getInt("height");
				Logger.debug("Height= "+height);
				String education = rs.getString("education");
				Logger.debug("Education= "+education);
				String occupation = rs.getString("occupation");
				Logger.debug("Occupation= "+occupation);
				int salary = rs.getInt("salary");
				Logger.debug("Salary= "+salary);
				String marital_sts = rs.getString("marital_sts");
				Logger.debug("Marital Status= "+marital_sts);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void userLogin(String userEmail, String userpassword) {
		String sql = "select mail_id,pass from profiles where mail_id='"+userEmail+"' and pass='"+userpassword+"'";
		try(Connection con = ConnectionUtil.getConnect();Statement stmt = con.createStatement();ResultSet rs = stmt.executeQuery(sql))
		{
			if (rs.next()) {
				String mail = rs.getString("mail_id");
				//LOGGER.debug("Name="+mail);
				String password = rs.getString("pass");
				//LOGGER.debug("Age="+password);
				if(mail.equals(userEmail)&& password.equals(userpassword))
						Logger.debug("Logged In...");
			}	else {
			Logger.debug("Login Failed...");}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void changePassword(String userEmail, String userpassword) {
		String sql = "update profiles set pass='"+userpassword+"' where mail_id='"+userEmail+"'";
		try(Connection con = ConnectionUtil.getConnect();Statement stmt = con.createStatement();ResultSet rs = stmt.executeQuery(sql))
		{
			int row=stmt.executeUpdate(sql);
			Logger.debug(row);
			Logger.debug("Updated Success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

/*
 * create table profiles ( user_id number, user_name varchar2(50) not null,
 * d_o_b date not null, gender char(1)not null, religion varchar2(50)not null,
 * caste varchar2(50), country varchar2(50)not null, mob_no number not null,
 * height number , education varchar2(30), constraint user_id_pk primary
 * key(user_id), constraint gender_cq check(gender in ('M','F')) ); Query alter
 * table profiles add( registerd_date date default sysdate, marital_sts
 * varchar2(20)not null, occupation varchar2(20), salary number, constraint
 * marital_sts_cq check(marital_sts in
 * ('unmarried','widow','widower','divorced')) );
 */