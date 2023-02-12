package com.jsp.jdbc_prepared_statement_curd_operation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.jdbc_prepared_statement_curd_operation.dto.Mobile;

public class MobileDao {

	//InsertMethod
	public void insertMobile(Mobile mobile)
	{
		
		try {
			//Load the Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create Connection
			String url="jdbc:mysql://localhost:3306/Jdbc-prepare-statement-mobile-curd-operation-8AM";
			String user="root";
			String pass="root";
			
			Connection connection=DriverManager.getConnection(url, user, pass);
			
			String insert="insert into mobile values(?,?,?,?)";
			//Create the Prepared Statment
			
			
			PreparedStatement preparedStatement=connection.prepareStatement(insert);
			
			preparedStatement.setInt(1, mobile.getMobileId());
			preparedStatement.setString(2, mobile.getMobileName());
			preparedStatement.setString(3, mobile.getMobileModel());
			preparedStatement.setDouble(4, mobile.getMobilePrice());
			
			preparedStatement.execute();
			
			
			System.out.println("Data Inserted............");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Get By Id mehtod
	public int getById(int id)
	{
		int id1=0;
		Connection connection=null;
		try {
			//Load the Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create Connection
			String url="jdbc:mysql://localhost:3306/Jdbc-prepare-statement-mobile-curd-operation-8AM";
			String user="root";
			String pass="root";
			
			 connection=DriverManager.getConnection(url, user, pass);
			 
			 String getById="Select * from mobile where mobileId= ?";
			 
			 //Create Prepare Statement
			 PreparedStatement preparedStatement=connection.prepareStatement(getById);
			 
			 preparedStatement.setInt(1, id);
			 
			 ResultSet resultSet=preparedStatement.executeQuery();
			 while(resultSet.next())
			 {
				 id1=resultSet.getInt("mobileId");
			 }
			 return id1;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	//Update mobile method
	public void update(int mobileId, String mobileName, String mobileModel)
	{
		Connection connection=null;
		try {
			//Load the Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create Connection
			String url="jdbc:mysql://localhost:3306/Jdbc-prepare-statement-mobile-curd-operation-8AM";
			String user="root";
			String pass="root";
			
			 connection=DriverManager.getConnection(url, user, pass);
			 
			 String update="update mobile set mobileName=?, mobileModel=? where mobileId=?";
			 
			 //Create Prepare Statement
			 PreparedStatement preparedStatement=connection.prepareStatement(update);
			 
			 preparedStatement.setString(1, mobileName);
			 preparedStatement.setString(2, mobileModel);
			 preparedStatement.setInt(3, mobileId);
			 //Execute query 
			 preparedStatement.executeUpdate();
			 
		}catch (Exception e) {
         e.printStackTrace();   
		}
	}
	//Delete method of mobile
	
	public void delete(int id)
	{
		Connection connection=null;
		try {
			//Load the Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create Connection
			String url="jdbc:mysql://localhost:3306/Jdbc-prepare-statement-mobile-curd-operation-8AM";
			String user="root";
			String pass="root";
			
			 connection=DriverManager.getConnection(url, user, pass);
			 
			 String delete="delete from mobile where mobileId=?";
			 
			 PreparedStatement preparedStatement=connection.prepareStatement(delete);
			 
			 preparedStatement.setInt(1, id);
			 
			 System.out.println("Data Deleted....");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//Display Method
	public List<Mobile> getAllMobile()
	{
		try {
			//Load the Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create Connection
			String url="jdbc:mysql://localhost:3306/Jdbc-prepare-statement-mobile-curd-operation-8AM";
			String user="root";
			String pass="root";
			
			Connection connection=DriverManager.getConnection(url, user, pass);
			
			String select="Select * from mobile";
			
			//Create Prepare Statement
			
			PreparedStatement preparedStatement=connection.prepareStatement(select);
		    
			List<Mobile> mobiles=new ArrayList<Mobile>();
			ResultSet resultSet=preparedStatement.executeQuery();
			
			
			while(resultSet.next())
			{
				Mobile mobile=new Mobile();
				
				mobile.setMobileId(resultSet.getInt("MobileId"));
				mobile.setMobileName(resultSet.getString("mobileName"));
				mobile.setMobileModel(resultSet.getString("MobileModel"));
				mobile.setMobilePrice(resultSet.getDouble("mobilePrice"));
				
				mobiles.add(mobile);
			}
			
		    return mobiles;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	//Add Batch and executeBatch
	public void insertMobileExecution(List<Mobile> mobiles)
	
	{
		try {
			//Load the Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create Connection
			String url="jdbc:mysql://localhost:3306/Jdbc-prepare-statement-mobile-curd-operation-8AM";
			String user="root";
			String pass="root";
			
			Connection connection=DriverManager.getConnection(url, user, pass);
			
			PreparedStatement preparedStatement=null;
			String insertMobileData="insert into mobile values(?,?,?,?)";
			preparedStatement=connection.prepareStatement(insertMobileData);
			
			for (Mobile mobile : mobiles) {
							
				preparedStatement.setInt(1, mobile.getMobileId());
				preparedStatement.setString(2, mobile.getMobileName());
				preparedStatement.setString(3, mobile.getMobileModel());
				preparedStatement.setDouble(4, mobile.getMobilePrice());
				
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
 