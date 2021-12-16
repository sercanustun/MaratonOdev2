package com.bilgeadam.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Dvd")
public class DvdEntity extends Albums {
	private static final long serialVersionUID = 1655990429908264360L;
	
	private String imageQuality;
	
	// parametresiz cons
	public DvdEntity() {
		
	}
	
	// parametreli cons
	public DvdEntity(String name, String price, String discount, String singer, String genre, String imageQuality) {
		super(name, price, discount, singer, genre);
		this.imageQuality = imageQuality;
	}
	
	// getter and setter
	public String getImageQuality() {
		return imageQuality;
	}
	
	public void setImageQuality(String imageQuality) {
		this.imageQuality = imageQuality;
	}
	
}
