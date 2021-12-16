package com.bilgeadam.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.OrderEntity;
import com.bilgeadam.utils.IDatabaseCrud;

public class OrderController implements IDatabaseCrud<OrderEntity>, Serializable {
	
	private static final long serialVersionUID = 350741109377406971L;
	private static final Logger logger = LogManager.getLogger(AlbumController.class);
	
	public static void main(String[] args) {
		logger.trace("trace logger durumu");
		logger.debug("debug logger durumu");
		logger.info("info logger durumu");
		logger.warn("warn logger durumu");
		logger.error("error logger durumu");
		logger.fatal("fatal logger durumu");
	}
	
	@Override
	public void create(OrderEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("ekleme tamamdır" + OrderController.class);
		} catch (Exception e) {
			logger.error("ekleme anında hata meydana geldi !!!!! " + OrderController.class);
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(OrderEntity entity) {
		try {
			OrderEntity findEntity = find(entity.getOrderId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				logger.info("Silme Başarılı " + OrderController.class);
			}
		} catch (Exception e) {
			logger.error("silme anında hata meydana geldi !!!!! " + OrderController.class);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update(OrderEntity entity) {
		try {
			OrderEntity findEntity = find(entity.getOrderId());
			if (findEntity != null) {
				findEntity.setOrderName(entity.getOrderName());
				findEntity.setOrderPrice(entity.getOrderPrice());
				findEntity.setOrderAdress(entity.getOrderAdress());
				
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				logger.info("Güncelleme Başarılı " + OrderEntity.class);
			}
		} catch (Exception e) {
			logger.error("güncelleme anında hata meydana geldi !!!!! " + OrderController.class);
			e.printStackTrace();
		}
	}
	
	// listelemek
	@Override
	public ArrayList<OrderEntity> list() {
		Session session = databaseConnectionHibernate();
		
		// unutma: buradaki sorgulama entity sorgulaması yani java classına göre
		String hql = "select str from OrderEntity as str where str.id>=:key";
		TypedQuery<OrderEntity> typedQuery = session.createQuery(hql, OrderEntity.class);
		int id = 1;
		typedQuery.setParameter("key", id);
		ArrayList<OrderEntity> arrayList = (ArrayList<OrderEntity>) typedQuery.getResultList();
		logger.info("listelendi " + OrderController.class);
		return arrayList;
	}
	
	// En Çok sipariş edilenleri listelemek
	@Override
	public ArrayList<OrderEntity> listMaxOrder() {
		Session session = databaseConnectionHibernate();
		
		// unutma: buradaki sorgulama entity sorgulaması yani java classına göre
		String hql = "select str from OrderEntity as str group by str.orderName order by count(str.orderName) desc";
		TypedQuery<OrderEntity> typedQuery = session.createQuery(hql, OrderEntity.class);
		int id = 1;
		typedQuery.setParameter("key", id);
		ArrayList<OrderEntity> arrayList = (ArrayList<OrderEntity>) typedQuery.getResultList();
		logger.info("listelendi " + OrderController.class);
		return arrayList;
	}
	
	// En Çok sipariş edilen sanatçıları listelemek
	@Override
	public ArrayList<OrderEntity> listPopularSingers() {
		Session session = databaseConnectionHibernate();
		
		// unutma: buradaki sorgulama entity sorgulaması yani java classına göre
		String hql = "select order_name,count(order_name) from orders group by order_name order by count(order_name) desc";
		TypedQuery<OrderEntity> typedQuery = session.createQuery(hql, OrderEntity.class);
		int id = 1;
		typedQuery.setParameter("key", id);
		ArrayList<OrderEntity> arrayList = (ArrayList<OrderEntity>) typedQuery.getResultList();
		logger.info("listelendi " + OrderController.class);
		return arrayList;
	}
	
	// find
	@Override
	public OrderEntity find(int id) {
		Session session = databaseConnectionHibernate();
		OrderEntity orderEntity;
		try {
			orderEntity = session.find(OrderEntity.class, id);
			
			if (orderEntity != null) {
				System.out.println("bulundu... " + orderEntity);
				return orderEntity;
			} else {
				System.out.println("Aradığınız kriterde sonuçlar bulunamadı ...");
				return null;
			}
		} catch (Exception e) {
			logger.error("find anında hata meydana geldi !!!!! " + OrderController.class);
			e.printStackTrace();
		}
		return null;
	}
	
}