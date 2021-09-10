package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Professor;
import com.example.demo.service.ProfessorService;

@RestController
@RequestMapping("/api/v1/professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	
	@GetMapping
	@RequestMapping("{id}")
	public Professor get(@PathVariable Long id) {
		return professorService.getProfessor(id);

	}

	
	@GetMapping
	public List<Professor> list() {
		return professorService.getProfessorList();

	}
	
}
