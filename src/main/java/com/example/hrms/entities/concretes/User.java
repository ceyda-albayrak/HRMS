package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int userId;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="usertype_id")
    private int userTypeId;


    @OneToOne(mappedBy = "user" ,optional = false,fetch = FetchType.LAZY)
    @JsonIgnore
    private CvImage images;


}
