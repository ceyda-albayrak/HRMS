package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name="cv_experiences")
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employee"})
public class CvExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int experienceId;

    @Column(name="company_name")
    private String companyName;

    @Column(name="position")
    private String position;

    @Column(name="starting_date")
    private Date startingDate;

    @Column(name="departure_date")
    private Date departureDate;

    @Column(name="cv_id")
    private int cvId;

    @ManyToOne
    @JoinColumn(name="cv_id",updatable = false,insertable = false)
    Employee employee;


}
