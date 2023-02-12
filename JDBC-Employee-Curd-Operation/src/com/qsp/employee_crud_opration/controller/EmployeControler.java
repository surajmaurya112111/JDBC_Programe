package com.qsp.employee_crud_opration.controller;

import java.util.Scanner;

import com.qsp.employee_crud_opration.dao.EmployeDao;
import com.qsp.employee_crud_opration.dto.Employee;
import com.qsp.employee_crud_opration.service.EmployeeService;

public class EmployeControler {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);

		Employee employee=null;

		EmployeeService es=new EmployeeService();
		EmployeDao employeeDao=new EmployeDao();

		while(true) {
			System.out.println("1.insert\n2.Delete\n3.Update\n4.Display\n5.Exit");
			System.out.println("Enter your choice");

			int ch=sc.nextInt();

			switch(ch) {

			case 1:{
				employee=new Employee();
				System.out.println("enter the employee Id");
				employee.setId(sc.nextInt());

				System.out.println("enter the employee Name");
				employee.setName(sc.next());

				System.out.println("enter the employee Email");
				employee.setEmail(sc.next());

				System.out.println("enter the employee phone");
				employee.setPhone(sc.nextLong());

				es.insertEmployee(employee);
			}
			break;

			case 2:
			{
				employee=new Employee();
				System.out.println("enter the employee Id");

				es.deleteEmployee(sc.nextInt());



			}break;

			case 3:
			{
				System.out.println("Enter the employee Id to update the data..");
				int id=employeeDao.getById(sc.nextInt());
				int id1=0;
				if(id!=0)
				{
					id1=id;

				}else
				{
					System.out.println("Given Id is Not Present");
				}
				System.out.println("Enter your new Employee Name");
				String name=sc.next();
				System.out.println("Enter the new Employee Email");
				String  email=sc.next();

				es.updateEmployee(id1, name, email);
			}break;
			case 4:
			{
				System.out.println("Enter the id to diaplay data");
				int id=sc.nextInt();

				es.employeeDisplay(id);
			}break;
			}

		}
	}
}
