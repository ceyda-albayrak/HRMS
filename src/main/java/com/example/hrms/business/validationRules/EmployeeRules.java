package com.example.hrms.business.validationRules;

import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.entities.concretes.Employee;


public class EmployeeRules {


    public static Result nullControl(Employee employee){
        if(employee.getFirstName().isEmpty() ||employee.getLastName().isEmpty() ||employee.getBirthDate().toString().isEmpty() || employee.getTcNo().isEmpty() || employee.getEmail().isEmpty() || employee.getPassword().isEmpty() ){
            return new ErrorResult("Boş bırakma");
        }
        return new SuccessResult("Başarılı");
    }



}
