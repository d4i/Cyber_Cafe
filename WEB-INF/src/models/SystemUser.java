package models;

import java.sql.Time;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;

public class SystemUser{ 
	private Integer userId;
	private String name;
	private String gender;
	private String address;
	private String contact;
	private String systemNo;
	private String startTime;
	private String endTime;
	private String payment;
	private Cafe cafe;
	private Day day;

	public SystemUser(Integer userId,String name,String gender,String address,String contact,String systemNo,String startTime,String endTime,String payment){
		this.userId = userId;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.contact = contact;
		this.systemNo = systemNo;
		this.startTime = startTime;
		this.endTime = endTime;
		this.payment = payment;
	}

	public SystemUser(Integer userId){
		this.userId = userId;
	}

	public SystemUser(String payment){
		this.payment = payment;
	}


	public SystemUser(){
	
	}

	public static ArrayList<SystemUser> getGenderRatio(Integer cafeId){

		/*public class Gender{
			String male;
			String female;

			public Gender(String male){
				this.male = male;
			}
		}*/

		ArrayList<SystemUser> gender = new ArrayList<SystemUser>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cyber_cafe?user=root&password=1234");
	
			String q1 = "select count(case when gender='male' then 1 end)";
			String q2 = "as male_cnt,count(case when gender='female' then 1 end) ";
			String q3 = "as female_cnt from system_users where cafe_id=?;";

			PreparedStatement ps = con.prepareStatement(q1+q2+q3);
			ps.setInt(1,cafeId);

			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				gender.add(new SystemUser(rs.getString(1)));
				gender.add(new SystemUser(rs.getString(2)));
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return gender;
	}

	public static ArrayList<SystemUser> getUserPayment(Integer cafeId){
		ArrayList<SystemUser> payment1 = new ArrayList<SystemUser>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cyber_cafe?user=root&password=1234");

			String q1 = "select sum(payment) as 'income per day' from system_users where cafe_id=? ";
			String q2 = "group by dayname(cast(start_time as date)) order by day_id";

			PreparedStatement ps = con.prepareStatement(q1+q2);
			
			ps.setInt(1,cafeId);

			ResultSet rs = ps.executeQuery();
				
			while(rs.next()){
				payment1.add(new SystemUser(rs.getString(1))); 				
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return payment1;
	}


	public static ArrayList<SystemUser> getAllUsers(Integer cafeId){
		ArrayList<SystemUser> systemUsers = new ArrayList<SystemUser>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cyber_cafe?user=root&password=1234");

			String query = "select * from system_users where cafe_id=?";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1,cafeId);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				systemUsers.add(new SystemUser(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));
			}

			con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}

		return systemUsers;
	}

	public Boolean saveUser(){
		
		Boolean flag = false;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cyber_cafe?user=root&password=1234");

			String query = "insert into system_users (name,gender,address,contact,system_no,start_time,end_time,payment,cafe_id,day_id) value (?,?,?,?,?,?,now(),?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);				
			
			ps.setString(1,name);
			ps.setString(2,gender);
			ps.setString(3,address);
			ps.setString(4,contact);
			ps.setString(5,systemNo);
			ps.setString(6,startTime);
			//ps.setString(6,endTime);
			ps.setString(7,payment);
			ps.setInt(8,cafe.getCafeId());
			ps.setInt(9,day.getDayId());

			if(ps.executeUpdate()!=0){
				flag = true;
			}

			con.close();
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}

		return flag;
	}


	
	public void setUserId(Integer userId){
		this.userId = userId;
	}
	public Integer getUserId(){
		return userId;
	}

	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}

	public void setGender(String gender){
		this.gender = gender;
	}
	public String getGender(){
		return gender;
	}

	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress(){
		return address;
	}

	public void setContact(String contact){
		this.contact = contact;
	}
	public String getContact(){
		return contact;
	}

	public void setSystemNo(String systemNo){
		this.systemNo = systemNo;
	}
	public String getSystemNo(){
		return systemNo;
	}

	public void setStartTime(String startTime){
		this.startTime = startTime;
	}
	public String getStartTime(){
		return startTime;
	}

	public void setEndTime(String endTime){
		this.endTime = endTime;
	}
	public String getTime(){
		return endTime;
	}

	public void setPayment(String payment){
		this.payment = payment;
	}
	public String getPayment(){
		return payment;
	}

	public void setCafe(Cafe cafe){
		this.cafe = cafe;
	}
	public Cafe getCafe(){
		return cafe;
	}

	public void setDay(Day day){
		this.day = day;
	}
	public Day getDay(){
		return day;
	}

}