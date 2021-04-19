package proje02_kutuphane;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Kitapci {

	public static int kitapNo=1000;
	
	public static void main(String[] args) {
		/*KÜTÜPHANE PROGRAMI 

		Müşterileriler kütüphaneleri için bir kitap yönetim sistemi tasarlamanızı istiyorlar. 

		1.Bu programda kitaplar, Kitap Adı, Yazar Adı, Yayın Yılı ve Fiyat gibi bilgiler içerebilmelidir.

		2. Program, kitaplara 1001’den başlayarak sıralı ve otomatik numara vermelidir. 

		3. Kullanıcı sisteme Kitap eklemeyebimeli, silebilmeli,  arama ve tüm kitapları listeleme gibi  işlemleri yapabilmelidir.  

		4. Programın başlangıcında Kullanıcıya aşağıdaki gibi bir menü sunulmalıdır ve Kullanıcı programı bitirene kadar işlemlere devam edebilmelidir. 
					
		========= KİTAP PROGRAMI =============
			1: Kitap ekle 
			2: Numara ile kitap sil
			3. Numara ile kitap ara
			4: Tüm kitapları listele
			5: Bitir 
	*/

		List<Kitap> kitapListe=new ArrayList<>();
		topluKitapEkle(kitapListe);
		menu(kitapListe);
		

	}

	 private static void topluKitapEkle(List<Kitap> liste) {
		Kitap kitap1=new Kitap(++kitapNo,"Ali can evde","Ali han",2001,11);
		Kitap kitap2=new Kitap(++kitapNo,"Ali can yolda","Ali han",2005,10);
		Kitap kitap3=new Kitap(++kitapNo,"Yalnizlik","Veli kul",2005,21);
		Kitap kitap4=new Kitap(++kitapNo,"Sen","Ayse unal",2005,30);
		
		liste.add(kitap1);
		liste.add(kitap2);
		liste.add(kitap3);
		liste.add(kitap4);
		}
	 
	 private static void menu(List<Kitap> liste) {
		 Scanner scan=new Scanner(System.in);
		 System.out.println("==========KITAP PROGRAMI=============");
		 System.out.println("1:Kitap Ekle"+"\n 2:Numara ile kitap sil"+"\n 3:Tum kitaplari listele"+
		                    "\n 4:Bitir \n");
		 System.out.println("Lutfen tercihinizi giriniz");
		 int tercih=scan.nextInt();
		 
		 switch(tercih) {
		 case 1:
			 kitapEkle(liste);
			 break;
		 case 2:
			 noIleKitapSil(liste);
		 case 3:
			 tumKitaplariListele(liste);
		 case 4:
			 bitir();
			 break;
	     default:
	    	 System.out.println("Yanlis giris yaptiniz lutfen tekrar deneyin");
				 
		 }
		 scan.close();
			}
	 
	 private static void kitapEkle(List<Kitap> liste) {
		 Scanner scan=new Scanner(System.in);
		 System.out.println("Kitap adi giriniz:");
		 String kitapAdi=scan.nextLine();
		 System.out.println("Yazar adi giriniz:");
		 String yazarAdi=scan.nextLine();
		 System.out.println("Kitap yayin yili giriniz:");
		 int yayinYili=scan.nextInt();
		 System.out.println("Kitap fiyatini giriniz:");
		 double fiyat=scan.nextDouble();
		 
		 Kitap kitap=new Kitap(++kitapNo,kitapAdi,yazarAdi,yayinYili,fiyat);
		 liste.add(kitap);
		 System.out.println(kitap.toString()+" eklendi");
		 menu(liste);
		 scan.close();
		 }
	 
	 private static void tumKitaplariListele(List<Kitap> liste) {
		 for(Kitap each:liste) {
			 System.out.println(each.toString());
		 }
		 menu(liste);
	 }
	 
	 private static void noIleKitapSil(List<Kitap> liste) {
		 Scanner scan=new Scanner(System.in);
		 System.out.println("Silmek istediginiz kitabin numarasini giriniz");
		 int kitapNo=scan.nextInt();
		 
		 for(Kitap each:liste) {
			 if(each.getNo()==kitapNo) {
				 System.out.println(each.toString()+" silindi.");
				 liste.remove(each);
				 menu(liste);
			 }
		 }
		 System.out.println(kitapNo+"numarali kitap bulunamadi.");
		 menu(liste);
		 scan.close();
		 
	 }
	 private static void bitir() {
		 System.out.println("Programi kullandiginiz icin tesekkurler");
	 }

}
