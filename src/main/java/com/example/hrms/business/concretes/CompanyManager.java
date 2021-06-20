package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CompanyService;
import com.example.hrms.business.validationRules.CompanyRules;
import com.example.hrms.business.validationRules.EmailRules;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.core.utilities.rules.RunRules;
import com.example.hrms.dataAccess.abstracts.EmployeeDao;
import com.example.hrms.dataAccess.abstracts.CompanyDao;
import com.example.hrms.entities.concretes.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class CompanyManager implements CompanyService {

    private CompanyDao companyDao;
    private EmployeeDao employeeDao;

    @Autowired
    public CompanyManager(CompanyDao companyDao, EmployeeDao employeeDao){
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }
    @Override
    public DataResult<List<Company>> getAll() {
        return new SuccessDataResult<List<Company>>(this.companyDao.findAll());
    }

    @Override
    public Result add(Company company) {
        Result result= RunRules.run(EmailRules.emailFormatControl(company.getEmail()), CompanyRules.eMailControl(company),emailControl(company.getEmail()));
       if(result.isSuccess())
       {
           this.companyDao.save(company);
           return new SuccessResult(result.getMessage());
       }
       return new ErrorResult(result.getMessage());
    }

    private Result emailControl(String email){
        if(employeeDao.findAllByEmail(email).size()!=0)
        {
            return new ErrorResult("Kayıtlı eposta var");
        }
        return new SuccessResult("başarılı");
    }




}
