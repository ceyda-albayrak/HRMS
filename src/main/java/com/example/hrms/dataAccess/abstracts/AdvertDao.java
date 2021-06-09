package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Advert;
import com.example.hrms.entities.dtos.AdvertDetailsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AdvertDao extends JpaRepository<Advert,Integer> {


    @Query("Select new com.example.hrms.entities.dtos.AdvertDetailsDto" +
            "(a.advertId, c.companyName, p.position, a.posPiece, a.releaseDate, a.deadline, a.statu)"+
            "From Advert a inner join a.company c inner join a.position p")
    List<AdvertDetailsDto> getAdvertDetails(boolean statu);

    @Query("Select new com.example.hrms.entities.dtos.AdvertDetailsDto" +
            "(a.advertId, c.companyName, p.position, a.posPiece, a.releaseDate, a.deadline, a.statu)"+
            "From Advert a inner join a.company c inner join a.position p where a.companyId=:companyId")
    List<AdvertDetailsDto> getAdvertDetailsCompany(int companyId);

    @Query("Select new com.example.hrms.entities.dtos.AdvertDetailsDto" +
            "(a.advertId, c.companyName, p.position, a.posPiece, a.releaseDate, a.deadline, a.statu)"+
            "From Advert a inner join a.company c inner join a.position p where a.statu=true order by a.releaseDate desc")
    List<AdvertDetailsDto> getAdvertsDate();

    @Transactional
    @Modifying
    @Query("update Advert a set a.statu = false  where a.advertId = :advertId")
    void closeAdvert(@Param("advertId") int advertId);



}
