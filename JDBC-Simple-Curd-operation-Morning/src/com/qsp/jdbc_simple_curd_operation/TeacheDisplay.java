package com.qsp.jdbc_simple_curd_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TeacheDisplay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
		//load the driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Create the Connection
		String url="jdbc:mysql://localhost:3306/jdbc-simple-curd-operation-morning";
		String user="root";
		String pass="root";
		
		Connection connection=DriverManager.getConnection(url, user, pass);
		//Create Statement
		Statement statement=connection.createStatement();
	        
		String display="Select * from teacher";
		//Execute Statement 
		     
		ResultSet resultset=statement.executeQuery(display);
		System.out.println("=======TeacherDetail============");
		System.out.println("ID            Name            Email");
		while (resultset.next()) {
			
			int id=resultset.getInt("id");
			String name=resultset.getString("Name");
			String email=resultset.getString("email");
			
			
			System.out.println("id ="+id+"   Name ="+name+"   email ="+email);
//			System.out.print("Name ="+name);
//			System.out.print("email ="+email);
			//System.out.print("==============================");
			
		}
		       
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
