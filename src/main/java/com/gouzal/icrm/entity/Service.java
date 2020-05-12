package com.gouzal.icrm.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("service")
public class Service extends Product {
}
