package com.bilgeadam.main;

import java.util.Scanner;

import com.bilgeadam.controller.AlbumController;
import com.bilgeadam.controller.CdController;
import com.bilgeadam.controller.DvdController;
import com.bilgeadam.controller.OrderController;
import com.bilgeadam.controller.VinylController;
import com.bilgeadam.entity.Albums;
import com.bilgeadam.entity.CdEntity;
import com.bilgeadam.entity.DvdEntity;
import com.bilgeadam.entity.OrderEntity;
import com.bilgeadam.entity.VinylEntity;

public class Query {
	
	public static void NewAlbum() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Lütfen eklemek istediğiniz albüm türünü tuşlayınız \n1-)CD \n2-)DVD\n3-)Vinyl");
		
		int select = sc.nextInt();
		
		System.out.println("Lütfen albüm adını giriniz");
		String queryAlbumName = sc.next();
		
		System.out.println("Lütfen albüm fiyatını sonuna TL cinsinden giriniz");
		String queryAlbumPrice = sc.next();
		
		System.out.println("Lütfen albümdeki indirim oranını giriniz indirim yoksa 0");
		String queryAlbumDiscount = sc.next();
		
		System.out.println("Lütfen albümün kime ait olduğunu giriniz");
		String queryAlbumSinger = sc.next();
		
		System.out.println("Lütfen tür giriniz");
		String queryAlbumGenre = sc.next();
		
		System.out.println("Lütfen video kalitesini giriniz CD ve Vinyl için 0 Tuşlayabilirsiniz");
		String queryAlbumImageQuality = sc.next();
		
		System.out.println("Lütfen Diameter Giriniz CD ve DVD için sıfır girebilirsiniz");
		String queryAlbumDiameter = sc.next();
		
		System.out.println("Lütfen devir hızını Giriniz CD ve DVD için sıfır girebilirsiniz");
		String queryAlbumSpeed = sc.next();
		
		switch (select) {
			
			case 1:
				
				CdEntity cdEntity1 = new CdEntity(queryAlbumName, queryAlbumPrice, queryAlbumDiscount, queryAlbumSinger,
						queryAlbumGenre);
				CdController cdController = new CdController();
				cdController.create(cdEntity1);
				
				break;
			case 2:
				
				DvdEntity dvdEntity1 = new DvdEntity(queryAlbumName, queryAlbumPrice, queryAlbumDiscount,
						queryAlbumSinger, queryAlbumGenre, queryAlbumImageQuality);
				DvdController dvdController = new DvdController();
				dvdController.create(dvdEntity1);
				
				break;
			case 3:
				VinylEntity vinylEntity = new VinylEntity(queryAlbumName, queryAlbumPrice, queryAlbumDiscount,
						queryAlbumSinger, queryAlbumGenre, queryAlbumDiameter, queryAlbumSpeed);
				VinylController vinylController = new VinylController();
				vinylController.create(vinylEntity);
				
				break;
			
			default:
				System.out.println("Lütfen geçerli bir işlem giriniz");
				
		}
	}
	
	public static void UpdateAlbum() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Lütfen güncellemek istediğiniz albüm türünü tuşlayınız \n1-)CD \n2-)DVD\n3-)Vinyl");
		int select = sc.nextInt();
		
		System.out.println("Lütfen güncellemek istediğiniz id yi tuşlayınız");
		int id = sc.nextInt();
		
		System.out.println("Lütfen albüm adını giriniz");
		String queryAlbumName = sc.next();
		
		System.out.println("Lütfen albüm fiyatını sonuna TL cinsinden giriniz");
		String queryAlbumPrice = sc.next();
		
		System.out.println("Lütfen albümdeki indirim oranını giriniz indirim yoksa 0");
		String queryAlbumDiscount = sc.next();
		
		System.out.println("Lütfen albümün kime ait olduğunu giriniz");
		String queryAlbumSinger = sc.next();
		
		System.out.println("Lütfen tür giriniz");
		String queryAlbumGenre = sc.next();
		
		System.out.println("Lütfen video kalitesini giriniz CD ve Vinyl için 0 Tuşlayabilirsiniz");
		String queryAlbumImageQuality = sc.next();
		
		System.out.println("Lütfen Diameter Giriniz CD ve DVD için sıfır girebilirsiniz");
		String queryAlbumDiameter = sc.next();
		
		System.out.println("Lütfen devir hızını Giriniz CD ve DVD için sıfır girebilirsiniz");
		String queryAlbumSpeed = sc.next();
		
		switch (select) {
			
			case 1:
				
				CdEntity cdEntity1 = new CdEntity(queryAlbumName, queryAlbumPrice, queryAlbumDiscount, queryAlbumSinger,
						queryAlbumGenre);
				cdEntity1.setId(id);
				CdController cdController = new CdController();
				cdController.update(cdEntity1);
				
				break;
			case 2:
				
				DvdEntity dvdEntity1 = new DvdEntity(queryAlbumName, queryAlbumPrice, queryAlbumDiscount,
						queryAlbumSinger, queryAlbumGenre, queryAlbumImageQuality);
				dvdEntity1.setId(id);
				DvdController dvdController = new DvdController();
				dvdController.update(dvdEntity1);
				
				break;
			case 3:
				VinylEntity vinylEntity1 = new VinylEntity(queryAlbumName, queryAlbumPrice, queryAlbumDiscount,
						queryAlbumSinger, queryAlbumGenre, queryAlbumDiameter, queryAlbumSpeed);
				vinylEntity1.setId(id);
				VinylController vinylController = new VinylController();
				vinylController.update(vinylEntity1);
				
				break;
			
			default:
				System.out.println("Lütfen geçerli bir işlem giriniz");
				
		}
		
	}
	
	public static void DeleteAlbum() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Lütfen silmek istediğiniz albüm türünü tuşlayınız \n1-)CD \n2-)DVD\n3-)Vinyl");
		int select = sc.nextInt();
		System.out.println("Lütfen Silmek İstediğiniz Albümün ID sini giriniz");
		int id = sc.nextInt();
		
		switch (select) {
			
			case 1:
				
				CdEntity cdEntity1 = new CdEntity();
				cdEntity1.setId(id);
				CdController cdController = new CdController();
				cdController.delete(cdEntity1);
				
				break;
			case 2:
				
				DvdEntity dvdEntity1 = new DvdEntity();
				dvdEntity1.setId(id);
				DvdController dvdController = new DvdController();
				dvdController.delete(dvdEntity1);
				
				break;
			case 3:
				VinylEntity vinylEntity1 = new VinylEntity();
				vinylEntity1.setId(id);
				VinylController vinylController = new VinylController();
				vinylController.delete(vinylEntity1);
				
				break;
			
			default:
				System.out.println("Lütfen geçerli bir işlem giriniz");
				
		}
		
	}
	
	public static void ShowOrders() {
		OrderController orderController = new OrderController();
		for (OrderEntity temp : orderController.list()) {
			System.out.println(temp);
		}
		
	}
	
	public static void list10Album() {
		AlbumController albumController = new AlbumController();
		for (Albums temp : albumController.listLast()) {
			System.out.println(temp);
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Lütfen sipariş vermek istediğiniz albümün adını yazınız");
		String name = sc.nextLine();
		System.out.println("Lütfen sipariş vermek istediğiniz albümün fiyatını giriniz");
		String price = sc.nextLine();
		System.out.println("Lütfen göndermemiz için adresinizi veriniz");
		String adress = sc.nextLine();
		
		OrderEntity orderEntity = new OrderEntity(name, price, adress);
		OrderController orderController = new OrderController();
		orderController.create(orderEntity);
		
	}
	
	public static void listDiscount() {
		AlbumController albumController = new AlbumController();
		for (Albums temp : albumController.listDiscount()) {
			System.out.println(temp);
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Lütfen sipariş vermek istediğiniz albümün adını yazınız");
		String name = sc.nextLine();
		System.out.println("Lütfen sipariş vermek istediğiniz albümün fiyatını giriniz");
		String price = sc.nextLine();
		System.out.println("Lütfen göndermemiz için adresinizi veriniz");
		String adress = sc.nextLine();
		
		OrderEntity orderEntity = new OrderEntity(name, price, adress);
		OrderController orderController = new OrderController();
		orderController.create(orderEntity);
		
	}
	
	public static void listTypes() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Lütfen listelemek istediğiniz albüm türünü tuşlayınız \n1-)CD \n2-)DVD\n3-)Vinyl");
		int select = sc.nextInt();
		switch (select) {
			
			case 1:
				
				CdController cdController = new CdController();
				for (CdEntity temp : cdController.list()) {
					System.out.println(temp);
				}
				
				break;
			case 2:
				DvdController dvdController = new DvdController();
				for (DvdEntity temp : dvdController.list()) {
					System.out.println(temp);
				}
				
				break;
			case 3:
				VinylController vinylController = new VinylController();
				for (VinylEntity temp : vinylController.list()) {
					System.out.println(temp);
				}
				
				break;
			
			default:
				System.out.println("Lütfen geçerli bir işlem giriniz");
				
		}
		
		System.out.println("Lütfen sipariş vermek istediğiniz albümün adını yazınız");
		String name = sc.nextLine();
		System.out.println("Lütfen sipariş vermek istediğiniz albümün fiyatını giriniz");
		String price = sc.nextLine();
		System.out.println("Lütfen göndermemiz için adresinizi veriniz");
		String adress = sc.nextLine();
		
		OrderEntity orderEntity = new OrderEntity(name, price, adress);
		OrderController orderController = new OrderController();
		orderController.create(orderEntity);
	}
	
	public static void listSinger() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Lütfen listelemek istediğiniz sanatçının ismini giriniz");
		String singer = sc.next();
		AlbumController albumController = new AlbumController();
		for (Albums temp : albumController.listDiscount()) {
			System.out.println(temp);
		}
		
		System.out.println("Lütfen sipariş vermek istediğiniz albümün adını yazınız");
		String name = sc.nextLine();
		System.out.println("Lütfen sipariş vermek istediğiniz albümün fiyatını giriniz");
		String price = sc.nextLine();
		System.out.println("Lütfen göndermemiz için adresinizi veriniz");
		String adress = sc.nextLine();
		
		OrderEntity orderEntity = new OrderEntity(name, price, adress);
		OrderController orderController = new OrderController();
		orderController.create(orderEntity);
	}
	
	public static void listOrder() {
		OrderController orderController = new OrderController();
		for (OrderEntity temp : orderController.orderList()) {
			System.out.println(temp);
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Lütfen sipariş vermek istediğiniz albümün adını yazınız");
		String name = sc.nextLine();
		System.out.println("Lütfen sipariş vermek istediğiniz albümün fiyatını giriniz");
		String price = sc.nextLine();
		System.out.println("Lütfen göndermemiz için adresinizi veriniz");
		String adress = sc.nextLine();
		
		OrderEntity orderEntity = new OrderEntity(name, price, adress);
		orderController.create(orderEntity);
	}
	
	public static void listMaxOrder() {
		OrderController orderController = new OrderController();
		for (OrderEntity temp : orderController.listMaxOrder()) {
			System.out.println(temp);
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Lütfen sipariş vermek istediğiniz albümün adını yazınız");
		String name = sc.nextLine();
		System.out.println("Lütfen sipariş vermek istediğiniz albümün fiyatını giriniz");
		String price = sc.nextLine();
		System.out.println("Lütfen göndermemiz için adresinizi veriniz");
		String adress = sc.nextLine();
		
		OrderEntity orderEntity = new OrderEntity(name, price, adress);
		orderController.create(orderEntity);
	}
	
	public static void listPopularSingers() {
		OrderController orderController = new OrderController();
		for (OrderEntity temp : orderController.listPopularSingers()) {
			System.out.println(temp);
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Lütfen sipariş vermek istediğiniz albümün adını yazınız");
		String name = sc.nextLine();
		System.out.println("Lütfen sipariş vermek istediğiniz albümün fiyatını giriniz");
		String price = sc.nextLine();
		System.out.println("Lütfen göndermemiz için adresinizi veriniz");
		String adress = sc.nextLine();
		
		OrderEntity orderEntity = new OrderEntity(name, price, adress);
		orderController.create(orderEntity);
	}
}
