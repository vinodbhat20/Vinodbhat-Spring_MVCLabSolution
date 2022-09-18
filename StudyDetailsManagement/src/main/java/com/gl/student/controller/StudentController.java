package com.gl.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.student.entity.StudentDetails;
import com.gl.student.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/update")
	public String updateStudentDetail(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {
		StudentDetails studentDetails = null;
		if (id > 0) {

			studentDetails = studentService.findStudentDetailsById(id);

			if (studentDetails != null) {
				studentDetails.setStudentId(id);

				studentDetails.setName(name);
				studentDetails.setDepartment(department);
				studentDetails.setCountry(country);
				try {
					studentService.addStudentDetails(studentDetails);
				} catch (Exception e) {
					// error handling
				}
			}

		}
		return "redirect:/student/list";

	}

	@PostMapping("/add")
	public String addStudentDetail(@RequestParam("name") String name, @RequestParam("department") String department,
			@RequestParam("country") String country) {
		StudentDetails studentDetails = new StudentDetails();
		studentDetails.setName(name);
		studentDetails.setDepartment(department);
		studentDetails.setCountry(country);
		try {
			studentService.addStudentDetails(studentDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/student/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int studentId) {

		try {
			studentService.deleteStudentDetails(studentId);
		} catch (Exception e) {
			// error handling
		}
		return "redirect:/student/list";

	}

	@RequestMapping("/list")
	public String studentDetailsList(Model model) {

		try {
			List<StudentDetails> list = studentService.findAll();
			model.addAttribute("students", list);

		} catch (Exception e) {
			// error handling
		}
		return "student-details";
	}

}
