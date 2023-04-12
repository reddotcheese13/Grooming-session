package com.sapient.model;


public class AadharDetails {
    public String getUserName(String name,String date,String year,String aadharNo){
        String trimmedName = name.replaceAll("\\s", "");
        return trimmedName.substring(0,4)+ date +year+aadharNo.substring(8);
    }
}
