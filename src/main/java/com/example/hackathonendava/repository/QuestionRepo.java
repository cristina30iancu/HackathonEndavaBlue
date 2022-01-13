package com.example.hackathonendava.repository;

import com.example.hackathonendava.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {

    @Query("SELECT q from Question q WHERE q.type = ?1")
    public List<Question> findAllByType (String type);
}