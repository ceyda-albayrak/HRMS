package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.EmployeeService;
import com.example.hrms.business.validationRules.EmployeeRules;
import com.example.hrms.business.validationRules.EmailRules;
import com.example.hrms.core.adapers.abstracts.MernisCheckService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.core.utilities.rules.RunRules;
import com.example.hrms.dataAccess.abstracts.EmployeeDao;
import com.example.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {

    private EmployeeDao employeeDao;
    private MernisCheckService mernisCheckService;


    @Autowired
    public EmployeeManager(EmployeeDao employeeDao, MernisCheckService mernisCheckService) {
        this.employeeDao = employeeDao;
        this.mernisCheckService=mernisCheckService;

    }


    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"Başarıyla Listelendi");
    }

    @Override
    public Result add(Employee employee) {
        Result result= RunRules.run(mernisControl(employee),EmployeeRules.nullControl(employee), EmailRules.emailFormatControl(employee.getEmail()),eMailandTcControl(employee.getEmail(),employee.getTcNo()));
        if(result.isSuccess()){
            employeeDao.save(employee);
            return new SuccessResult("Başarılı Kayıt!");
        }
        return new ErrorResult("Başarısız");
    }

    private Result mernisControl(Employee employee){
        if(mernisCheckService.mernisCheck(employee)){
            return new SuccessResult("Başarılı doğrulama");
        }
        return new ErrorResult("Başarısız mernis doğrulaması");
    }

    private Result eMailandTcControl(String email,String tcno){
        if(employeeDao.findAllByEmailAndTcNo(email,tcno).size()!=0){
            return new ErrorResult("Kayıtlı email var");
        }
        return new SuccessResult("Başarılı");
    }
}
