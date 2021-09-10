package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Professor;


@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
