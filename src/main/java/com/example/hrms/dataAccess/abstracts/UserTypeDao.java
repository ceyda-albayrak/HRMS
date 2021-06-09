package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeDao extends JpaRepository<UserType,Integer> {
}
