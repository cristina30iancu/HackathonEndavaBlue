package com.example.hackathonendava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Builder
public class ErrorTask {

    private String errorCode;
    private String message;
    private Integer status;


}