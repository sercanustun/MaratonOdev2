package com.bilgeadam.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.VinylEntity;
import com.bilgeadam.utils.IDatabaseCrud;

public class VinylController implements IDatabaseCrud<VinylEntity>, Serializable {
	private static final long serialVersionUID = 350741109377406971L;
	private static final Logger logger = LogManager.getLogger(VinylController.class);
	
	public static void main(String[] args) {
		logger.trace("trace logger durumu");
		logger.debug("debug logger durumu");
		logger.info("info logger durumu");
		logger.warn("warn logger durumu");
		logger.error("error logger durumu");
		logger.fatal("fatal logger durumu");
	}
	
	@Override
	public void create(VinylEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("ekleme tamamdır" + VinylController.class);
		} catch (Exception e) {
			logger.error("ekleme anında hata meydana geldi !!!!! " + VinylController.class);
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(VinylEntity entity) {
		try {
			VinylEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				logger.info("Silme Başarılı " + VinylEntity.class);
			}
		} catch (Exception e) {
			logger.error("silme anında hata meydana geldi !!!!! " + VinylController.class);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update(VinylEntity entity) {
		try {
			VinylEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				findEntity.setName(entity.getName());
				findEntity.setPrice(entity.getPrice());
				findEntity.setDiscount(entity.getDiscount());
				findEntity.setSinger(entity.getSinger());
				findEntity.setGenre(entity.getGenre());
				findEntity.setDiameter(entity.getDiameter());
				findEntity.setSpeed(entity.getSpeed());
				
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				logger.info("Güncelleme Başarılı " + VinylEntity.class);
			}
		} catch (Exception e) {
			logger.error("güncelleme anında hata meydana geldi !!!!! " + VinylController.class);
			e.printStackTrace();
		}
	}
	
	// listelemek
	@Override
	public ArrayList<VinylEntity> list() {
		Session session = databaseConnectionHibernate();
		
		// unutma: buradaki sorgulama entity sorgulaması yani java classına göre
		String hql = "select str from VinylEntity as str where str.id>=:key";
		TypedQuery<VinylEntity> typedQuery = session.createQuery(hql, VinylEntity.class);
		int id = 1;
		typedQuery.setParameter("key", id);
		ArrayList<VinylEntity> arrayList = (ArrayList<VinylEntity>) typedQuery.getResultList();
		logger.info("listelendi " + VinylEntity.class);
		return arrayList;
	}
	
	// find
	@Override
	public VinylEntity find(int id) {
		Session session = databaseConnectionHibernate();
		VinylEntity vinylEntity;
		try {
			vinylEntity = session.find(VinylEntity.class, id);
			
			if (vinylEntity != null) {
				System.out.println("bulundu... " + vinylEntity);
				return vinylEntity;
			} else {
				System.out.println("Aradığınız kriterde sonuçlar bulunamadı ...");
				return null;
			}
		} catch (Exception e) {
			logger.error("find anında hata meydana geldi !!!!! " + VinylController.class);
			e.printStackTrace();
		}
		return null;
	}
	
}
