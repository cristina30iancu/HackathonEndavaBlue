package com.example.hackathonendava.controllers;

import com.example.hackathonendava.model.Course;

import com.example.hackathonendava.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping({"/courses"})
    public ModelAndView showAllCourses() {
        ModelAndView mav = new ModelAndView("courses");
        mav.addObject("courses", courseService.getAllCoursesByUserName());
        return mav;
    }

    @GetMapping("/addCourseForm")
    public ModelAndView addCourseForm() {
        ModelAndView mav = new ModelAndView("add-course-form");
        Course newCourse = new Course();

        mav.addObject("course", newCourse);
        return mav;
    }

    @PostMapping("/saveCourse")
    public String saveTask(@ModelAttribute Course course) {
        try {
            courseService.saveCourse(course);
            return "redirect:/courses";

        }
        catch(Exception e)
        {
            return "/add-course-error";
        }


    }
}
