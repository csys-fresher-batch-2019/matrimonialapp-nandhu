package com.chainsys.matrimonialmanagement.profiles;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ProfilesImpl implements ProfilesInterfaceDAO {
	String userName;
	// DateFormat d= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	// Date now = new Date();
	// String dd=d.format(now);
	// String dob=dd;
	// String vDateMDY = dateFormatMDY.format(now);
	// String vDateMDYSQL = vDateMDY ;
	LocalDate dob;
	String gender;
	String religion;
	String caste;
	String country;
	String state;
	String city;
	Long mobNo;
	Long aadharNo;
	String mail;
	double height;
	String education;
	String registerdDate;
	String maritalSts;
	String occupation;
	int salary;
	String membershipType;
	String pass;
	int active=1;

	// connection coding
	public static Connection getConnect() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
	//	System.out.println(con);
		return con;
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





	// display the total number of users
	public int getTotalCount() {
		try {
			Connection con = getConnect();
			Statement stmt = con.createStatement();
			String sql = "select count(*)as total_count from profiles where active="+active;
			//System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int count = rs.getInt("total_count");
				System.out.println("Total Count ="+count);
				
			}con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

//Display user details for particular user
	public String[] getProfile(String userName) {
		try {
			Connection con = getConnect();
			Statement stmt = con.createStatement();
			String sql = "select * from profiles where user_name='"+userName+"' and active="+active;
			//System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String user_name = rs.getString("user_name");
				System.out.println("Name= "+user_name);
				String dob = rs.getString("d_o_b");
				System.out.println("DOB= "+dob);
				String gender = rs.getString("gender");
				System.out.println("Gender= "+gender);
				String religion = rs.getString("religion");
				System.out.println("Religion= "+religion);
				String country = rs.getString("country");
				System.out.println("Country= "+country);
				String state= rs.getString("states");
				System.out.println("State= "+state);
				String city = rs.getString("city");
				System.out.println("City= "+city);
				Long aadharNo = rs.getLong("aadhar_no");
				System.out.println("Aadhar No= "+aadharNo);
				String mail = rs.getString("mail_id");
				System.out.println("MailId= "+mail);
				int height = rs.getInt("height");
				System.out.println("Height= "+height);
				String education = rs.getString("education");
				System.out.println("Education= "+education);
				String occupation = rs.getString("occupation");
				System.out.println("Occupation= "+occupation);
				int salary = rs.getInt("salary");
				System.out.println("Salary= "+salary);
				String marital_sts = rs.getString("marital_sts");
				System.out.println("Marital Status= "+marital_sts);
				
				
				//file Write
				/*String result="Name= "+user_name+"\n"+"DOB= "+dob+"\n"+"Gender= "+gender+"\n"+"Religion= "+religion+"\n"+"Height= "+height+"\n"+"Education= "+education+"\n"+ "Occupation= "+occupation+"\n"+"Salary= "+salary+"\n"+"Marital Status="+marital_sts;  
				FileUtil.WriteToFile("ProfilePrint.txt", result);	
				System.out.println("Write Successfully");
				
				//file Read
				String pro="ProfilePrint.txt";
				Path path=Paths.get(pro);
				
				byte[] bytes=Files.readAllBytes(path);
				String content=new String(bytes);
				System.out.println(content);*/
				//System.out.println("Read successfully");
				
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// Display all the bridegroom list
	public String[] getGenderProfile(String gender) {
		try {
			Connection con = getConnect();
			Statement stmt = con.createStatement();
			String sql = "select * from profiles where gender='" + gender + "'and active="+active;
			//System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String user_name = rs.getString("user_name");
				System.out.println("Name= "+user_name);
				String dob = rs.getString("d_o_b");
				System.out.println("DOB= "+dob);
				String gender1 = rs.getString("gender");
				System.out.println("Gender= "+gender);
				String religion = rs.getString("religion");
				System.out.println("Religion= "+religion);
				String country = rs.getString("country");
				System.out.println("Country= "+country);
				String state= rs.getString("states");
				System.out.println("State= "+state);
				String city = rs.getString("city");
				System.out.println("City= "+city);
				Long aadharNo = rs.getLong("aadhar_no");
				System.out.println("Aadhar No= "+aadharNo);
				String mail = rs.getString("mail_id");
				System.out.println("MailId= "+mail);
				int height = rs.getInt("height");
				System.out.println("Height= "+height);
				String education = rs.getString("education");
				System.out.println("Education= "+education);
				String occupation = rs.getString("occupation");
				System.out.println("Occupation= "+occupation);
				int salary = rs.getInt("salary");
				System.out.println("Salary= "+salary);
				String marital_sts = rs.getString("marital_sts");
				System.out.println("Marital Status= "+marital_sts);
				System.out.println();
			}con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String[] getCityProfile(String gender,String city) {
		try {
			Connection con = getConnect();
			Statement stmt = con.createStatement();
			String sql = "select * from profiles where gender='" + gender + "' and city='"+city+"' and active="+active;
			//System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String user_name = rs.getString("user_name");
				System.out.println("Name= "+user_name);
				String dob = rs.getString("d_o_b");
				System.out.println("DOB= "+dob);
				String gender1 = rs.getString("gender");
				System.out.println("Gender= "+gender);
				String religion = rs.getString("religion");
				System.out.println("Religion= "+religion);
				String country = rs.getString("country");
				System.out.println("Country= "+country);
				String state= rs.getString("states");
				System.out.println("State= "+state);
				String city1 = rs.getString("city");
				System.out.println("City= "+city);
				Long aadharNo = rs.getLong("aadhar_no");
				System.out.println("Aadhar No= "+aadharNo);
				String mail = rs.getString("mail_id");
				System.out.println("MailId= "+mail);
				int height = rs.getInt("height");
				System.out.println("Height= "+height);
				String education = rs.getString("education");
				System.out.println("Education= "+education);
				String occupation = rs.getString("occupation");
				System.out.println("Occupation= "+occupation);
				int salary = rs.getInt("salary");
				System.out.println("Salary= "+salary);
				String marital_sts = rs.getString("marital_sts");
				System.out.println("Marital Status= "+marital_sts);
				System.out.println();
			}con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// List all bridegroom with height specification
	public String[] getHeight(double height, String gender) {
		try {
			Connection con = getConnect();
			Statement stmt = con.createStatement();
			String sql = "select * from profiles where height >=" + height + " and gender='" + gender
					+ "'and active="+active;
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String user_name = rs.getString("user_name");
				System.out.println("Name= "+user_name);
				String dob = rs.getString("d_o_b");
				System.out.println("DOB= "+dob);
				String gender1 = rs.getString("gender");
				System.out.println("Gender= "+gender);
				String religion = rs.getString("religion");
				System.out.println("Religion= "+religion);
				String country = rs.getString("country");
				System.out.println("Country= "+country);
				String state= rs.getString("states");
				System.out.println("State= "+state);
				String city = rs.getString("city");
				System.out.println("City= "+city);
				Long aadharNo = rs.getLong("aadhar_no");
				System.out.println("Aadhar No= "+aadharNo);
				String mail = rs.getString("mail_id");
				System.out.println("MailId= "+mail);
				int height1 = rs.getInt("height");
				System.out.println("Height= "+height);
				String education = rs.getString("education");
				System.out.println("Education= "+education);
				String occupation = rs.getString("occupation");
				System.out.println("Occupation= "+occupation);
				int salary = rs.getInt("salary");
				System.out.println("Salary= "+salary);
				String marital_sts = rs.getString("marital_sts");
				System.out.println("Marital Status= "+marital_sts);
				System.out.println();

			}con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Display all users name,education,occupation and their salary details
	public String[] getSalaryDetails(int salary,String gender) {
		try {
			Connection con = getConnect();
			Statement stmt = con.createStatement();
			String sql = "select * from profiles where salary>="+salary+" and gender='" + gender+"'and active="+active;
				
			//System.out.println(sql);
			
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String user_name = rs.getString("user_name");
				System.out.println("Name="+user_name);
				String dob = rs.getString("d_o_b");
				System.out.println("DOB= "+dob);
				String religion = rs.getString("religion");
				System.out.println("Religion= "+religion);
				int height = rs.getInt("height");
				System.out.println("Height= "+height);
				String education = rs.getString("education");
				System.out.println("Education="+education);
				String occupation = rs.getString("occupation");
				System.out.println("Occupation= "+occupation);
				int salary1 = rs.getInt("salary");
				System.out.println("Salary= "+salary);
				String marital_sts = rs.getString("marital_sts");
				System.out.println("Marital Status= "+marital_sts);
				System.out.println();
			}con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// List the bridegroom list with the specific occupation

	public String[] getOccupation(String gender, String occupation) {
		try {
			
			Connection con = getConnect();
			Statement stmt = con.createStatement();
			String sql = "select * from profiles where gender='" + gender
					+ "' and occupation ='" + occupation + "' and active="+active;
			//System.out.println(sql);
			
			ResultSet rs = stmt.executeQuery(sql);
			if(rs!=null) {
				
			while (rs.next()) {
				String user_name = rs.getString("user_name");
				System.out.println("Name= "+user_name);
				String dob = rs.getString("d_o_b");
				System.out.println("DOB= "+dob);
				String gender1 = rs.getString("gender");
				System.out.println("Gender= "+gender);
				String religion = rs.getString("religion");
				System.out.println("Religion= "+religion);
				String country = rs.getString("country");
				System.out.println("Country= "+country);
				String state= rs.getString("states");
				System.out.println("State= "+state);
				String city = rs.getString("city");
				System.out.println("City= "+city);
				Long aadharNo = rs.getLong("aadhar_no");
				System.out.println("Aadhar No= "+aadharNo);
				String mail = rs.getString("mail_id");
				System.out.println("MailId= "+mail);
				int height = rs.getInt("height");
				System.out.println("Height= "+height);
				String education = rs.getString("education");
				System.out.println("Education= "+education);
				String occupation1 = rs.getString("occupation");
				System.out.println("Occupation= "+occupation);
				int salary = rs.getInt("salary");
				System.out.println("Salary= "+salary);
				String marital_sts = rs.getString("marital_sts");
				System.out.println("Marital Status= "+marital_sts);
				System.out.println();

			}}
			else
			{
				System.out.println("no");
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String[] getNotInOccupation(String gender, String occupation) {
		try {
			
			Connection con = getConnect();
			Statement stmt = con.createStatement();
			String sql = "select * from profiles where gender='" + gender
					+ "' and occupation not in '" + occupation + "' and active="+active;
			//System.out.println(sql);
			
			ResultSet rs = stmt.executeQuery(sql);
			if(rs!=null) {
				
			while (rs.next()) {
				String user_name = rs.getString("user_name");
				System.out.println("Name= "+user_name);
				String dob = rs.getString("d_o_b");
				System.out.println("DOB= "+dob);
				String gender1 = rs.getString("gender");
				System.out.println("Gender= "+gender);
				String religion = rs.getString("religion");
				System.out.println("Religion= "+religion);
				String country = rs.getString("country");
				System.out.println("Country= "+country);
				String state= rs.getString("states");
				System.out.println("State= "+state);
				String city = rs.getString("city");
				System.out.println("City= "+city);
				Long aadharNo = rs.getLong("aadhar_no");
				System.out.println("Aadhar No= "+aadharNo);
				String mail = rs.getString("mail_id");
				System.out.println("MailId= "+mail);
				int height = rs.getInt("height");
				System.out.println("Height= "+height);
				String education = rs.getString("education");
				System.out.println("Education= "+education);
				String occupation1 = rs.getString("occupation");
				System.out.println("Occupation= "+occupation);
				int salary = rs.getInt("salary");
				System.out.println("Salary= "+salary);
				String marital_sts = rs.getString("marital_sts");
				System.out.println("Marital Status= "+marital_sts);
				System.out.println();

			}}
			else
			{
				System.out.println("no");
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// list all the users with their age and marital status

	public String[] getAgeDetails() {
		try {
			Connection con = getConnect();
			Statement stmt = con.createStatement();
			String sql = "select user_name,extract(year from sysdate)-extract(year from d_o_b)as Age,marital_sts from profiles";
			//System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String user_name = rs.getString("user_name");
				System.out.println("Name="+user_name);
				int age1 = rs.getInt("Age");
				System.out.println("Age="+age1);
				String marital_sts = rs.getString("marital_sts");
				System.out.println("Marital Status= "+marital_sts);

			System.out.println();
			}	con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void delete(int number) {
		try {
			Connection con = getConnect();
			Statement stmt = con.createStatement();
			String sql = "delete from profiles where user_id=" + number;
			//System.out.println(sql);
			int row = stmt.executeUpdate(sql);
			System.out.println(row);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void save(ProfilesImpl p) {
		try {
			Connection con = getConnect();
			Statement stmt = con.createStatement();
			String sql = "insert into profiles(user_id,user_name,d_o_b,gender,religion,caste,country,states,city,mob_no,aadhar_no,mail_id,height,education,occupation,salary,marital_sts,membership_type,pass)"
					+ "values(user_id_sq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			//System.out.println(sql);
			//ps.setInt(1, number);
			ps.setString(1, userName);
			// ps.setDate(3,date.valueOf(dob));
			ps.setDate(2, java.sql.Date.valueOf(dob));
			ps.setString(3, gender);
			ps.setString(4, religion);
			ps.setString(5, caste);
			ps.setString(6, country);
			ps.setString(7, state);
			ps.setString(8, city);
			ps.setLong(9, mobNo);
			ps.setLong(10, aadharNo);
			ps.setString(11, mail);
			ps.setDouble(12, height);
			ps.setString(13, education);
			ps.setString(14, occupation);
			ps.setInt(15, salary);
			ps.setString(16, maritalSts);
			ps.setString(17, membershipType);
			ps.setString(18, pass);
			int row = ps.executeUpdate();
			System.out.println(row+" row inserted");
		
		}	
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateProfiles(String occupation,int salary,String userName,Long mobNo)
	{
			try {
			Connection con = getConnect();
			Statement stmt = con.createStatement();
			String sql = "update profiles set occupation='"+occupation+"',salary="+salary+" where user_name='"+userName+"' and mob_no="+mobNo;
			//System.out.println(sql);
			int row=stmt.executeUpdate(sql);
			System.out.println(row);
			System.out.println("Updated Success");
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}

	public void updateActive(int userId, int active) {
		try {
			Connection con = getConnect();
			Statement stmt = con.createStatement();
			String sql = "update profiles  set active = "+active+" where user_id="+userId;
			//System.out.println(sql);
			int row=stmt.executeUpdate(sql);
			System.out.println(row);
			System.out.println("Updated Success");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}






	public String[] getReligion(String gender,String religion) {

		try {
			Connection con = getConnect();
			Statement stmt = con.createStatement();
			String sql = "select * from profiles where gender='"+gender+"' and religion='"+religion+"' and active="+active;
			//System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String user_name = rs.getString("user_name");
				System.out.println("Name= "+user_name);
				String dob = rs.getString("d_o_b");
				System.out.println("DOB= "+dob);
				String gender1 = rs.getString("gender");
				System.out.println("Gender= "+gender);
				String religion1 = rs.getString("religion");
				System.out.println("Religion= "+religion);
				String country = rs.getString("country");
				System.out.println("Country= "+country);
				String state= rs.getString("states");
				System.out.println("State= "+state);
				String city = rs.getString("city");
				System.out.println("City= "+city);
				Long aadharNo = rs.getLong("aadhar_no");
				System.out.println("Aadhar No= "+aadharNo);
				String mail = rs.getString("mail_id");
				System.out.println("MailId= "+mail);
				int height = rs.getInt("height");
				System.out.println("Height= "+height);
				String education = rs.getString("education");
				System.out.println("Education= "+education);
				String occupation = rs.getString("occupation");
				System.out.println("Occupation= "+occupation);
				int salary = rs.getInt("salary");
				System.out.println("Salary= "+salary);
				String marital_sts = rs.getString("marital_sts");
				System.out.println("Marital Status= "+marital_sts);
				System.out.println();

			}con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void userLogin(String userEmail, String userpassword) {
		try {
			Connection con = getConnect();
			Statement stmt = con.createStatement();
			String sql = "select mail_id,pass from profiles where mail_id='"+userEmail+"' and pass='"+userpassword+"'";
			//System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				String mail = rs.getString("mail_id");
				//System.out.println("Name="+mail);
				String password = rs.getString("pass");
				//System.out.println("Age="+password);
				if(mail.equals(userEmail)&& password.equals(userpassword))
						System.out.println("Logged In...");
			}	else {
			System.out.println("Login Failed...");}
			con.close();
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