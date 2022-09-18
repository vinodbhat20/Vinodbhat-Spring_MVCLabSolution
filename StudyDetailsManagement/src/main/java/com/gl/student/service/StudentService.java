package com.gl.student.service;

import java.util.List;

import com.gl.student.entity.StudentDetails;

public interface StudentService {
	
	// Insert new records into the table.
	public void addStudentDetails(StudentDetails studentDetails);

	// Update existing records into the table.
	public void updateStudentDetails(StudentDetails studentDetails);

	// Delete existing records from the table.
	public void deleteStudentDetails(int studentId);

	// Print all records from the table.
	public List<StudentDetails> findAll();
	
	public StudentDetails findStudentDetailsById(int studentId);


}
