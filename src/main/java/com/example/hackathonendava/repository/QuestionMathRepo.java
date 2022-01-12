package com.example.hackathonendava.repository;

import com.example.hackathonendava.model.Question;
import com.example.hackathonendava.model.QuestionMath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionMathRepo extends JpaRepository<QuestionMath, Integer> {
}
