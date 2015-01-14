package cn.com.tarena.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.com.tarena.pojo.Student;
import cn.com.tarena.service.StudentService;
import cn.com.tarena.util.ConnectionFactory;

public class StudentServiceImpl implements StudentService {

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
	public Student getStudentByUserNameAndPassword(Student paramStudent) {

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		try {
			conn = ConnectionFactory.getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery("select * from student where user_name = '"
					+ paramStudent.getUserName() + "' and password = '"
					+ paramStudent.getPassword() + "'");

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
