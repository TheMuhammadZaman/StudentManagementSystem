package com.example.demo.serviceClass;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.model.Subjects;
import com.example.demo.repository.SubjectsRepo;
import com.example.demo.service.SubjectsService;

@Service
public class SubjectsServiceClass implements SubjectsService {

	private SubjectsRepo repository;
	
	

	public SubjectsServiceClass(SubjectsRepo repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<Subjects> getAllSubjects() {
		
		return repository.findAll();
	}

	@Override
	public Subjects saveSubject(Subjects subject) {
		return repository.save(subject);
	}

	@Override
	public Subjects getSubjectById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public Subjects updateSubject(Subjects subject) {
		
		return repository.save(subject);
	}

	@Override
	public void deleteSubjectById(Long Id) {
		repository.deleteById(Id);
		
	}


	
}
