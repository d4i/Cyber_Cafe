package models;

import java.sql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;


public class Day{
	private Integer dayId;
	private String day;

	public Day(){
	
	}

	public Day(Integer dayId){
		this.dayId = dayId;
	}

	public Day(String day){
		this.day = day;
	}

	public static ArrayList<Day> getDayName(Integer cafeId){
		ArrayList<Day> day = new ArrayList<Day>();

		try{			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cyber_cafe?user=root&password=1234");

			String q1 = "select distinct d.day from days as d inner join";
			String q2 = " system_users as su where d.day_id=su.day_id and cafe_id=? order by d.day_id;";

			PreparedStatement ps = con.prepareStatement(q1+q2);
			
			ps.setInt(1,cafeId);

			ResultSet rs = ps.executeQuery();
				
			while(rs.next()){
				day.add(new Day(rs.getString(1)));
			}

			con.close();

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}

		return day;
	}

	public void setDayId(Integer dayId){
		this.dayId = dayId;
	}
	public Integer getDayId(){
		return dayId;
	}

	public void setDay(String day){
		this.day = day;
	}
	public String getDay(){
		return day;
	}
}