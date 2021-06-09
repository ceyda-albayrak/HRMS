package com.example.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertDetailsDto {
    private int id;
    private String companyName;
    private String position;
    private int posPiece;
    private LocalDate releaseDate;
    private Date deadline;
    private boolean statu;
}
