package com.example.hackathonendava.controllers;

import com.example.hackathonendava.model.QuestionForm;
import com.example.hackathonendava.model.QuestionMathForm;
import com.example.hackathonendava.model.Result;
import com.example.hackathonendava.registration.UserInfo;
import com.example.hackathonendava.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class QuizController {

    @Autowired
    Result result;
    @Autowired
    QuizService qService;

    Boolean submitted = false;

    @ModelAttribute("result")
    public Result getResult() {
        return result;
    }




    @RequestMapping(value="/quiz_math")
    public String quizMath(Model m, RedirectAttributes ra) {
        submitted = false;

        String username = qService.getUsername();
        result.setUsername(username);

        QuestionMathForm qMathForm = qService.getQuestionsMath();
        m.addAttribute("qMathForm", qMathForm);

        return "quiz_math.html";
    }

    @RequestMapping(value="/quiz_cs")
    public String quizCs(Model m, RedirectAttributes ra) {
        submitted = false;

        String username = qService.getUsername();
        result.setUsername(username);

        QuestionForm qForm = qService.getQuestions();
        m.addAttribute("qForm", qForm);

        return "quiz_cs.html";
    }

    @PostMapping("/submit")
    //@RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submit(@ModelAttribute("qForm") QuestionForm qForm, Model m) {
        if(!submitted) {
            result.setTotalCorrect(qService.getResult(qForm));
            qService.saveScore(result);
            submitted = true;
        }

        m.addAttribute("result", result);

        return "result.html";
    }

    @PostMapping("/submit_math")
    //@RequestMapping(value = "/submit", method = RequestMethod.POST)

    public String submitMath(@ModelAttribute("qMathForm") QuestionMathForm qForm, Model m) {
        if(!submitted) {
            result.setTotalCorrect(qService.getResultMath(qForm));
            qService.saveScore(result);
            submitted = true;
        }

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        int oldScore = 0;
        if (principal instanceof UserInfo) {
            username = ((UserInfo)principal).getUsername();
            oldScore = ((UserInfo)principal).getMathScore();

        } else {
            username = principal.toString();
        }


        qService.updateUserMathScore(oldScore + result.getTotalCorrect(),username);
        m.addAttribute("result", result);

        return "result.html";
    }

    @GetMapping("/score")
    public String score(Model m) {
        List<Result> sList = qService.getTopScore();
        m.addAttribute("sList", sList);



        return "scoreboard.html";
    }

}