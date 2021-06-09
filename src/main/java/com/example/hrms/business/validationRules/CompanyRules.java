package com.example.hrms.business.validationRules;

import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.entities.concretes.Company;

public class CompanyRules {

    public static Result eMailControl(Company company)
    {
        if(!company.getWebAddress().contains(company.getEmail().split("@")[0])){
            return new ErrorResult("Domain hatası");
        }
        return new SuccessResult("Doğru");
    }

}

