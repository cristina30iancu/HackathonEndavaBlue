package com.example.hackathonendava.repository;

import com.example.hackathonendava.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {

    @Query("SELECT u from Course u where u.user_name = ?1")
    public List<Course> getAllCoursesByUserName(String username);
}
