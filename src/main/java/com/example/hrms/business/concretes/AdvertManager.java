package com.example.hrms.business.concretes;


import com.example.hrms.business.abstracts.AdvertService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.AdvertDao;
import com.example.hrms.entities.concretes.Advert;
import com.example.hrms.entities.dtos.AdvertDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertManager implements AdvertService {

    private AdvertDao advertDao;

    @Autowired
    public AdvertManager(AdvertDao advertDao) {
        this.advertDao = advertDao;
    }

    @Override
    public DataResult<List<Advert>> getAll() {
        return new SuccessDataResult<List<Advert>>(this.advertDao.findAll(),"Data listelendi");
    }

    @Override
    public Result add(Advert advert) {
        this.advertDao.save(advert);
        return new SuccessResult("İlan Eklendi");
    }

    @Override
    public DataResult<List<AdvertDetailsDto>> getAdvertDetails() {
        return new SuccessDataResult<List<AdvertDetailsDto>>(this.advertDao.getAdvertDetails(true),"Data Listelendi");
    }

    @Override
    public DataResult<List<AdvertDetailsDto>> getAdvertDetailsCompany(int companyId) {
        return new SuccessDataResult<List<AdvertDetailsDto>>(this.advertDao.getAdvertDetailsCompany(companyId));
    }

    @Override
    public DataResult<List<AdvertDetailsDto>> getAdvertsDate() {
        return new SuccessDataResult<List<AdvertDetailsDto>>(this.advertDao.getAdvertsDate());
    }

    @Override
    public Result closeAdvert(int advertId) {
        this.advertDao.closeAdvert(advertId);
        return new SuccessResult("İlan kapandı");
    }


}
