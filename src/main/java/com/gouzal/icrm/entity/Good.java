package com.gouzal.icrm.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("good")
public class Good extends Product{
}
