package com.qsp.jdbc_simple_curd_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class TeacherUpdate {

	public static void main(String[] args) {
		 Connection connection=null;
		// TODO Auto-generated method stub
        try {
        	//Load the driver class
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	
        	//Creat the connection 
        	String url="jdbc:mysql://localhost:3306/jdbc-simple-curd-operation-morning";
        	String user="root";
        	String pass="root";
        	
        	 connection=DriverManager.getConnection(url, user, pass);
        	  
        	 //Create Statement
        	 
        	 java.sql.Statement statement=connection.createStatement();
        	 
        	 String update="update teacher set name='Deepak-Sir' where id=102";
        	 
        	 
        	int b=statement.executeUpdate(update);
        	
        	if(b!=0)
        	{
        		System.out.println("Data will be update Succesfully.........");
        		System.out.println(b);
        	}else
        	{
        		System.out.println("Id Not found");
        		System.out.println(b);
        	}
        }catch (ClassNotFoundException |SQLException e) {
			// TODO: handle exception
        	e.printStackTrace();
		}
        finally {
        	try {
			connection.close();
        	}catch (SQLException e) {
				// TODO: handle exception
        		e.printStackTrace();
			}
		}
	}

}
