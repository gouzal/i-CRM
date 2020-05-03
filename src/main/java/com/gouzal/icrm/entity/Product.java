package com.gouzal.icrm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String reference;
	private float purchasePrice;
	private float salePrice;

	@ManyToOne
	private Category category;
    
    /*
    @OneToMany(targetEntity=PurchaseItem.class, mappedBy="article",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PurchaseItem> lstLigneAchat = new ArrayList<>();
    */

}
