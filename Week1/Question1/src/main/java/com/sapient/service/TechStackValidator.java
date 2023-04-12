package com.sapient.service;

import com.sapient.exceptions.InvalidExperienceException;
import com.sapient.exceptions.InvalidRoleException;
import com.sapient.model.TechStack;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TechStackValidator {
    static Scanner sc=new Scanner(System.in);
    public static void techStackValidator(String techStack){
        try {
            System.out.println("enter techStack of the role you want to apply");
            techStack = sc.nextLine();
            boolean flag=false;
            for (TechStack stack : TechStack.values()) {
                if (techStack.equalsIgnoreCase(stack.name())) {
                    flag=true;
                    String experience = "";
                    String salary="";
                    int exp = experienceValidator(experience);
                    double currentSalary = salaryValidator(salary);
                    SalaryCalculator.calculateSalary(stack, exp, currentSalary);
                }
            }

            if(!flag)throw new InvalidRoleException("Sorry,the tech stack you have entered is not available");
        }catch (InvalidRoleException e){
            System.out.println(e.getMessage());
            techStackValidator(techStack);
        }
    }

    public static int experienceValidator(String experience){
        System.out.println("enter your experience in years");
        try {
            Pattern p = Pattern.compile("^[1-9][0-9]?$|^100$");
            experience = sc.nextLine();
            Matcher matcher = p.matcher(experience);
            if(!matcher.matches()){
                throw new InvalidExperienceException("the number should be in between 1 to 100 and shouldn't contain special characters");
            } 
        }catch (InvalidExperienceException e){
            System.out.println(e.getMessage());
            return experienceValidator(experience);
        }
        return Integer.parseInt(experience);
    }

    public static double salaryValidator(String salary){
        System.out.println("enter your salary in lpa");
        double sal = 0;
        try {
            salary=sc.nextLine();
            sal = Double.parseDouble(salary);
            return sal;
        }catch (InvalidExperienceException e){
            System.out.println(e.getMessage());
            return salaryValidator(salary);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return salaryValidator(salary);
        }
    }
}
