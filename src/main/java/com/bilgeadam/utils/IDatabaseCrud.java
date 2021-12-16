package com.bilgeadam.utils;

import java.util.ArrayList;

import org.hibernate.Session;

public interface IDatabaseCrud<T> {
	
	public void create(T entity);// ekleme
	
	public void delete(T entity);// silmek
	
	public void update(T entity);// güncelleme
	
	default ArrayList<T> list() {// listeleme
		return null;
	}
	
	default ArrayList<T> listLast() {// son eklenenleri listeleme
		return null;
	}
	
	default ArrayList<T> listDiscount() {// indirimdekileri listeleme
		return null;
	}
	
	default ArrayList<T> listSinger() {// Sanatçıya göre listeleme
		return null;
	}
	
	default ArrayList<T> orderList() {// siparişleri listeleme
		return null;
	}
	
	default ArrayList<T> listMaxOrder() {// en çok orderleri listeleme
		return null;
	}
	
	default ArrayList<T> listPopularSingers() {// en çok sipariş edilen singerleri listeleme
		return null;
	}
	
	default T find(int id) {
		return null;
	}
	
	default T singleResult(int id) {
		return null;
	}
	
	// gövdeli method
	default Session databaseConnectionHibernate() {
		return HibernateUtil.getSessionfactory().openSession();
	}
	
}
