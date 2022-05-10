package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.demo.model.Subjects;
import com.example.demo.service.SubjectsService;

@Controller
public class SubjectsController {
	@Autowired

	private SubjectsService subjectsService;
	
	public SubjectsController(SubjectsService subjectsService) {
		super();
		this.subjectsService = subjectsService;
	}
	@GetMapping("/subjects")
	public String getSubject(Model model) {
		model.addAttribute("subjects", subjectsService.getAllSubjects());
		return "subjects";
	}
	@GetMapping("/subjects/new")
	public String createSubject(Model model) {
		Subjects subjects = new Subjects();
		model.addAttribute("subjects", subjects);
		return "create_subjects";
	}
	@PostMapping("/subjects")
	public String saveSubjects(@ModelAttribute("subjects") Subjects subjects) {
		subjectsService.saveSubject(subjects);
		return "redirect:/subjects";
	}
	@GetMapping("/subjects/edit/{id}")
	public String editSubjectForm(@PathVariable Long id , Model model) {
		model.addAttribute("subject",subjectsService.getSubjectById(id));
		return "edit_subject";
	}
	@PostMapping("/subjects/{id}")
	public String updateSubject(@PathVariable Long id , @ModelAttribute ("subject") Subjects subjects, Model model) {
		//Get Student from database
		Subjects existingSubjects = subjectsService.getSubjectById(id);
		existingSubjects.setId(id);
		existingSubjects.setSubjectName(subjects.getSubjectName());
		
		//Save Updated Student Object
		subjectsService.updateSubject(existingSubjects);
		return "redirect:/subjects";
	}
	@GetMapping("/subjects/{id}")
	public String deleteSubjects(@PathVariable Long id) {
		subjectsService.deleteSubjectById(id);
		return "redirect:/subjects";
	}
}
