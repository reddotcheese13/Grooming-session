package com.sapient.service;

import com.sapient.exceptions.InvalidExperienceException;
import com.sapient.model.TechStack;

public class SalaryCalculator {
    public static void calculateSalary(TechStack stack,int experience,double currentSalary) {
        if(experience>=stack.getExperience()){
            double expectedSalary = currentSalary + (currentSalary * stack.getRole().getIncrement())/(double) 100;
            System.out.println("You can expect Role of "+stack.getRole()+" and salary of "+expectedSalary +" lpa");
        }else{
            throw new InvalidExperienceException("Not enough experience,need minimum experience of "+stack.getExperience()
            );
        }
    }
}
