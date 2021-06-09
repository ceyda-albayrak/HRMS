package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Advert;
import com.example.hrms.entities.dtos.AdvertDetailsDto;

import java.util.List;

public interface AdvertService {
    DataResult<List<Advert>> getAll();
    Result add(Advert advert);
    DataResult<List<AdvertDetailsDto>> getAdvertDetails();
    DataResult<List<AdvertDetailsDto>> getAdvertDetailsCompany(int companyId);
    DataResult<List<AdvertDetailsDto>> getAdvertsDate();
    Result closeAdvert(int advertId);
}
