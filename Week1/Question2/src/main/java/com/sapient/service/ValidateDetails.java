package com.sapient.service;

import com.sapient.exceptions.InvalidAadharException;
import com.sapient.exceptions.InvalidDateException;
import com.sapient.exceptions.InvalidNameException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class ValidateDetails {
    static Scanner sc = new Scanner(System.in);
    final static String DATE_FORMAT = "dd-MM-yyyy";
    public static String validateName(String name){
        try {
            System.out.println("enter your name in format: firstname middlename lastname");
            name=sc.nextLine();
            String trimmedName = name.replaceAll("\\s", "");
            if (trimmedName.length() - name.length() >= 2) {
                throw new InvalidNameException("Maximum number of spaces allowed is 2");
            } else if (trimmedName.length() < 4) {
                throw new InvalidNameException("Minimum number of characters should be 4");
            } else {
                for (int i = 0; i < trimmedName.length(); i++) {
                    if (!Character.isAlphabetic(trimmedName.codePointAt(i))) {
                        throw new InvalidNameException("Only Alphabets are allowed in name");
                    }
                }
            }
        }catch (InvalidNameException e){
            System.out.println(e.getMessage());
            return validateName(name);
        }
        return name;
    }

    public static LocalDate isDateValid(String date)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        try {
            System.out.println("enter your date of birth in format: dd-mm-yy");
            date = sc.nextLine();
            LocalDate ld = LocalDate.parse(date,formatter);
            LocalDate localDate = LocalDate.now().minusYears(18).plusDays(1);
            if(ld.isAfter(localDate)){
                throw new InvalidDateException("you can apply once you are 18 years old");
            }
            return ld;
        } catch ( InvalidDateException e) {
            System.out.println(e.getMessage());
            return isDateValid(date);
        } catch ( Exception e ) {
            System.out.println(e.getMessage() + " enter date in proper format");
            return isDateValid(date);
        }
    }
    public static String validateAadhar(String aadhar){
        try {
            System.out.println("enter your aadhar number");
            aadhar = sc.nextLine();
            aadhar=aadhar.trim();
            if (aadhar.length() != 12) {
                throw new InvalidAadharException("length of aadhar should be 12");
            } else {
                for (int i = 0; i < aadhar.length(); i++) {
                    if (!Character.isDigit(aadhar.charAt(i))) {
                        throw new InvalidAadharException("aadhar should only contain numbers");
                    }
                }
            }
        }catch (InvalidAadharException e){
            System.out.println(e.getMessage());
            validateAadhar(aadhar);
        }
        return aadhar;
    }
}
