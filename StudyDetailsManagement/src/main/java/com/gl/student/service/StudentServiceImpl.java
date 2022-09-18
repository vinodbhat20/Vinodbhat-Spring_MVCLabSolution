package com.gl.student.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gl.student.entity.StudentDetails;

@Repository
public class StudentServiceImpl implements StudentService {

	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	StudentServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}

	@Transactional
	public void addStudentDetails(StudentDetails studentDetails) {
		try {
	
			Transaction tsx = session.beginTransaction();

			session.saveOrUpdate(studentDetails);

			tsx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Update existing records into the table.
	@Transactional
	public void updateStudentDetails(StudentDetails studentDetails) {
		Transaction tsx = session.beginTransaction();

		session.saveOrUpdate(studentDetails);

		tsx.commit();

	}

	// Delete existing records from the table.
	@Transactional
	public void deleteStudentDetails(int studentId) {

		Transaction tsx = session.beginTransaction();
		session.delete(studentId);

		tsx.commit();

	}

	@Transactional
	public List<StudentDetails> findAll() {
		Transaction ts = session.beginTransaction();
		List<StudentDetails> studentDetailsList = session.createQuery("StudentDetails").list();
		ts.commit();

		return studentDetailsList;
	}

	@Transactional
	public StudentDetails findStudentDetailsById(int studentId) {
		Transaction ts = session.beginTransaction();
		StudentDetails studentDetails = session.get(StudentDetails.class, studentId);
		ts.commit();
		return studentDetails;
	}

}