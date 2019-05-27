package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Cafe{
	private Integer cafeId;
	private String name;
	private String contact;
	private String password;

	public Cafe(){
	
	}

	public Cafe(String contact,String password){
		this.contact = contact;
		this.password = password;
	}

	public boolean loginCafe(){
		boolean flag = false;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cyber_cafe?user=root&password=1234");
			
			String query="select cafe_id,name from cafes where contact=? and password=?";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1,contact);
			ps.setString(2,password);

			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				cafeId = rs.getInt(1);
				name = rs.getString(2);
				
				flag = true;
			}

			con.close();

		}catch (SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
		return flag;
	}

	public boolean registerCafe(){
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cyber_cafe?user=root&password=1234");

			String query = "insert into cafes (name,contact,password) value (?,?,?)";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1,name);
			ps.setString(2,contact);
			ps.setString(3,password);
			
			if(ps.executeUpdate()!=0){
				flag = true;
			}
			
			con.close();
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}

		return flag;
	}

	public void setCafeId(Integer cafeId){
		this.cafeId = cafeId;
	}
	public Integer getCafeId(){
		return cafeId;
	}

	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}

	public void setContact(String contact){
		this.contact = contact;
	}
	public String getContact(){
		return contact;
	}

	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return password;
	}
}