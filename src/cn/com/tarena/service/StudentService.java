package cn.com.tarena.service;

import java.util.List;

import cn.com.tarena.pojo.Student;

public interface StudentService {

	public List getStudentList();

	public Student getStudentByUserNameAndPassword(Student paramStudent);
}
