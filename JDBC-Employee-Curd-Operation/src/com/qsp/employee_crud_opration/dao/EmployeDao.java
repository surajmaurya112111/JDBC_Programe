package com.qsp.employee_crud_opration.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.qsp.employee_crud_opration.dto.Employee;
public class EmployeDao {
	
	//Insert to data databese
	public void insertEmployee(Employee employee)
	{
		Connection connection=null;
		
		try {
			//Load the Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create Connection
			String url="jdbc:mysql://localhost:3306/jdbc-employee-curd-operation";
			String user="root";
			String pass="root";
			
			connection=DriverManager.getConnection(url, user, pass);
			
			//create Statement
			Statement statement= connection.createStatement();
		     
			String insert="insert into employee values("+employee.getId()+",'"+employee.getName()+"','"+employee.getEmail()+"','"+employee.getPhone()+"')";
			
			//ExecuteQuery
			statement.execute(insert);
			
			System.out.println("Data inserted....");
		} catch (ClassNotFoundException | SQLException e) {
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
	//Delete Employee Method
	public void deleteEmployee(int id)
	{
		
		Connection connection=null;
		try {
			//Load the Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create Connection
			String url="jdbc:mysql://localhost:3306/jdbc-employee-curd-operation";
			String user="root";
			String pass="root";
			
			connection=DriverManager.getConnection(url, user, pass);
					
			//Create Statement
			     Statement statement=connection.createStatement();
			     
			    
				String delete="delete from employee where id="+id+"";
			     
			     //Exwcute query
			 int b= statement.executeUpdate(delete);
			 System.out.println("Data delated...");
			 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//get byID
	public int getById(int id)
	{
		Connection connection=null;
		int id1=0;
		try {
			//Load the Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create Connection
			String url="jdbc:mysql://localhost:3306/jdbc-employee-curd-operation";
			String user="root";
			String pass="root";
			
			connection=DriverManager.getConnection(url, user, pass);
					
			//Create Statement
			     Statement statement=connection.createStatement();
			     
			     String select="Select * from employee where id="+id+"";
			     
			        ResultSet resultSet=statement.executeQuery(select);
			     while(resultSet.next())
			     {
			    	 id1 = resultSet.getInt("id");
			     }
	
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			try {
				connection.close();
				//System.out.println("Conection close....");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return id1;
	}
	// update Employee
	public void updateEmployee(int id,String name,String email)
	{
		Connection connection=null;
		try {
			//Load the Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create Connection
			String url="jdbc:mysql://localhost:3306/jdbc-employee-curd-operation";
			String user="root";
			String pass="root";
			
			connection=DriverManager.getConnection(url, user, pass);
					
			//Create Statement
			     Statement statement=connection.createStatement();
			     
			    
				String update="Update employee set name='"+name+"',email='"+email+"' where id="+id+"";
			     
			     //Exwcute query
				
			 statement.executeUpdate(update);
			 
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				 System.out.println("Data Update Successfully...");
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//Display Employee
	public void employeeDisplay(int id)
	{
		Connection connection=null;
		try {
			//Load the Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create Connection
			String url="jdbc:mysql://localhost:3306/jdbc-employee-curd-operation";
			String user="root";
			String pass="root";
			
			connection=DriverManager.getConnection(url, user, pass);
					
			//Create Statement
			     Statement statement=connection.createStatement();
			     
			     String display="Select * from employee Where id='"+id+"'";
			     
			     //Execute querey
			     
			   ResultSet resultSet=statement.executeQuery(display);
			   
			   while(resultSet.next())
			   {
				   System.out.print("Employee Id:");
				System.out.println(resultSet.getInt("id"));
				System.out.print("Employee Name:");
				System.out.println(resultSet.getString("name"));
				System.out.print("Employee Email:");
				System.out.println(resultSet.getString("email"));
				System.out.print("Employee Phone :");
				System.out.println(resultSet.getLong("phone"));
		
			   }
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				System.out.println("Data Display Successfully......");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
}


