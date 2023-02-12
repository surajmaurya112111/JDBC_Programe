package com.qsp.employee_crud_opration.service;

import com.qsp.employee_crud_opration.dao.EmployeDao;
import com.qsp.employee_crud_opration.dto.Employee;

public class EmployeeService {
    EmployeDao employeDao=new EmployeDao();
    
	//Insert Employee
	public void insertEmployee(Employee employee)
	{
		
		employeDao.insertEmployee(employee);
	}
	
	//DeleteEmployee
	public void deleteEmployee(int id)
	{
		employeDao.deleteEmployee(id);
	}
	
	//Update Employee
	public void updateEmployee(int id,String name,String email)
	{
		if(employeDao.getById(id)==id)
		{
			employeDao.updateEmployee(id, name, email);
		}else
		{
			System.out.println("Given Id is not present please check Once...");
		}
	}
	
	//Display Employee
		public void employeeDisplay(int id)
		{
			employeDao.employeeDisplay(id);
		}
}
