package com.qsp.Simple_Student_curd_Operation_service;

import java.util.List;
import com.qsp.Simple_Student_curd_Operation_dao.StudentDao;
import com.qsp.Simple_Student_curd_Operation_dto.Student;

public class StudentService {

	StudentDao studentDao=new StudentDao();
	public void insertStudent(Student student)
	{
	    studentDao.insertStudent(student);	
	}
	
	public void deleteStudent(int id)
	{
		studentDao.deleteStudent(id);
	}
	public void updateStudent(int id,String name,String emil)
	{
		studentDao.updateStudent(id, name, emil);
	}
	public List<Student> displayStudent()
	{
		return studentDao.displayStudent();
	}
}
