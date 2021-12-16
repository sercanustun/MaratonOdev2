package com.bilgeadam.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.DvdEntity;
import com.bilgeadam.utils.IDatabaseCrud;

public class DvdController implements IDatabaseCrud<DvdEntity>, Serializable {
	private static final long serialVersionUID = 350741109377406971L;
	private static final Logger logger = LogManager.getLogger(DvdController.class);
	
	public static void main(String[] args) {
		logger.trace("trace logger durumu");
		logger.debug("debug logger durumu");
		logger.info("info logger durumu");
		logger.warn("warn logger durumu");
		logger.error("error logger durumu");
		logger.fatal("fatal logger durumu");
	}
	
	@Override
	public void create(DvdEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("ekleme tamamdır" + DvdController.class);
		} catch (Exception e) {
			logger.error("ekleme anında hata meydana geldi !!!!! " + DvdController.class);
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(DvdEntity entity) {
		try {
			DvdEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				logger.info("Silme Başarılı " + DvdEntity.class);
			}
		} catch (Exception e) {
			logger.error("silme anında hata meydana geldi !!!!! " + DvdController.class);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update(DvdEntity entity) {
		try {
			DvdEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				findEntity.setName(entity.getName());
				findEntity.setPrice(entity.getPrice());
				findEntity.setDiscount(entity.getDiscount());
				findEntity.setSinger(entity.getSinger());
				findEntity.setGenre(entity.getGenre());
				findEntity.setImageQuality(entity.getImageQuality());
				
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				logger.info("Güncelleme Başarılı " + DvdEntity.class);
			}
		} catch (Exception e) {
			logger.error("güncelleme anında hata meydana geldi !!!!! " + DvdController.class);
			e.printStackTrace();
		}
	}
	
	// listelemek
	@Override
	public ArrayList<DvdEntity> list() {
		Session session = databaseConnectionHibernate();
		
		// unutma: buradaki sorgulama entity sorgulaması yani java classına göre
		String hql = "select str from DvdEntity as str where str.id>=:key";
		TypedQuery<DvdEntity> typedQuery = session.createQuery(hql, DvdEntity.class);
		int id = 1;
		typedQuery.setParameter("key", id);
		ArrayList<DvdEntity> arrayList = (ArrayList<DvdEntity>) typedQuery.getResultList();
		logger.info("listelendi " + DvdEntity.class);
		return arrayList;
	}
	
	// find
	@Override
	public DvdEntity find(int id) {
		Session session = databaseConnectionHibernate();
		DvdEntity dvdEntity;
		try {
			dvdEntity = session.find(DvdEntity.class, id);
			
			if (dvdEntity != null) {
				System.out.println("bulundu... " + dvdEntity);
				return dvdEntity;
			} else {
				System.out.println("Aradığınız kriterde sonuçlar bulunamadı ...");
				return null;
			}
		} catch (Exception e) {
			logger.error("find anında hata meydana geldi !!!!! " + DvdController.class);
			e.printStackTrace();
		}
		return null;
	}
	
}
