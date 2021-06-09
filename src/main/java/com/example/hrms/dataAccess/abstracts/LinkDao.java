package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.CvLink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkDao extends JpaRepository<CvLink,Integer> {
}
