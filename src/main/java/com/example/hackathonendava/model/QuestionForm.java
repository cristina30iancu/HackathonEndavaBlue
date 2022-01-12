package com.example.hackathonendava.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionForm {

    private List<Question> questions;
    public List<QuestionMath> questions_math;

    public List<Question> getQuestions() {
        return questions;
    }
    public List<QuestionMath> getQuestionsMath(){return questions_math;}

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void setQuestionsMath(List<QuestionMath> questions_math) {
        this.questions_math = questions_math;
    }
}