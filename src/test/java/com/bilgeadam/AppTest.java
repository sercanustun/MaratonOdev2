package com.bilgeadam;

import com.bilgeadam.controller.AlbumController;
import com.bilgeadam.controller.CdController;
import com.bilgeadam.controller.DvdController;
import com.bilgeadam.controller.OrderController;
import com.bilgeadam.controller.VinylController;
import com.bilgeadam.entity.CdEntity;
import com.bilgeadam.entity.DvdEntity;
import com.bilgeadam.entity.OrderEntity;
import com.bilgeadam.entity.VinylEntity;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	public static void main(String[] args) {
		// JPQL- HQL-SQL
		
		//// Create
		
		DvdEntity dvdEntity1 = new DvdEntity("Dudu", "50TL", "10", "Tarkan", "Pop", "1080P");
		DvdEntity dvdEntity2 = new DvdEntity("Belki Alışman Lazım", "100TL", "25", "Duman", "Rock", "1440P");
		DvdEntity dvdEntity3 = new DvdEntity("Duman1", "25TL", "5", "Duman", "Rock", "720P");
		DvdEntity dvdEntity4 = new DvdEntity("Duman2", "35TL", "3", "Duman", "Rock", "1080P");
		DvdEntity dvdEntity5 = new DvdEntity("Bangır Bangır", "1TL", "0", "Gülşen", "Pop", "480P");
		DvdController dvdController = new DvdController();
		dvdController.create(dvdEntity1);
		dvdController.create(dvdEntity2);
		dvdController.create(dvdEntity3);
		dvdController.create(dvdEntity4);
		dvdController.create(dvdEntity5);
		CdEntity cdEntity1 = new CdEntity("Git", "250TL", "10", "Sezen Aksu", "Pop");
		CdEntity cdEntity2 = new CdEntity("Lover", "50TL", "25", "Taylor Swift", "Pop");
		CdEntity cdEntity3 = new CdEntity("Random Access Memories", "300TL", "5", "Daft Punk", "Pop");
		CdEntity cdEntity4 = new CdEntity("Fine Line", "35TL", "3", "Harry Styles", "Pop");
		CdEntity cdEntity5 = new CdEntity("Bir Pesimistin Gözyaşları", "100TL", "0", "Sagopa Kajmer", "Rap");
		CdController cdController = new CdController();
		cdController.create(cdEntity1);
		cdController.create(cdEntity2);
		cdController.create(cdEntity3);
		cdController.create(cdEntity4);
		cdController.create(cdEntity5);
		VinylEntity vinylEntity1 = new VinylEntity("Dario Moreno'suz 40 Yıl ", "540TL", "10", "Dario Moreno ", "Clasic",
				"25cm", "45 Devir");
		VinylEntity vinylEntity2 = new VinylEntity("Evgeny Grinko", "250TL", "10", "Evgeny Grinko", "Clasic", "35cm",
				"35 Devir");
		VinylEntity vinylEntity3 = new VinylEntity("Back To Black", "300TL", "5", "Amy Winehouse ", "Pop", "25cm",
				"45 Devir");
		VinylEntity vinylEntity4 = new VinylEntity("Unutulmayan Şarkılar", "120TL", "25", "Özdemir Erdoğan ", "Pop",
				"30", "30 Devir");
		VinylEntity vinylEntity5 = new VinylEntity("Live at the Royal Albert Hall", "320TL", "30", "Arctic Monkeys ",
				"Rock", "31cm", "35 Devir");
		VinylController vinylController = new VinylController();
		vinylController.create(vinylEntity1);
		vinylController.create(vinylEntity2);
		vinylController.create(vinylEntity3);
		vinylController.create(vinylEntity4);
		vinylController.create(vinylEntity5);
		
		OrderEntity orderEntity = new OrderEntity("isim", "15533", "Saçma sapan sokak no 33 35");
		OrderController orderController = new OrderController();
		orderController.create(orderEntity);
		
		//// find
		//
		AlbumController albumController = new AlbumController();
		int id = 6;
		albumController.find(id);
		
		// // delete
		// DvdController dvdController = new DvdController();
		// DvdEntity dvdEntity = new DvdEntity();
		// dvdEntity.setId(2);
		// dvdController.delete(dvdEntity);
		
		// // update
		// CdEntity cdEntity = new CdEntity("sdf", "asdasd", null, null, null);
		// cdEntity.setId(6);
		// CdController cdController = new CdController();
		// cdController.update(cdEntity);
		
		//// list
		// AlbumController albumController = new AlbumController();
		// for (Albums temp : albumController.list()) {
		// System.out.println(temp);
		// }
		//
	}
	
}
