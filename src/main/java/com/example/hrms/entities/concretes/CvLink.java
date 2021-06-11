package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@Table(name="cv_links")
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employee"})
public class CvLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int linkId;

    @Column(name="github")
    private String github;

    @Column(name="linkedin")
    private String linkedin;

    @Column(name="cv_id")
    private int cvId;

    @ManyToOne
    @JoinColumn(name="cv_id",updatable = false,insertable = false)
    Employee employee;


}
