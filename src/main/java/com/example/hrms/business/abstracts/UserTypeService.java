package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.UserType;

import java.util.List;

public interface UserTypeService {
    DataResult<List<UserType>> getAll();
    Result add(UserType type);
}
