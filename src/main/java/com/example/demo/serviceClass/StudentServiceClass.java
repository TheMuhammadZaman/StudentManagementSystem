package com.example.demo.serviceClass;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceClass implements StudentService {

	private StudentRepo repo;
	
	public StudentServiceClass(StudentRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<Student> getAllStudents() {
		
		return repo.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		
		return repo.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return repo.save(student);
	}

	@Override
	public void deleteStudentById(Long Id) {
		 repo.deleteById(Id);
	}

	
}
