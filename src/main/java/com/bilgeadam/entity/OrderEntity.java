package com.bilgeadam.entity;

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
@Table(name = "Orders")
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id", nullable = false)
	private int orderId;
	
	@Column(name = "order_name", nullable = false)
	private String orderName;
	
	@Column(name = "order_price", nullable = false)
	private String orderPrice;
	
	@Column(name = "order_adress", nullable = false)
	private String orderAdress;
	
	@Temporal(value = TemporalType.TIME)
	@CreationTimestamp
	@Column(name = "created_date")
	private Date createdDate;
	
	public OrderEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderEntity(String orderName, String orderPrice, String orderAdress) {
		super();
		this.orderName = orderName;
		this.orderPrice = orderPrice;
		this.orderAdress = orderAdress;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public String getOrderName() {
		return orderName;
	}
	
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	
	public String getOrderPrice() {
		return orderPrice;
	}
	
	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}
	
	public String getOrderAdress() {
		return orderAdress;
	}
	
	public void setOrderAdress(String orderAdress) {
		this.orderAdress = orderAdress;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Override
	public String toString() {
		return "OrderEntity [orderId=" + orderId + ", orderName=" + orderName + ", orderPrice=" + orderPrice
				+ ", orderAdress=" + orderAdress + ", createdDate=" + createdDate + "]";
	}
	
}
