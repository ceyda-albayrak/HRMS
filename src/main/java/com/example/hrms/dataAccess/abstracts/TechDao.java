package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.CvTechnology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechDao extends JpaRepository<CvTechnology,Integer> {
}
