package com.example.hackathonendava.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionMathForm {

    public List<QuestionMath> questions_math;

    public List<QuestionMath> getQuestionsMath(){return questions_math;}

    public void setQuestionsMath(List<QuestionMath> questions_math) {
        this.questions_math = questions_math;
    }
}