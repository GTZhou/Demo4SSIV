package cn.com.tarena.service.impl;

import java.util.List;

import cn.com.tarena.pojo.Student;
import cn.com.tarena.service.StudentService;
import cn.com.tarena.util.DaoFactory;

public class StudentServiceImpl implements StudentService {

	@Override
	public List getStudentList() {
		return DaoFactory.getStudentDao().getStudentList();
	}

	@Override
	public Student getStudentByUserNameAndPassword(Student paramStudent) {
		return DaoFactory.getStudentDao().getStudent(
				paramStudent.getUserName(), paramStudent.getPassword());

	}
}
