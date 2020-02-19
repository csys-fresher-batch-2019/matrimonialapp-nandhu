package com.nandhu.impl;

import com.nandhu.dao.ProfilesInterfaceDAO;
import com.nandhu.impl.ProfilesImpl;
import com.nandhu.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProfilesImpl implements ProfilesInterfaceDAO {
	private static final Logger LOGGER = Logger.getInstance();
	public int userId;
	public int age;
	public String userName;
	public Date dob;
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
	private int active = 1;
    private String pic;
	// display the total number of users
	public int getTotalCount() {
		String sql = "select count(*)as total_count from profiles where active=" + active;

		try (Connection con = ConnectionUtil.getConnect();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				int count = rs.getInt("total_count");
				Logger.debug("Total Count =" + count);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public String toString1() {
		return "ProfilesImpl [userName=" + userName + ", dob=" + dob + ", gender=" + gender + ", religion=" + religion
				+ ", caste=" + caste + ", country=" + country + ", state=" + state + ", city=" + city + ", mobNo="
				+ mobNo + ", aadharNo=" + aadharNo + ", mail=" + mail + ", height=" + height + ", education="
				+ education + ", registerdDate=" + registerdDate + ", maritalSts=" + maritalSts + ", occupation="
				+ occupation + ", salary=" + salary + ", pic=" + pic + "]";
	}

	public String toString3() {
		return "ProfilesImpl [  userName=" + userName + ",age=" + age + ", dob=" + dob
				+ ", gender=" + gender + ", religion=" + religion + ", caste=" + caste + ", country=" + country
				+ ", state=" + state + ", city=" + city + ", mobNo=" + mobNo + ", aadharNo=" + aadharNo + ", mail="
				+ mail + ", height=" + height + ", education=" + education + ", registerdDate=" + registerdDate
				+ ", maritalSts=" + maritalSts + ", occupation=" + occupation + ", salary=" + salary
				+ ", membershipType=" + membershipType + ", pic=" + pic + "]";
	}

	

	@Override
	public String toString() {
		return "ProfilesImpl [userId=" + userId + ", userName=" + userName + ", dob=" + dob
				+ ", gender=" + gender + ", religion=" + religion + ", caste=" + caste + ", country=" + country
				+ ", state=" + state + ", city=" + city + ", mobNo=" + mobNo + ", aadharNo=" + aadharNo + ", mail="
				+ mail + ", height=" + height + ", education=" + education + ", registerdDate=" + registerdDate
				+ ", maritalSts=" + maritalSts + ", occupation=" + occupation + ", salary=" + salary
				+ ", membershipType=" + membershipType + ",active=" + active + ",pass="+pass+", pic=" + pic + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob2) {
		this.dob = dob2;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// Display user details for particular user
	public List<ProfilesImpl> getProfile(String userName) {
		List<ProfilesImpl> list = new ArrayList<ProfilesImpl>();
		String sql = "select * from profiles where lower(user_name)=lower('" + userName + "') and active=" + active;
		try (Connection con = ConnectionUtil.getConnect();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				String userName1 = rs.getString("user_name");
				Date dob = rs.getDate("d_o_b");
				String gender = rs.getString("gender");
				String religion = rs.getString("religion");
				String caste = rs.getString("caste");
				String country = rs.getString("country");
				String state = rs.getString("states");
				String city = rs.getString("city");
				Long mobNo = rs.getLong("mob_no");
				Long aadharNo = rs.getLong("aadhar_no");
				String mail = rs.getString("mail_id");
				int height = rs.getInt("height");
				String education = rs.getString("education");
				String occupation = rs.getString("occupation");
				int salary = rs.getInt("salary");
				String marital_sts = rs.getString("marital_sts");
				String pic=rs.getString("pic");
				ProfilesImpl p = new ProfilesImpl();
				p.setUserName(userName1);
				p.setDob(dob);
				p.setGender(gender);
				p.setReligion(religion);
				p.setCaste(caste);
				p.setCountry(country);
				p.setState(state);
				p.setCity(city);
				p.setMobNo(mobNo);
				p.setAadharNo(aadharNo);
				p.setMail(mail);
				p.setHeight(height);
				p.setEducation(education);
				p.setOccupation(occupation);
				p.setSalary(salary);
				p.setMaritalSts(marital_sts);
				p.setPic(pic);
				list.add(p);

				// file Write
				/*
				 * String result="Name= "+user_name+"\n"+"DOB= "+dob+"\n"+"Gender= "+gender+
				 * "\n"+"Religion= "+religion+"\n"+"Height= "+height+"\n"+"Education= "
				 * +education+"\n"+
				 * "Occupation= "+occupation+"\n"+"Salary= "+salary+"\n"+"Marital Status="
				 * +marital_sts; FileUtil.WriteToFile("ProfilePrint.txt", result);
				 * LOGGER.debug("Write Successfully");
				 * 
				 * //file Read String pro="ProfilePrint.txt"; Path path=Paths.get(pro);
				 * 
				 * byte[] bytes=Files.readAllBytes(path); String content=new String(bytes);
				 * LOGGER.debug(content);
				 */
				// LOGGER.debug("Read successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<ProfilesImpl> getGenderProfile(String gender) {
		List<ProfilesImpl> list = new ArrayList<ProfilesImpl>();
		String sql = "select * from profiles where gender='" + gender + "'and active=" + active;
		try (Connection con = ConnectionUtil.getConnect();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String user_name = rs.getString("user_name");
				Date dob = rs.getDate("d_o_b");
				String gender1 = rs.getString("gender");
				String religion = rs.getString("religion");
				String country = rs.getString("country");
				String state = rs.getString("states");
				String city = rs.getString("city");
				Long aadharNo = rs.getLong("aadhar_no");
				String mail = rs.getString("mail_id");
				int height = rs.getInt("height");
				String education = rs.getString("education");
				String occupation = rs.getString("occupation");
				int salary = rs.getInt("salary");
				String marital_sts = rs.getString("marital_sts");
				  String pic=rs.getString("pic");
					Long mobNo=rs.getLong("mob_no");
					String caste=rs.getString("caste");
				ProfilesImpl p = new ProfilesImpl();
				p.setUserName(user_name);
				p.setDob(dob);
				p.setGender(gender1);
				p.setReligion(religion);
				p.setCountry(country);
				p.setState(state);
				p.setCity(city);
				p.setAadharNo(aadharNo);
				p.setMail(mail);
				p.setHeight(height);
				p.setEducation(education);
				p.setOccupation(occupation);
				p.setSalary(salary);
				p.setMaritalSts(marital_sts);
				p.setCaste(caste);
				p.setPic(pic);
				p.setMobNo(mobNo);
				list.add(p);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<ProfilesImpl> getCityProfile(String gender, String city) {
		List<ProfilesImpl> list = new ArrayList<ProfilesImpl>();
		String sql = "select * from profiles where gender='" + gender + "' and lower(city)=lower('" + city + "') and active="
				+ active;

		try (Connection con = ConnectionUtil.getConnect();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				String pic=rs.getString("pic");
				String user_name = rs.getString("user_name");
				Date dob = rs.getDate("d_o_b");
				String gender1 = rs.getString("gender");
				String religion = rs.getString("religion");
				String caste = rs.getString("caste");
				String country = rs.getString("country");
				String state = rs.getString("states");
				String city1 = rs.getString("city");
				Long mobNo = rs.getLong("mob_no");
				Long aadharNo = rs.getLong("aadhar_no");
				String mail = rs.getString("mail_id");
				int height = rs.getInt("height");
				String education = rs.getString("education");
				String occupation = rs.getString("occupation");
				int salary = rs.getInt("salary");
				String marital_sts = rs.getString("marital_sts");
				String pic1=rs.getString("pic");
				ProfilesImpl p = new ProfilesImpl();
				p.setUserName(user_name);
				p.setPic(pic1);
				p.setDob(dob);
				p.setGender(gender1);
				p.setReligion(religion);
				p.setCaste(caste);
				p.setCountry(country);
				p.setState(state);
				p.setCity(city1);
				p.setMobNo(mobNo);
				p.setAadharNo(aadharNo);
				p.setMail(mail);
				p.setHeight(height);
				p.setEducation(education);
				p.setOccupation(occupation);
				p.setSalary(salary);
				p.setMaritalSts(marital_sts);
				p.setPic(pic1);
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<ProfilesImpl> getHeight(double height, String gender) {
		List<ProfilesImpl> list = new ArrayList<ProfilesImpl>();
		String sql = "select * from profiles where height >=" + height + " and gender='" + gender + "'and active="
				+ active;
		try (Connection con = ConnectionUtil.getConnect();
				Statement stmt = con.createStatement())
				{
			try(ResultSet rs = stmt.executeQuery(sql))
			{
			while (rs.next()) {
				String user_name = rs.getString("user_name");
				Date dob = rs.getDate("d_o_b");
				String gender1 = rs.getString("gender");
				String religion = rs.getString("religion");
				String country = rs.getString("country");
				String state = rs.getString("states");
				String city = rs.getString("city");
				Long aadharNo = rs.getLong("aadhar_no");
				String mail = rs.getString("mail_id");
				int height1 = rs.getInt("height");
				String education = rs.getString("education");
				String occupation = rs.getString("occupation");
				int salary = rs.getInt("salary");
				String marital_sts = rs.getString("marital_sts");
				 String pic=rs.getString("pic");
					Long mobNo=rs.getLong("mob_no");
					String caste=rs.getString("caste");
				ProfilesImpl p = new ProfilesImpl();
				p.setCaste(caste);
				p.setPic(pic);
				p.setMobNo(mobNo);
				p.setUserName(user_name);
				p.setDob(dob);
				p.setGender(gender1);
				p.setReligion(religion);
				p.setCountry(country);
				p.setState(state);
				p.setCity(city);
				p.setAadharNo(aadharNo);
				p.setMail(mail);
				p.setHeight(height1);
				p.setEducation(education);
				p.setOccupation(occupation);
				p.setSalary(salary);
				p.setMaritalSts(marital_sts);
				list.add(p);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				}
		catch(Exception e)
		{
			
		}
		return list;
	}

	public List<ProfilesImpl> getSalaryDetails(int salary, String gender) {
		List<ProfilesImpl> list = new ArrayList<ProfilesImpl>();
		String sql = "select * from profiles where salary>=" + salary + " and gender='" + gender + "'and active="
				+ active;
		try (Connection con = ConnectionUtil.getConnect();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String user_name = rs.getString("user_name");
				Date dob = rs.getDate("d_o_b");
				String gender1 = rs.getString("gender");
				String religion = rs.getString("religion");
				String country = rs.getString("country");
				String state = rs.getString("states");
				String city = rs.getString("city");
				Long aadharNo = rs.getLong("aadhar_no");
				String mail = rs.getString("mail_id");
				int height1 = rs.getInt("height");
				String education = rs.getString("education");
				String occupation = rs.getString("occupation");
				int salary1 = rs.getInt("salary");
				String marital_sts = rs.getString("marital_sts");
				   String pic=rs.getString("pic");
					Long mobNo=rs.getLong("mob_no");
					String caste=rs.getString("caste");
				ProfilesImpl p = new ProfilesImpl();
				p.setCaste(caste);
				p.setPic(pic);
				p.setMobNo(mobNo);
				p.setUserName(user_name);
				p.setDob(dob);
				p.setGender(gender1);
				p.setReligion(religion);
				p.setCountry(country);
				p.setState(state);
				p.setCity(city);
				p.setAadharNo(aadharNo);
				p.setMail(mail);
				p.setHeight(height1);
				p.setEducation(education);
				p.setOccupation(occupation);
				p.setSalary(salary1);
				p.setMaritalSts(marital_sts);
				list.add(p);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	// List the bridegroom list with the specific occupation

	public List<ProfilesImpl> getOccupation(String gender, String occupation) {
		List<ProfilesImpl> list = new ArrayList<ProfilesImpl>();
		String sql = "select * from profiles where gender='" + gender + "' and lower(occupation) =lower('" + occupation
				+ "') and active=" + active;
		try (Connection con = ConnectionUtil.getConnect();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String user_name = rs.getString("user_name");
				Date dob = rs.getDate("d_o_b");
				String gender1 = rs.getString("gender");
				String religion = rs.getString("religion");
				String caste = rs.getString("caste");
				String country = rs.getString("country");
				String state = rs.getString("states");
				String city = rs.getString("city");
				Long mobNo = rs.getLong("mob_no");
				String pic= rs.getString("pic");
				Long aadharNo = rs.getLong("aadhar_no");
				String mail = rs.getString("mail_id");
				int height1 = rs.getInt("height");
				String education = rs.getString("education");
				String occupation1 = rs.getString("occupation");
				int salary1 = rs.getInt("salary");
				String marital_sts = rs.getString("marital_sts");
				  String pic1=rs.getString("pic");
				ProfilesImpl p = new ProfilesImpl();
				p.setUserName(user_name);
				p.setPic(pic1);
				p.setDob(dob);
				p.setGender(gender1);
				p.setReligion(religion);
				p.setCaste(caste);
				p.setCountry(country);
				p.setState(state);
				p.setCity(city);
				p.setMobNo(mobNo);
				p.setAadharNo(aadharNo);
				p.setMail(mail);
				p.setHeight(height1);
				p.setEducation(education);
				p.setOccupation(occupation1);
				p.setSalary(salary1);
				p.setMaritalSts(marital_sts);
				p.setPic(pic1);
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<ProfilesImpl> getNotInOccupation(String gender, String occupation) {
		List<ProfilesImpl> list = new ArrayList<ProfilesImpl>();
		String sql = "select * from profiles where gender='" + gender + "' and lower(occupation) not in lower('" + occupation
				+ "') and active=" + active;
		try (Connection con = ConnectionUtil.getConnect();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String userName = rs.getString("user_name");
				Date dob = rs.getDate("d_o_b");
				String gender1 = rs.getString("gender");
				String religion = rs.getString("religion");
				String caste=rs.getString("caste");
				String country = rs.getString("country");
				String state = rs.getString("states");
				String city = rs.getString("city");
				Long aadharNo = rs.getLong("aadhar_no");
				String mail = rs.getString("mail_id");
				int height1 = rs.getInt("height");
				String education = rs.getString("education");
				String occupation1 = rs.getString("occupation");
				int salary1 = rs.getInt("salary");
				String marital_sts = rs.getString("marital_sts");
				  String pic=rs.getString("pic");
					Long mobNo=rs.getLong("mob_no");
				ProfilesImpl p = new ProfilesImpl();
				p.setUserName(userName);
				p.setDob(dob);
				p.setGender(gender1);
				p.setReligion(religion);
				p.setCaste(caste);
				p.setCountry(country);
				p.setState(state);
				p.setCity(city);
				p.setAadharNo(aadharNo);
				p.setMail(mail);
				p.setHeight(height1);
				p.setEducation(education);
				p.setOccupation(occupation1);
				p.setSalary(salary1);
				p.setMaritalSts(marital_sts);
				p.setPic(pic);
				p.setMobNo(mobNo);
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<ProfilesImpl> getAgeDetails() {
		List<ProfilesImpl> list = new ArrayList<ProfilesImpl>();
		String sql = "select lower(user_name),extract(year from sysdate)-extract(year from d_o_b)as Age,lower(marital_sts) from profiles";
		try (Connection con = ConnectionUtil.getConnect();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String user_name = rs.getString("user_name");
				int age=rs.getInt("age");
				String gender = rs.getString("gender");
				
				ProfilesImpl p = new ProfilesImpl();
				p.setUserName(user_name);
				p.setAge(age);
				p.setGender(gender);
				
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void delete(int number) {
		try (Connection con = ConnectionUtil.getConnect(); Statement stmt = con.createStatement()) {
			String sql = "delete from profiles where user_id=" + number;
			int row = stmt.executeUpdate(sql);
			Logger.debug(row);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void save(ProfilesImpl p) {
		try (Connection con = ConnectionUtil.getConnect(); Statement stmt = con.createStatement()) {
			String sql = "insert into profiles(user_id,user_name,d_o_b,gender,religion,caste,country,states,city,mob_no,aadhar_no,mail_id,height,education,occupation,salary,marital_sts,membership_type,pass,pic)"
					+ "values(user_id_sq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getUserName());
			ps.setDate(2, (java.sql.Date) p.getDob());
			ps.setString(3, p.getGender());
			ps.setString(4, p.getReligion());
			ps.setString(5, p.getCaste());
			ps.setString(6, p.getCountry());
			ps.setString(7, p.getState());
			ps.setString(8, p.getCity());
			ps.setLong(9, p.getMobNo());
			ps.setLong(10, p.getAadharNo());
			ps.setString(11, p.getMail());
			ps.setDouble(12, p.getHeight());
			ps.setString(13, p.getEducation());
			ps.setString(14, p.getOccupation());
			ps.setInt(15, p.getSalary());
			ps.setString(16, p.getMaritalSts());
			ps.setString(17, p.getMembershipType());
			ps.setString(18, p.getPass());
			ps.setString(19, p.getPic());
			int row = ps.executeUpdate();
			Logger.debug(row + " row inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateProfiles(String occupation, int salary, String userName,Long mobNo) {
		try (Connection con = ConnectionUtil.getConnect(); Statement stmt = con.createStatement()) {

			//String sql1 = "update profiles set occupation='" + occupation + "',salary=" + salary + " where user_name='"
			//		+ userName + "' and mail_id='" + mail + "' and mob_no=" + mobNo;
			String sql="update profiles set occupation='"+occupation+"',salary="+salary+" where user_name='"+userName+"' and  mob_no="+mobNo;

			int row = stmt.executeUpdate(sql);
			Logger.debug(row);
			Logger.debug("Updated Success");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateActive(int userId, int active) {
		try (Connection con = ConnectionUtil.getConnect(); Statement stmt = con.createStatement()) {
			String sql = "update profiles  set active = " + active + " where user_id=" + userId;
			// LOGGER.debug(sql);
			int row = stmt.executeUpdate(sql);
			Logger.debug(row);
			Logger.debug("Updated Success");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<ProfilesImpl> getReligion(String gender, String religion) {
		List<ProfilesImpl> list = new ArrayList<ProfilesImpl>();
		String sql = "select * from profiles where gender='" + gender + "' and lower(religion)=lower('" + religion + "') and active="
				+ active;
		try (Connection con = ConnectionUtil.getConnect();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String user_name = rs.getString("user_name");
				Date dob = rs.getDate("d_o_b");
				String gender1 = rs.getString("gender");
				String religion1 = rs.getString("religion");
				String country = rs.getString("country");
				String state = rs.getString("states");
				String city = rs.getString("city");
				Long aadharNo = rs.getLong("aadhar_no");
				String mail = rs.getString("mail_id");
				int height = rs.getInt("height");
				String education = rs.getString("education");
				String occupation = rs.getString("occupation");
				int salary = rs.getInt("salary");
				String marital_sts = rs.getString("marital_sts");
				  String pic=rs.getString("pic");
					Long mobNo=rs.getLong("mob_no");
					String caste=rs.getString("caste");
				ProfilesImpl p = new ProfilesImpl();
				p.setCaste(caste);
				p.setPic(pic);
				p.setMobNo(mobNo);
				p.setUserName(user_name);
				p.setAge(age);
				p.setGender(gender1);
				p.setReligion(religion1);
				p.setCountry(country);
				p.setState(state);
				p.setCity(city);
				p.setAadharNo(aadharNo);
				p.setMail(mail);
				p.setHeight(height);
				p.setEducation(education);
				p.setOccupation(occupation);
				p.setSalary(salary);
				p.setMaritalSts(marital_sts);
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<ProfilesImpl> getFullProfile() {
		List<ProfilesImpl> list = new ArrayList<ProfilesImpl>();
		String sql = "select * from profiles";
		try (Connection con = ConnectionUtil.getConnect();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				int userId=rs.getInt("user_id");
				String user_name = rs.getString("user_name");
				Date dob = rs.getDate("d_o_b");
				String gender1 = rs.getString("gender");
				String religion1 = rs.getString("religion");
				String caste=rs.getString("caste");
				String country = rs.getString("country");
				String state = rs.getString("states");
				String city = rs.getString("city");
				Long mobNo=rs.getLong("mob_no");
				Long aadharNo = rs.getLong("aadhar_no");
				String mail = rs.getString("mail_id");
				int height = rs.getInt("height");
				String education = rs.getString("education");
				String registerdDate=rs.getString("registerd_date");
				String occupation = rs.getString("occupation");
				int salary = rs.getInt("salary");
				String marital_sts = rs.getString("marital_sts");
				String membershipType=rs.getString("membership_type");
				String pass=rs.getString("pass");
				int active =rs.getInt("active");
			    String pic=rs.getString("pic");
				ProfilesImpl p = new ProfilesImpl();
				p.setUserId(userId);
				p.setUserName(user_name);
				p.setDob(dob);
				p.setGender(gender1);
				p.setReligion(religion1);
				p.setCaste(caste);
				p.setCountry(country);
				p.setState(state);
				p.setCity(city);
				p.setMobNo(mobNo);
				p.setAadharNo(aadharNo);
				p.setMail(mail);
				p.setHeight(height);
				p.setEducation(education);
				p.setRegisterdDate(registerdDate);
				p.setOccupation(occupation);
				p.setSalary(salary);
				p.setMaritalSts(marital_sts);
				p.setMembershipType(membershipType);
				p.setPass(pass);
				p.setActive(active);
				p.setPic(pic);
				list.add(p);
		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String userLogin(String mail, String pass) {
		String sql = "select mail_id,pass from profiles where mail_id='" + mail + "' and pass='" + pass + "'";
		String msg = null;
		try (Connection con = ConnectionUtil.getConnect();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			if (rs.next()) {
				String mail1 = rs.getString("mail_id");
				String password1 = rs.getString("pass");
				if (mail1.equals(mail) && password1.equals(pass))

					Logger.debug("Logged In...");
				msg = "success";
			} else {
				Logger.debug("Invalid EmailId/Password");
				msg = "fail";
			}
			return msg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public void changePassword(String userEmail, String pass, String userpassword) {
		try (Connection con = ConnectionUtil.getConnect(); Statement stmt = con.createStatement()) {
			String sql = "update profiles set pass='" + userpassword + "' where mail_id='" + userEmail + "' and pass='"
					+ pass + "'";
			int row = stmt.executeUpdate(sql);
			Logger.debug(row);
			if (row == 1) {
				Logger.debug("Updated Success");
			} else {
				Logger.debug("Invalid EmailId/Password");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
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