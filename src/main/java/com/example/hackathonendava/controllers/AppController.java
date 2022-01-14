package com.example.hackathonendava.controllers;

import com.example.hackathonendava.HackathonEndavaApplication;
import com.example.hackathonendava.model.ImageOCR;
import com.example.hackathonendava.ocr.ImageToText;
import com.example.hackathonendava.registration.User;
import com.example.hackathonendava.registration.UserInfo;
import com.example.hackathonendava.registration.UserInfoService;
import com.example.hackathonendava.registration.UserRepository;
import com.example.hackathonendava.repository.CourseRepository;
import com.example.hackathonendava.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.*;
import java.util.List;

@Controller

public class AppController {

    private String path;
    String res;


    private String currentUser = "none";

    @Autowired
    private UserInfoService userService;

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private TaskRepository taskRepo;
    @Autowired
    private CourseRepository courseRepo;

    private Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    @GetMapping("")
    public ModelAndView viewHomePage(User user) {
        ModelAndView mav = new ModelAndView("home_page");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserInfo) {
            username = ((UserInfo)principal).getUsername();

        } else {
            username = principal.toString();

        }

        //mav.addObject("tasks", taskService.getAllTasksByUserName());
        mav.addObject("currentUser", userRepo.getUserByEmail(username));
        return mav;
    }

    @GetMapping("/home")

    public ModelAndView viewHome() {
            ModelAndView mav = new ModelAndView("home_page");
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = "";
            if (principal instanceof UserInfo) {
                username = ((UserInfo)principal).getUsername();

            } else {
                username = principal.toString();

            }

            //mav.addObject("tasks", taskService.getAllTasksByUserName());
            mav.addObject("currentUser", userRepo.getUserByEmail(username));
            return mav;
    }



    @GetMapping("/notes")
    public ModelAndView viewNotes(Model model) {
        ImageToText imageOCR = new ImageToText();
        imageOCR.setResult("");
        if(path != null) {
            String res = imageOCR.imageToText(path);
        }
        ModelAndView mav = new ModelAndView("notes");
        mav.addObject("imageOCR", imageOCR);
        model.addAttribute("resultText",res);

        return mav;
    }


    @GetMapping("/profile")
    public ModelAndView viewProfile() {
        ModelAndView mav = new ModelAndView("profile");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserInfo) {
            username = ((UserInfo)principal).getUsername();

        } else {
            username = principal.toString();

        }

        //mav.addObject("tasks", taskService.getAllTasksByUserName());
        mav.addObject("profile", userRepo.getUserByEmail(username));
        return mav;
    }

    @RequestMapping( "/image" )
    public String image () {
        return "/image" ;
    }

    @PostMapping ("/upload")
    public RedirectView StringhandleFileUpload (Model model, @RequestParam( "image" ) MultipartFile file ) {
        ImageToText imageOCR = new ImageToText();
        if (!file.isEmpty ()) {
            try {
                BufferedOutputStream out = new BufferedOutputStream (new FileOutputStream(new File(file.getOriginalFilename())));
                out.write(file.getBytes());
                out.flush();
                out.close();

                res = imageOCR.imageToText(file.getOriginalFilename());

            } catch (FileNotFoundException e ) {
                e.printStackTrace ();

            } catch (IOException e ) {
                e .printStackTrace ();
            }
        }
        return new RedirectView("/notes",true);
    }

    @PostMapping ("/uploadProfilePicture")
    public ModelAndView StringhandleUploadProfilePicture (Model model, @RequestParam( "image" ) MultipartFile file ) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserInfo) {
            username = ((UserInfo)principal).getUsername();

        } else {
            username = principal.toString();

        }

        if (!file.isEmpty ()) {
            try {
                BufferedOutputStream out = new BufferedOutputStream (new FileOutputStream(new File("src/main/resources/static/media/" + file.getOriginalFilename())));
                out.write(file.getBytes());
                out.flush();
                out.close();
                model.addAttribute("img","/media/" + file.getOriginalFilename());
                System.out.println(file.getBytes());
                userService.updateUserProfilePicture("/media/" + file.getOriginalFilename(),username);

            } catch (FileNotFoundException e ) {
                e.printStackTrace ();

            } catch (IOException e ) {
                e .printStackTrace ();
            }
        }

        ModelAndView mav = new ModelAndView("profile");
        mav.addObject("profile", userRepo.getUserByEmail(username));

        return mav;
    }

    @GetMapping("/professors")
    public String viewProfessors() {

        return "professors";
    }

    @GetMapping("/quizes")
    public String viewQuizes() {

        return "quizes";
    }
    @GetMapping("/quiz_solve")
    public String viewQuizSolve() {

        return "quiz_solve";
    }

    @GetMapping("/deadlines")
    public String viewDeadlines() {
        return "tasks";
    }



    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "register_form";
    }
    @GetMapping("/login_page")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login_page";
    }
    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);
        try {
            userRepo.save(user);
        }
        catch (Exception e) {
            return "register_error";
        }

        return "login_page";
    }

    @GetMapping({"/management"})
    public ModelAndView listUsers() {
        ModelAndView mav = new ModelAndView("management");
        mav.addObject("listUsers", (List<User>) userRepo.findAll());
        return mav;

    }

}
