package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Activity{
	private Integer activityId;
	private String activity;

	public Activity(Integer activityId,String activity){
		this.activityId = activityId;
		this.activity = activity;
	}

	public Activity(Integer activityId){
		this.activityId = activityId;
	}

	public static ArrayList<Activity> collectActivities(){

		ArrayList<Activity> activities = new ArrayList<Activity>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cyber_cafe?user=root&password=1234");

			String query = "select activity_id,activity from activities";
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				activities.add(new Activity(rs.getInt(1),rs.getString(2)));
			}

			con.close();
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}

		return activities;
	}

	public void setActivityId(Integer activityId){
		this.activityId = activityId;
	}
	public Integer getActivityId(){
		return activityId;
	}

	public void setActivity(String activity){
		this.activity = activity;
	}
	public String getActivity(){
		return activity;
	}
}