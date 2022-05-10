package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Subjects;

public interface SubjectsRepo extends JpaRepository<Subjects, Long> {

}
