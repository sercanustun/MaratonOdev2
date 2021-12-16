package com.bilgeadam.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.Albums;
import com.bilgeadam.utils.IDatabaseCrud;

public class AlbumController implements IDatabaseCrud<Albums>, Serializable {
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
	public void create(Albums entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("ekleme tamamdır" + AlbumController.class);
		} catch (Exception e) {
			logger.error("ekleme anında hata meydana geldi !!!!! " + AlbumController.class);
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(Albums entity) {
		try {
			Albums findEntity = find(entity.getId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				logger.info("Silme Başarılı " + Albums.class);
			}
		} catch (Exception e) {
			logger.error("silme anında hata meydana geldi !!!!! " + AlbumController.class);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update(Albums entity) {
		try {
			Albums findEntity = find(entity.getId());
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
				logger.info("Güncelleme Başarılı " + Albums.class);
			}
		} catch (Exception e) {
			logger.error("güncelleme anında hata meydana geldi !!!!! " + AlbumController.class);
			e.printStackTrace();
		}
	}
	
	// listelemek
	@Override
	public ArrayList<Albums> list() {
		Session session = databaseConnectionHibernate();
		
		// unutma: buradaki sorgulama entity sorgulaması yani java classına göre
		String hql = "select str from Albums as str where str.id>=:key";
		TypedQuery<Albums> typedQuery = session.createQuery(hql, Albums.class);
		int id = 1;
		typedQuery.setParameter("key", id);
		ArrayList<Albums> arrayList = (ArrayList<Albums>) typedQuery.getResultList();
		logger.info("listelendi " + Albums.class);
		return arrayList;
	}
	
	// Son Eklenenleri Listelemek
	@Override
	public ArrayList<Albums> listLast() {
		Session session = databaseConnectionHibernate();
		
		// unutma: buradaki sorgulama entity sorgulaması yani java classına göre
		String hql = "select str from Albums as str where str.id>=:key ORDER BY created_date desc";
		TypedQuery<Albums> typedQuery = session.createQuery(hql, Albums.class);
		int id = 1;
		typedQuery.setParameter("key", id);
		typedQuery.setMaxResults(10);
		ArrayList<Albums> arrayList = (ArrayList<Albums>) typedQuery.getResultList();
		logger.info("listelendi " + Albums.class);
		return arrayList;
	}
	
	// İndirimdekileri Listelemek
	@Override
	public ArrayList<Albums> listDiscount() {
		Session session = databaseConnectionHibernate();
		
		// unutma: buradaki sorgulama entity sorgulaması yani java classına göre
		String hql = "select str from Albums as str where str.id>=:key ORDER BY discount desc";
		TypedQuery<Albums> typedQuery = session.createQuery(hql, Albums.class);
		int id = 1;
		typedQuery.setParameter("key", id);
		typedQuery.setMaxResults(15);
		ArrayList<Albums> arrayList = (ArrayList<Albums>) typedQuery.getResultList();
		logger.info("listelendi " + Albums.class);
		return arrayList;
	}
	
	// Sanatçıya göre Listelemek
	@Override
	public ArrayList<Albums> listSinger() {
		Scanner sc = new Scanner(System.in);
		String singer = sc.next();
		Session session = databaseConnectionHibernate();
		String hql = "select stu from Albums as stu where stu.singer like singer>=:key";
		TypedQuery<Albums> typedQuery = session.createQuery(hql, Albums.class);
		typedQuery.setParameter("key", singer);
		ArrayList<Albums> arrayList = (ArrayList<Albums>) typedQuery.getResultList();
		logger.info("listelendi " + Albums.class);
		return arrayList;
	}
	
	// find
	@Override
	public Albums find(int id) {
		Session session = databaseConnectionHibernate();
		Albums albums;
		try {
			albums = session.find(Albums.class, id);
			
			if (albums != null) {
				System.out.println("bulundu... " + albums);
				return albums;
			} else {
				System.out.println("Aradığınız kriterde sonuçlar bulunamadı ...");
				return null;
			}
		} catch (Exception e) {
			logger.error("find anında hata meydana geldi !!!!! " + AlbumController.class);
			e.printStackTrace();
		}
		return null;
	}
	
}
