package proje01_yesilmarket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class YesilMarket {

	public static List<String> urunler = new ArrayList<>();// global'dir tum class icinde gecerlidir
	public static List<Double> fiyatlar = new ArrayList<>();
	
	public static List<String> sepetUrunler = new ArrayList<>();
	public static List<Double> sepetKg = new ArrayList<>();
	public static List<Double> sepetFiyatlar = new ArrayList<>();
	

	public static void main(String[] args) {
		/*
		 * Yeşil Market alış-veriş programı.
		 * 
		 * 1. Adım: Ürünler ve fiyatları içeren listeleri oluşturunuz. No Ürün Fiyat
		 * ==== ======= ========= 00 Domates 2.10 TL 01 Patates 3.20 TL 02 Biber 1.50 TL
		 * 03 Soğan 2.30 TL 04 Havuç 3.10 TL 05 Elma 1.20 TL 06 Muz 1.90 TL 07 Çilek
		 * 6.10 TL 08 Kavun 4.30 TL 09 Üzüm 2.70 TL 10 Limon 0.50 TL
		 * 
		 * 2. Adım: Kullanıcının ürün nosuna göre listeden ürün seçmesini isteyiniz.
		 * 3.Adım: Kaç kg satın almak istediğini sorunuz.
		 * 4. Adım: Alınacak bu ürünü sepete ekleyiniz ve Sepeti yazdırınız.
		 * 5. Başka bir ürün alıp almak istemediğini sorunuz.
		 * 6. Eğer devam etmek istiyorsa yeniden ürün seçme kısmına yönlendiriniz.
		 * 7. Eğer bitirmek istiyorsa ödeme kısmına geçiniz ve ödem sonrasında programı bitirinzi.
		 * 
		 */
		
		Scanner scan=new Scanner(System.in);
		urunler.addAll(Arrays.asList("Domates", "Patates", "Biber", "Sogan", "Havuc", "Elma", 
				                     "Muz","Cilek", "Kavun","Uzum", "Limon"));
		
		fiyatlar.addAll(Arrays.asList(2.10,3.20,1.50,2.30,3.10,1.20,1.90,6.10,4.30,2.70,0.50));
		String devam;
		double toplamOdeme=0.0;
		do{
		urunListele();
		System.out.print("Urununuzu numaraya gore seciniz:");
		int urunNo=scan.nextInt();
		System.out.print("Agirlik giriniz:");
		double kg=scan.nextDouble();
		
		sepeteEkle(urunNo,kg);
		toplamOdeme=Math.floor(sepeteYazdir());//floor asagi yuvarladi round yukari yuvarladi
		System.out.println("Alisverise devam etmek ister misiniz?");
		devam=scan.next();
		}while(devam.equalsIgnoreCase("e"));
		odeme(toplamOdeme);
		
	}

	public static void urunListele() {
		System.out.println("No\tUrunler \tFiyatlar" );
		System.out.println("===\t======= \t========");
		
		for(int i=0; i<urunler.size(); i++) {
			System.out.println(i+ "\t" +urunler.get(i) +"\t \t" + fiyatlar.get(i));
			
			}
		}
	
	 public static void sepeteEkle(int urunNo, double kg) {
		 
		 sepetUrunler.add(urunler.get(urunNo));
		 sepetKg.add(kg);
		 sepetFiyatlar.add(fiyatlar.get(urunNo)*kg);
			
		}
	 public static double sepeteYazdir() {
		 
		 double fiyatToplami=0.0;
		 double kgToplami=0.0;
		 System.out.println("urun adi\tKG\tFiyati");
		 System.out.println("=================================");
		 for(int i=0;i<sepetUrunler.size();i++) {
		   System.out.println(sepetUrunler.get(i)+"\t\t"+sepetKg.get(i)+"\t"+sepetFiyatlar.get(i));
		   fiyatToplami+=sepetFiyatlar.get(i);
		   kgToplami+=sepetKg.get(i);
			 
		 }
		 System.out.println("=================================");
		 System.out.println("TOPLAM:\t\t"+ kgToplami+"\t"+fiyatToplami);
		 
		 return fiyatToplami;
	 }
	   public static void odeme(double toplamOdeme) {
		  Scanner scan=new Scanner(System.in);
		  System.out.println("********************************"); 
		  System.out.println("***********ODEME****************");
		  System.out.println("ODENECEK TOPLAM FIYAT:"+toplamOdeme);
		  double nakit=0.0;
		   do {
			 System.out.print("Lutfen Nakit Giriniz:");
			 nakit+=scan.nextDouble();
			 if(nakit<toplamOdeme) {
				 System.out.println("Girilen rakam yetersiz.");
				 System.out.println((toplamOdeme-nakit) +"TL daha yatirmaniz gerekmektedir");
		     }
			 }while (nakit<toplamOdeme);
		     double paraUstu=nakit-toplamOdeme;
		     if(paraUstu>0) {
		    	 System.out.println("PARA USTU:"+paraUstu);
		     }
		      System.out.println("BIZI TERCIH ETTIGINIZ ICIN TESEKKUR EDERIZ.");
		      System.out.println("YINE BEKLERIZ...");
	   }
}
