package com.example.hrms.business.concretes;


import com.example.hrms.business.abstracts.UserTypeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.UserTypeDao;
import com.example.hrms.entities.concretes.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeManager implements UserTypeService {
    private UserTypeDao userTypeDao;

    @Autowired
    public UserTypeManager(UserTypeDao userTypeDao) {
        this.userTypeDao = userTypeDao;
    }


    @Override
    public DataResult<List<UserType>> getAll() {
        return new SuccessDataResult<List<UserType>>(this.userTypeDao.findAll(),"Data listelendi");
    }

    @Override
    public Result add(UserType type) {
        this.userTypeDao.save(type);
        return new SuccessResult("Başarıyla eklendi");
    }
}
