package com.bilgeadam.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bilgeadam.entity.Albums;
import com.bilgeadam.entity.CdEntity;
import com.bilgeadam.entity.DvdEntity;
import com.bilgeadam.entity.OrderEntity;
import com.bilgeadam.entity.VinylEntity;

public class HibernateUtil {
	// dış dünyada bununla bu classa erişim sağlayabileceğim.
	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
	// hibernate ile bağlantı kuracağım yer
	private static final SessionFactory sessionFactory = sessionFactoryHibernate();
	
	// method
	private static SessionFactory sessionFactoryHibernate() {
		try {
			// instance
			Configuration configuration = new Configuration();
			
			// entity classlarımızı buraya ekleyeceğiz
			configuration.addAnnotatedClass(DvdEntity.class);
			configuration.addAnnotatedClass(CdEntity.class);
			configuration.addAnnotatedClass(VinylEntity.class);
			configuration.addAnnotatedClass(Albums.class);
			configuration.addAnnotatedClass(OrderEntity.class);
			
			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
			return factory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void header(String title) {
		// ===========
		// ** title **
		// ===========
		int len = title.length();
		StringBuilder row = new StringBuilder("");
		
		for (int i = 0; i < (len + 6); i++) {
			row.append("=");
		}
		
		System.err.println("\n\n\t\t" + row);
		System.err.println("\t\t** " + title.toUpperCase() + " **");
		System.err.println("\t\t" + row + "\n");
	}
	
}
