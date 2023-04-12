package com.sapient;

import com.sapient.model.AadharDetails;
import com.sapient.service.ValidateDetails;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        AadharDetails aadharDetails = new AadharDetails();
        try{
            String name;
            String aadharNo;
            name = ValidateDetails.validateName(null);
            LocalDate formattedDate = ValidateDetails.isDateValid(null);
            aadharNo = ValidateDetails.validateAadhar(null);
            System.out.println("your application is successful,and your username is "+aadharDetails.getUserName(name,String.valueOf(formattedDate.getDayOfMonth()),String.valueOf(formattedDate.getYear()),aadharNo));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}