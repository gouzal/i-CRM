package com.gouzal.icrm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BusinessTier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String CompanyName;
    private String legalType;
    private String mobileNumber;
    private String fixNumber;
    private String email;
    private String ice;
    private String address;

    @ManyToOne
    private City city;
}
