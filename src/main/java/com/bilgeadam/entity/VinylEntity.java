package com.bilgeadam.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Vinyl")
public class VinylEntity extends Albums {
	private static final long serialVersionUID = -2862198683670049300L;
	
	private String diameter;
	private String speed;
	
	// parametresiz cons
	public VinylEntity() {
	}
	
	// parametreli cons
	public VinylEntity(String name, String price, String discount, String singer, String genre, String diameter,
			String speed) {
		super(name, price, discount, singer, genre);
		this.diameter = diameter;
		this.speed = speed;
	}
	
	// getter and setter
	public String getDiameter() {
		return diameter;
	}
	
	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}
	
	public String getSpeed() {
		return speed;
	}
	
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
