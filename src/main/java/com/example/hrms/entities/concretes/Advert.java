package com.example.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name="adverts")
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","city","position","company"})
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int advertId;

    @Column(name="description")
    private String description;


    @Column(name = "company_id")
    private int companyId;


    @Column(name = "city_id")
    private int cityId;


    @Column(name = "position_id")
    private int positionId;

    @Column(name="min_salary")
    private int minSalary;

    @Column(name="max_salary")
    private int maxSalary;

    @Column(name="pos_piece")
    private int posPiece;

    @Column(name="deadline")
    private Date deadline;

    @Column(name="release_date")
    private LocalDate releaseDate=LocalDate.now();

    @Column(name="statu")
    private boolean statu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="city_id",insertable = false,updatable = false)
    private City city;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="company_id",insertable = false,updatable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="position_id",insertable = false,updatable = false)
    private Position position;
}
