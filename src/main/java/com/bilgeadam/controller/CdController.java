package com.bilgeadam.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.CdEntity;
import com.bilgeadam.utils.IDatabaseCrud;

public class CdController implements IDatabaseCrud<CdEntity>, Serializable {
	private static final long serialVersionUID = 350741109377406971L;
	private static final Logger logger = LogManager.getLogger(CdController.class);
	
	public static void main(String[] args) {
		logger.trace("trace logger durumu");
		logger.debug("debug logger durumu");
		logger.info("info logger durumu");
		logger.warn("warn logger durumu");
		logger.error("error logger durumu");
		logger.fatal("fatal logger durumu");
	}
	
	@Override
	public void create(CdEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("ekleme tamamdır" + CdController.class);
		} catch (Exception e) {
			logger.error("ekleme anında hata meydana geldi !!!!! " + CdController.class);
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(CdEntity entity) {
		try {
			CdEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				logger.info("Silme Başarılı " + CdEntity.class);
			}
		} catch (Exception e) {
			logger.error("silme anında hata meydana geldi !!!!! " + CdController.class);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update(CdEntity entity) {
		try {
			CdEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				findEntity.setName(entity.getName());
				findEntity.setPrice(entity.getPrice());
				findEntity.setDiscount(entity.getDiscount());
				findEntity.setSinger(entity.getSinger());
				findEntity.setGenre(entity.getGenre());
				
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				logger.info("Güncelleme Başarılı " + CdEntity.class);
			}
		} catch (Exception e) {
			logger.error("güncelleme anında hata meydana geldi !!!!! " + CdController.class);
			e.printStackTrace();
		}
	}
	
	// listelemek
	@Override
	public ArrayList<CdEntity> list() {
		Session session = databaseConnectionHibernate();
		
		// unutma: buradaki sorgulama entity sorgulaması yani java classına göre
		String hql = "select str from CdEntity as str where str.id>=:key";
		TypedQuery<CdEntity> typedQuery = session.createQuery(hql, CdEntity.class);
		int id = 1;
		typedQuery.setParameter("key", id);
		ArrayList<CdEntity> arrayList = (ArrayList<CdEntity>) typedQuery.getResultList();
		logger.info("listelendi " + CdEntity.class);
		return arrayList;
	}
	
	// find
	@Override
	public CdEntity find(int id) {
		Session session = databaseConnectionHibernate();
		CdEntity cdEntity;
		try {
			cdEntity = session.find(CdEntity.class, id);
			
			if (cdEntity != null) {
				System.out.println("bulundu... " + cdEntity);
				return cdEntity;
			} else {
				System.out.println("Aradığınız kriterde sonuçlar bulunamadı ...");
				return null;
			}
		} catch (Exception e) {
			logger.error("find anında hata meydana geldi !!!!! " + CdController.class);
			e.printStackTrace();
		}
		return null;
	}
	
}
