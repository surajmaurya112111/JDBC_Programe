package com.qsp.jdbc_simple_curd_operation;

import java.sql.Connection;

import java.sql.DriverManager;
import  java.sql.Statement;
public class Teacher {

	public static void main(String[] args) {
		Connection connection = null;
		
		try {
			
			//Step 1: load the Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Step 2:Create the Connection
		String url="jdbc:mysql://localhost:3306/jdbc-simple-curd-operation-morning";
		String user="root";
		String pass="root";
		
		 connection=DriverManager.getConnection(url, user, pass);
		//Step:3
		Statement statement =  connection.createStatement();
		 String query="insert into teacher values(104,'Gavtam','gavtam@gmail.com')";
		 
		 //Step 4:
		 boolean b=statement.execute(query);
		 
		 System.out.println(b);
		 
		 System.out.println("data inserted.....");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
			connection.close();
			System.out.println("Connection is close.........../");
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
