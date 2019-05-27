package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;

public class NonSystemUser{ 
	private Integer userId;
	private String name;
	private String gender;
	private String address;
	private String contact;
	private Activity activity;
	private String startTime;
	private String endTime;
	private String payment;
	private Cafe cafe;
	private Day day;

	public NonSystemUser(Integer userId,String name,String gender,String address,String contact,Activity activity,String startTime,String endTime,String payment){
		this.userId = userId;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.contact = contact;
		this.activity = activity;
		this.startTime = startTime;
		this.endTime = endTime;
		this.payment = payment;
	}

	/*public NonSystemUser(String name,String gender,String address,Activity activity,String systemNo,String startTime,String endTime,String payment,Cafe cafe){
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.contact = contact;
		this.activity = activity;
		this.startTime = startTime;
		this.endTime = endTime;
		this.payment = payment;
		this.cafe = cafe;
	}*/

	public NonSystemUser(Integer userId){
		this.userId = userId;
	}

	public NonSystemUser(String payment){
		this.payment = payment;
	}

	public NonSystemUser(){
	
	}

	public static ArrayList<NonSystemUser> getUserPayment(Integer cafeId){
		ArrayList<NonSystemUser> payment2 = new ArrayList<NonSystemUser>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cyber_cafe?user=root&password=1234");

			String q1 = "select sum(payment) as 'income per day' from non_system_users where cafe_id=? ";
			String q2 = "group by dayname(cast(start_time as date)) order by day_id";

			PreparedStatement ps = con.prepareStatement(q1+q2);
			
			ps.setInt(1,cafeId);

			ResultSet rs = ps.executeQuery();
				
			while(rs.next()){
				payment2.add(new NonSystemUser(rs.getString(1))); 				
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return payment2;
	}

	public static ArrayList<NonSystemUser> getAllUsers(Integer cafeId){
		ArrayList<NonSystemUser> nonSystemUsers = new ArrayList<NonSystemUser>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cyber_cafe?user=root&password=1234");

			String query = "select * from non_system_users where cafe_id=?";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1,cafeId);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				nonSystemUsers.add(new NonSystemUser(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),new Activity(rs.getInt(6)),rs.getString(7),rs.getString(8),rs.getString(9)));
			}

			con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}

		return nonSystemUsers;
	}

	public boolean saveUser(){
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cyber_cafe?user=root&password=1234");
			
			String query = "insert into non_system_users (name,gender,address,contact,activity_id,start_time,end_time,payment,cafe_id,day_id) value (?,?,?,?,?,?,now(),?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1,name);
			ps.setString(2,gender);
			ps.setString(3,address);
			ps.setString(4,contact);
			ps.setInt(5,activity.getActivityId());
			ps.setString(6,startTime);
			//ps.setString(7,endTime);
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

	public void setActivity(Activity activity){
		this.activity = activity;
	}
	public Activity getActivity(){
		return activity;
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