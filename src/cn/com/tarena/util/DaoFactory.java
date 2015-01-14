package cn.com.tarena.util;

import cn.com.tarena.dao.StudentDao;
import cn.com.tarena.dao.impl.StudentDaoImpl;

public class DaoFactory {
	
	private static StudentDao studentDao = new StudentDaoImpl();
	
	public static StudentDao getStudentDao(){
		return studentDao;
	}
}
