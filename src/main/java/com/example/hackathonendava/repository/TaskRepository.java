package com.example.hackathonendava.repository;

import com.example.hackathonendava.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.security.PublicKey;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {


    @Query("SELECT u from Task u where u.user_name = ?1")
    public List<Task> getAllTasksByUserName(String username);
}
