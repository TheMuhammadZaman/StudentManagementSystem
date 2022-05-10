package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Subjects;

public interface SubjectsService {
	
	List<Subjects> getAllSubjects();
	Subjects saveSubject(Subjects subject);
	Subjects getSubjectById(Long id);
	Subjects updateSubject(Subjects subject);
	void deleteSubjectById(Long Id);
}
