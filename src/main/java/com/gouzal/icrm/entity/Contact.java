package com.gouzal.icrm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact extends Person {

    private String cellPhone;
    private String phone;
    private String professionalEmail;
}
