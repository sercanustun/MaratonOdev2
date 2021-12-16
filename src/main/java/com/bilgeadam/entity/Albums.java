package com.bilgeadam.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "album")
public class Albums implements Serializable {
	private static final long serialVersionUID = 4680110603444852272L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "album_id", nullable = false)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "discount")
	private String discount;
	
	@Column(name = "singer")
	private String singer;
	
	@Column(name = "genre")
	private String genre;
	
	@Temporal(value = TemporalType.TIME)
	@CreationTimestamp
	@Column(name = "created_date")
	private Date createdDate;
	
	// parametresiz cons
	public Albums() {
		
	}
	
	// parametreli cons
	public Albums(String name, String price, String discount, String singer, String genre) {
		super();
		this.name = name;
		this.price = price;
		this.discount = discount;
		this.singer = singer;
		this.genre = genre;
	}
	
	// getter setter
	public int getId() {
		return id;
	}
	
	public void setId(int Id) {
		this.id = Id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getDiscount() {
		return discount;
	}
	
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
	public String getSinger() {
		return singer;
	}
	
	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Albums [id=" + id + ", name=" + name + ", price=" + price + ", discount=" + discount + ", singer="
				+ singer + ", genre=" + genre + ", createdDate=" + createdDate + "]";
	}
	
}
