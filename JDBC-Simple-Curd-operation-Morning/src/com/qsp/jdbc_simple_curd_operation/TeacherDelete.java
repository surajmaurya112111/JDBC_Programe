package com.qsp.jdbc_simple_curd_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import  java.sql.Statement;
public class TeacherDelete {

	public static void main(String[] args) {
          Connection connection=null;
		//Load the Driver Class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Creat the  Connection
			String url="jdbc:mysql://localhost:3306/jdbc-simple-curd-operation-morning";
			String user="root";
			String pass="root";
			
			connection=DriverManager.getConnection(url, user, pass);
      	  
       	 //Create Statement
       	 
       	 Statement statement=connection.createStatement();
       	 
       	 String delete="delete from teacher where id=101";
       	 
       	 
       	int b=statement.executeUpdate(delete);
       	
       	if(b!=0)
       	{
       		System.out.println("Data will be Deleted Succesfully.........");
       		System.out.println(b);
       	}else
       	{
       		System.out.println("Id Not found");
       		System.out.println(b);
       	}
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
