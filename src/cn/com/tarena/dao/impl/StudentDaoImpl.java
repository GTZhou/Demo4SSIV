package cn.com.tarena.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.com.tarena.dao.StudentDao;
import cn.com.tarena.pojo.Student;
import cn.com.tarena.util.ConnectionFactory;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List getStudentList() {
		List studentList = new ArrayList();

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		try {
			conn = ConnectionFactory.getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery("select * from student");

			while (rs.next()) {
				Student student = new Student();

				student.setUserName(rs.getString("USER_NAME"));
				student.setPassword(rs.getString("PASSWORD"));
				student.setGender(rs.getString("PROVINCE"));
				student.setProvince(rs.getString("GENDER"));
				student.setHobbies(rs.getString("HOBBIES"));

				studentList.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error when querying students!", e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("error when querying students!", e);
			}
		}
		
		return studentList;
	}

	@Override
	public Student getStudent(String userName, String password) {
		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		try {
			conn = ConnectionFactory.getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery("select * from student where user_name = '"
					+ userName + "' and password = '"
					+ password + "'");

			if (rs.next()) {
				Student student = new Student();

				student.setUserName(rs.getString("USER_NAME"));
				student.setPassword(rs.getString("PASSWORD"));
				student.setGender(rs.getString("PROVINCE"));
				student.setProvince(rs.getString("GENDER"));
				student.setHobbies(rs.getString("HOBBIES"));

				return student;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error when querying students!", e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("error when querying students!", e);
			}
		}

		return null;
	}

}
