package com.gouzal.icrm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "PST")
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date purchaseDate;

    @ManyToOne
	private Provider provider;
    
    @OneToMany(targetEntity= PurchaseItem.class, mappedBy="purchase",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PurchaseItem> listPurchaseItem = new ArrayList<>();
    
}
