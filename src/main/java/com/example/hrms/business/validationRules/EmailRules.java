package com.example.hrms.business.validationRules;

import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailRules {
    public static Result emailFormatControl(String email){
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        //Regex to restrict no. of characters in top level domain [Recommended]
        //Source : https://howtodoinjava.com/java/regex/java-regex-validate-email-address/

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.find()){
            return new SuccessResult("Doğru format");
        }
        return new ErrorResult("Hatalı format");
    }
}
