package cn.com.tarena.dao;

import java.util.List;

import cn.com.tarena.pojo.Student;

public interface StudentDao {

	public List getStudentList();
	
	public Student getStudent(String userName,String password);
	
}
