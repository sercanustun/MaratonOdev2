package com.bilgeadam.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Cd")
public class CdEntity extends Albums {
	private static final long serialVersionUID = 4705198058156197811L;
	
	// parametresiz cons
	public CdEntity() {
		
	}
	
	// parametreli cons
	public CdEntity(String name, String price, String discount, String singer, String genre) {
		super(name, price, discount, singer, genre);
		
	}
	
}
