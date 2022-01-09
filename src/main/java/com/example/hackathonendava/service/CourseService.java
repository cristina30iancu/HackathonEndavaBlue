package com.example.hackathonendava.service;

import com.example.hackathonendava.exception.NotFoundException;
import com.example.hackathonendava.model.Course;
import com.example.hackathonendava.registration.UserInfo;
import com.example.hackathonendava.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private Logger logger = LoggerFactory.getLogger(TaskService.class);
    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllTasks(){
        return courseRepository.findAll();
    }

    public List<Course> getAllCoursesByUserName(){

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserInfo) {
            username = ((UserInfo)principal).getUsername();

        } else {
            username = principal.toString();

        }
        return courseRepository.getAllCoursesByUserName(username);
    }

    public Course getCourse(Long id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        return optionalCourse.orElseThrow(() -> new NotFoundException("Course not found!", "course.not.found"));
    }

    public Course saveCourse(Course course) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserInfo) {
            username = ((UserInfo)principal).getUsername();

        } else {
            username = principal.toString();

        }

        course.setUser_name(username);
        return courseRepository.save(course);
    }
}
