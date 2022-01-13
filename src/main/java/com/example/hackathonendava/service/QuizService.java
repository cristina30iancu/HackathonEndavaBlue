package com.example.hackathonendava.service;

import com.example.hackathonendava.exception.NotFoundException;
import com.example.hackathonendava.model.*;
import com.example.hackathonendava.registration.User;
import com.example.hackathonendava.registration.UserInfo;
import com.example.hackathonendava.registration.UserRepository;
import com.example.hackathonendava.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class QuizService {

    @Autowired
    Question question;
    @Autowired
    QuestionForm qForm;
    @Autowired
    QuestionRepo qRepo;
    @Autowired
    QuestionMathRepo qMathRepo;
    @Autowired
    Result result;
    @Autowired
    ResultRepo rRepo;
    @Autowired
    UserRepository userRepo;
    @Autowired
    QuestionMathForm qMathForm;


    public QuestionForm getQuestions() {
        List<Question> allQues = qRepo.findAll();
        List<Question> qList = new ArrayList<Question>();
        Random random = new Random();

        for(int i=0; i<5; i++) {
            int rand = random.nextInt(allQues.size());
            qList.add(allQues.get(rand));
            allQues.remove(rand);
        }

        qForm.setQuestions(qList);

        return qForm;
    }

    public void updateUserMathScore(int score, String email) {
        User user = userRepo.getUserByEmail(email);
        user.setMathPoints(score);
        userRepo.save(user);
    }

    public void updateUserCSSScore(int score, String email) {
        User user = userRepo.getUserByEmail(email);
        user.setCsPoints(score);
        userRepo.save(user);
    }

    public QuestionMathForm getQuestionsMath(){
        List<QuestionMath> allQues = qMathRepo.findAll();
        List<QuestionMath> qList = new ArrayList<QuestionMath>();
        Random random = new Random();

        for(int i=0; i<5; i++) {
            int rand = random.nextInt(allQues.size());
            qList.add(allQues.get(rand));
            allQues.remove(rand);
        }

        qMathForm.setQuestionsMath(qList);

        return qMathForm;
    }

    public String getUsername(){
        List<User> users = (List<User>) userRepo.findAll();
        String username = users.get(0).getFirstName() + users.get(0).getLastName();
        return username;
    }

    public int getResult(QuestionForm qForm) {
        int correct = 0;

        for(Question q: qForm.getQuestions())
            if(q.getAns() == q.getChose())
                correct++;

        return correct;
    }

    public int getResultMath(QuestionMathForm qMathForm) {
        int correct = 0;

        for(QuestionMath q: qMathForm.getQuestionsMath())
            if(q.getAns() == q.getChose())
                correct++;

        return correct;
    }


    public void saveScore(Result result) {
        Result saveResult = new Result();
        saveResult.setUsername(result.getUsername());
        saveResult.setTotalCorrect(result.getTotalCorrect());
        rRepo.save(saveResult);
    }

    public List<Result> getTopScore() {
        List<Result> sList = rRepo.findAll(Sort.by(Sort.Direction.DESC, "totalCorrect"));

        return sList;
    }
}