package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Repository.ProfessorRepository;
import com.example.demo.models.Professor;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	public Professor getProfessor (Long id) {
		return professorRepository.getOne(id);
	}

	

	public List<Professor> getProfessorList() {
		return professorRepository.findAll();

	}
}
