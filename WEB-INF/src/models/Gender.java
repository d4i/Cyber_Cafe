package models;

import java.sql.*;
import java.util.ArrayList;

public class Gender{
	private Integer genderId;
	private String gender;

	public Gender(){
	
	}

	public Gender(String gender){
		this.gender = gender;
	}


	public Gender(Integer genderId,String gender){
		this.genderId = genderId;
		this.gender = gender;
	}

	public static ArrayList<Gender> getGenderRatio(Integer cafeId){
		ArrayList<Gender> gender = new ArrayList<Gender>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cyber_cafe?user=root&password=1234");
	
			String q1 = "select count(case when gender_id='1' then 1 end)";
			String q2 = "as male_cnt,count(case when gender_id='2' then 1 end) ";
			String q3 = "as female_cnt from system_users where cafe_id=?;";

			PreparedStatement ps = con.prepareStatement(q1+q2+q3);
			ps.setInt(1,cafeId);

			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				gender.add(new Gender(rs.getString(1)));
				gender.add(new Gender(rs.getString(2)));
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return gender;
	}

	public void setGenderId(Integer genderId){
		this.genderId = genderId;
	}
	public Integer getGenderId(){
		return genderId;
	}

	public void setGender(String gender){
		this.gender = gender;
	}
	public String getGender(){
		return gender;
	}
}