package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


//JPARESPOSİTORY-> verdiğin nesne için pkey alanını da verince neyin sorgulanacagını belirtmiş oluyoruz.EntityRepositoryBase gibi..
public interface PositionDao extends JpaRepository<Position,Integer> {
    List<Position> findAllByPosition(String position);
}
