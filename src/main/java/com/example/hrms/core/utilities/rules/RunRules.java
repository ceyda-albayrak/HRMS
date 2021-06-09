package com.example.hrms.core.utilities.rules;

import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;

public class RunRules {
    public static Result run(Result... things) {
        for(Result thing : things) {
            if(!thing.isSuccess()) {
                return thing;
            }
        }
        return new SuccessResult("Başarılı");
    }
}