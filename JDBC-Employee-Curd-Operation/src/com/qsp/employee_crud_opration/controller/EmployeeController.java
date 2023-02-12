package com.qsp.employee_crud_opration.controller;

import com.qsp.employee_crud_opration.dao.EmployeDao;
import com.qsp.employee_crud_opration.dto.Employee;
import com.qsp.employee_crud_opration.service.EmployeeService;

public class EmployeeController {

	public static void main(String[] args) {
	
		System.out.println("Statrt Main Method");
		EmployeDao employeDao=new EmployeDao();
		
		Employee employee=new Employee();
		EmployeeService employeeService=new EmployeeService();
		
		employee.setId(101);
		employee.setName("Schin");
		employee.setEmail("shin@gmail.com");
		employee.setPhone(1234567891l);
		
		employeeService.insertEmployee(employee);
		
		System.out.println("End main Method");
	}
}
