package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.CvImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageDao extends JpaRepository<CvImage,Integer> {
}
