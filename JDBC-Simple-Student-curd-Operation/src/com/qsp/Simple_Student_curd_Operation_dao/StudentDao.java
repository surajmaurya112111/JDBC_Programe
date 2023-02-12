package com.qsp.Simple_Student_curd_Operation_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;
import com.qsp.Simple_Student_curd_Operation_dto.Student;

public class StudentDao {

	
	
	//Insert Student methode
	
	public void insertStudent(Student student)
	{
		Connection connection=null;
		//Step1-load the driver class
		try {
//			Driver driver=new Driver();
//			DriverManager.registerDriver(driver);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create Connection
			String url="jdbc:mysql://localhost:3306/jdbc-student-curd-operation-8am";
			String use="root";
			String pass="root";
			
			 connection=DriverManager.getConnection(url, use, pass);
			//Create Statement
			 
			Statement statement= connection.createStatement();
			
			String insert="insert into student values("+student.getsId()+",'"+student.getsName()+"','"+student.getEmail()+"','"+student.getAddress()+"','"+student.getsPhoneNo()+"')";
			  
			//String insert="insert into student values("+student.getsId()+",'"++"')";
			//String insert="insert into student values("+101+")"
			
			//execute query
			
			statement.execute(insert);
			
			
			 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				System.out.println("Data inseted and Conection Close");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	//Student Delete method
	public void deleteStudent(int id)
	{
		Connection connection=null;
		//Step1-load the driver class
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			//Create Connection
			String url="jdbc:mysql://localhost:3306/jdbc-student-curd-operation-8am";
			String use="root";
			String pass="root";
			
			 connection=DriverManager.getConnection(url, use, pass);
			//Create Statement
			 
			Statement statement= connection.createStatement();
			
			String delete="Delete from student where id="+id+"";
			
			//Exequte query 
			
			statement.executeUpdate(delete);
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				System.out.println("Data Deleted....");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//Update Student
	public void updateStudent(int id,String name,String emil)
	{
		Connection connection=null;
		try {
			//Load the Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create Connection
			String url="jdbc:mysql://localhost:3306/jdbc-student-curd-operation-8am";
			String user="root";
			String pass="root";
			
			connection=DriverManager.getConnection(url, user, pass);
					
			//Create Statement
			     Statement statement=connection.createStatement();
			     
			   String update="update student set name='"+name+"',emil='"+emil+"' where id="+id+"";
			   //Exequte Query
			   
			   statement.executeUpdate(update);
			   
			   
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				System.out.println("Data Updated Successfully.........");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			   
	}
// Display Student method
	public List<Student> displayStudent()
	{
		Connection connection=null;
		//Step1-load the driver class
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			//Create Connection
			String url="jdbc:mysql://localhost:3306/jdbc-student-curd-operation-8am";
			String use="root";
			String pass="root";
			
			 connection=DriverManager.getConnection(url, use, pass);
			//Create Statement
			 
			Statement statement= connection.createStatement();
			
			String display="Select * from student";
			
			//Exequte query 
			
			ResultSet resultSet=statement.executeQuery(display);
			
			List<Student> students=new ArrayList<Student>();
			while(resultSet.next())
			{
			  Student student=new Student();
			  int id=resultSet.getInt("id");
			  String name=resultSet.getString("name");
			  String emil=resultSet.getString("emil");
			  String add=resultSet.getString("address");
			  Long phone=resultSet.getLong("phone");
			  
			  student.setsId(id);
			  student.setsName(name);
			  student.setAddress(add);
			  student.setEmail(emil);
			  student.setsPhoneNo(phone);
			  students.add(student);
			}
			return students;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				System.out.println("Data Display Successfully....");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
