package com.bilgeadam.main;

import java.util.Scanner;

import com.bilgeadam.dto.IAdminDto;

public class Menu implements IAdminDto {
	
	static Scanner sc = new Scanner(System.in);
	
	public static String IsAdmin() {
		System.out.println(
				"Lütfen kullanıcı Adınızı Giriniz Eğer Admin Değilseniz Otomatik Olarak Kullanıcı Paneline Yönlendiriliceksiniz");
		String userId = sc.next();
		System.out.println("Lütfen şifrenizi giriniz");
		String userPassword = sc.next();
		
		if (userId.equals(IAdminDto.adminId) && userPassword.equals(IAdminDto.password)) {
			System.out.println("Admin Paneline Yönlendiriyorsunuz");
			AdminMenu();
			
		} else {
			System.out.println("Admin Değilsiniz Kullanıcı Paneline Yönlendiriliyorsunuz");
			UserMenu();
		}
		
		return null;
		
	}
	
	public static String AdminMenu() {
		
		System.out.println("Lütfen İşlem Seçiniz \n(1)...Yeni albüm ekle" + "\n(2)...Albüm güncelle"
				+ "\n(3)...Albüm sil" + "\n(4)...Güncel siparişleri görüntüle"
				+ "\n(99)...Uygulamadan Çıkış\n_______________________________");
		
		AdminChoice();
		
		return null;
		
	}
	
	public static String UserMenu() {
		
		System.out.println("Lütfen İşlem Seçiniz \n(1)...Son eklenen 10 albümü listele"
				+ "\n(2)...İndirimdeki 15 albümü listele" + "\n(3)...Albümleri seçilen türe göre listele"
				+ "\n(4)...Albümleri seçilen sanatçıya göre listele" + "\n(5)...En çok sipariş edilmiş albümler"
				+ "\n(6)...En popüler sanatçılar" + "\n(99)...Uygulamadan Çıkış\n_______________________________");
		
		UserChoice();
		return null;
		
	}
	
	public static void UserChoice() {
		try {
			
			try (Scanner input = new Scanner(System.in)) {
				while (true) {
					String key = input.next();
					switch (key) {
						
						case "1":
							Query.list10Album();
							
							break;
						case "2":
							Query.listDiscount();
							break;
						case "3":
							Query.listTypes();
							
							break;
						case "4":
							Query.listSinger();
							break;
						case "5":
							Query.listMaxOrder();
							break;
						case "6":
							Query.listPopularSingers();
							break;
						
						case "99":
							System.out.println("Görüşürüz...");
							System.exit(0);
							
							break;
						default:
							System.out.println("Hatalı Giriş Yaptınız...");
							
					}
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void AdminChoice() {
		try {
			
			try (Scanner input = new Scanner(System.in)) {
				while (true) {
					String key = input.next();
					switch (key) {
						
						case "1":
							Query.NewAlbum();
							break;
						case "2":
							Query.UpdateAlbum();
							break;
						case "3":
							Query.DeleteAlbum();
							break;
						case "4":
							Query.ShowOrders();
							break;
						
						case "99":
							System.out.println("Görüşürüz...");
							System.exit(0);
							
							break;
						default:
							System.out.println("Hatalı Giriş Yaptınız...");
							
					}
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		IsAdmin();
	}
	
}
