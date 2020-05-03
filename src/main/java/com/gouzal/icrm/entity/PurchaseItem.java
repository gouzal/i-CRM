package com.gouzal.icrm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private float quantity;
	private float price;

    @ManyToOne
    private Product product;
    
    @ManyToOne
    private Purchase purchase;
    
}
