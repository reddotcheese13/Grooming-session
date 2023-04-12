package com.sapient;

import com.sapient.service.TechStackValidator;

/*
* enter experience in years
* TechStacks available are JAVA,QA,SAP
* enter current salary in lpa
* */
public class Main {
    public static void main(String[] args) throws IllegalArgumentException {
        String techStack="";
        try{
            TechStackValidator.techStackValidator(techStack);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}