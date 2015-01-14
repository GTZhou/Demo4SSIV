package cn.com.tarena.util;

import cn.com.tarena.service.StudentService;
import cn.com.tarena.service.impl.StudentServiceImpl;

public class ServiceFactory {
	
	private static StudentService studentService = new StudentServiceImpl();
	
	public static StudentService getStudentService(){
		return studentService;
	}
	
	
}
