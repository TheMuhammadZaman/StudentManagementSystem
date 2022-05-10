package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
// Made with Great Efforts
@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	public StudentController() {
	}

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	
	 @GetMapping("/students") 
	 public String getHome(Model model) {
		 model.addAttribute("student", studentService.getAllStudents());
	     return "students"; 
	 }
	 
	@GetMapping("/students/new")
	public String createStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
		// Get Student from database
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		// Save Updated Student Object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}

	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}

	@GetMapping("/departments")
	public String showDeptt() {
		return "departments";
	}

	@GetMapping("/teachers")
	public String showTeachers() {
		return "teachers";
	}

	@GetMapping("/classes")
	public String showClasses() {
		return "classes";
	}

	@GetMapping("/admin")
	public String goAdmin() {
		return "admin";
	}

	/**********************************************************************/

}
