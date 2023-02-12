package com.qsp.Simple_Student_curd_Operation_controller;

import java.util.List;
import java.util.Scanner;

import com.qsp.Simple_Student_curd_Operation_dto.Student;
import com.qsp.Simple_Student_curd_Operation_service.StudentService;

public class StudentController {

	public static void main(String[] args) {
        
		Scanner scanner=new Scanner(System.in);
		
		Student student=new Student();
		
		StudentService studentService=new StudentService();
		while(true)
		{
			System.out.println("1.Insert\n2.Delete\n3.Update\n4Display\n5Exit");
			System.out.println("Eneter yoyr choice");
			
			int n=scanner.nextInt();
			
			switch(n) {
			
			case 1:
			{
				student=new Student();
				
				System.out.println("Enter the Student Id");
				student.setsId(scanner.nextInt());
				
				System.out.println("Enter the Student Name:");
				student.setsName(scanner.next());
				
				System.out.println("Entre the Student Email");
				student.setEmail(scanner.next());
				
				System.out.println("Enter the Student Address");
			
				student.setAddress(scanner.next());
				
				System.out.println("Eneter the Student Phone Number:");
				student.setsPhoneNo(scanner.nextLong());
				
				studentService.insertStudent(student);
			}break;
			
			case 2:
			{
				student=new Student();
				
				System.out.println("Enter the Student id");
				int id=scanner.nextInt();
				studentService.deleteStudent(id);
			}break;
			case 3:{
				    student=new Student();
				    System.out.println("Enter the Student id:");
				    int id=scanner.nextInt();
				    System.out.println("Enter the Student name");
				    String name=scanner.next();
				    System.out.println("Enter the Student email");
				    String emil=scanner.next();
				    
				    studentService.updateStudent(id, name, emil);
			}break;
			
			case 4:
			{
				List<Student> students=studentService.displayStudent();
				
				for (Student student2 : students) {
					
					System.out.println("Student id =" +student2.getsId());
					System.out.println("Student name =" +student2.getsName());
					System.out.println("Student add =" +student2.getAddress());
					System.out.println("Student phone =" +student2.getsPhoneNo());
					System.out.println("Student email =" +student2.getEmail());
					
					System.out.println("======================================");
				}
			}break;
			case 5:
			{
				System.exit(n);;
				System.out.println("Program terminated......");
			}
			}
		}
	}

}
