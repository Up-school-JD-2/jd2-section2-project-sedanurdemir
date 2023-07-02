
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Iterator;







public class AkıllıTelefonYonetimUygulamasi {
	private List<Telefon> telefonlar;
    private List<Uygulama> uygulamalar;
    private List<Kisi> kisiler;
    private double toplamDepolamaAlanı;

    public  AkıllıTelefonYonetimUygulamasi() {
	
        telefonlar = new ArrayList<>();
        uygulamalar = new ArrayList<>();
        kisiler = new ArrayList<>();
        toplamDepolamaAlanı=0;
    }

    

    public List<Telefon> getTelefonlar() {
		return telefonlar;
	}



	public void setTelefonlar(List<Telefon> telefonlar) {
		this.telefonlar = telefonlar;
	}



	public List<Uygulama> getUygulamalar() {
		return uygulamalar;
	}



	public void setUygulamalar(List<Uygulama> uygulamalar) {
		this.uygulamalar = uygulamalar;
	}



	public List<Kisi> getKisiler() {
		return kisiler;
	}



	public void setKisiler(List<Kisi> kisiler) {
		this.kisiler = kisiler;
	}



	public void telefonEkle(Telefon telefon) {
        telefonlar.add(telefon);
        toplamDepolamaAlanı+=telefon.getDepolamaAlani();
        System.out.println("Telefon eklendi: " + telefon);
    }

//	public void uygulamaEkle(String seriNumarasi, Uygulama uygulama) throws TelefonBulunamadiException {
//	    Telefon hedefTelefon = telefonuBul(seriNumarasi);
//	    if (hedefTelefon != null) {
//	        hedefTelefon.uygulamaEkle(uygulama);
//	        System.out.println("Uygulama eklendi: " + uygulama);
//	        hedefTelefon.setDepolamaAlani(hedefTelefon.getDepolamaAlani()-(uygulama.getBoyut()*0.001));
//	        System.out.println(hedefTelefon.getDepolamaAlani());
//	    } else {
//	        throw new TelefonBulunamadiException("Belirtilen seri numarasına sahip bir telefon bulunamadı.");
//	    }
//	}
//	
	
	
	public void uygulamaEkleEnum(String seriNumarası, UygulamaEnum uygulama) throws TelefonBulunamadiException {
        Telefon hedefTelefon=telefonuBul(seriNumarası);
        if(hedefTelefon !=null) {
        	hedefTelefon.uygulamaEkleEnum(uygulama);
        	System.out.println("Uygulama kütüphanesinden seçilen uygulama telefona eklendi. " +uygulama);
        	hedefTelefon.setDepolamaAlani(hedefTelefon.getDepolamaAlani()-(uygulama.getBoyut()*0.001));
//	        System.out.println(hedefTelefon.getDepolamaAlani());
        	
        }else {
        	throw new TelefonBulunamadiException("Belitilen seri numaralı telefon bulunamadı.");
        }
}

    public void kisiEkle(String seriNumarası, Kisi kisi) throws GecersizTelefonNumarasıException, TelefonBulunamadiException {
    	Telefon hedefTelefon=telefonuBul(seriNumarası);
    	if(hedefTelefon!=null) {
    		 String telefonNumarasi = kisi.getTelefonNumarasi();
    		 String epostaAdresi=kisi.getEposta();

    	        
    	        if (!telefonNumarasi.startsWith("+") || telefonNumarasi.length() != 13) {
    	            throw new IllegalArgumentException("Geçersiz telefon numarası formatı.");
    	        }

    	        if (!epostaAdresi.contains("@")) {
    	            throw new IllegalArgumentException("Geçersiz e-posta adresi formatı.");
    	        }
    	        hedefTelefon.kisiEkle(kisi);
    	        System.out.println("Kişi eklendi: " + kisi);
    	    } else {
    	        throw new GecersizTelefonNumarasıException("Geçersiz telefon numarası");
    	    }
       
    }
    
    public Telefon telefonuBul(String seriNumarasi) throws TelefonBulunamadiException {
        for (Telefon telefon : telefonlar) {
            if (telefon.getSeriNumarasi().equalsIgnoreCase(seriNumarasi)) {
                return telefon;
            }
        }
        throw new TelefonBulunamadiException("Telefon bulunamadı: " + seriNumarasi);
    }


    public void kullaniciGirisiAl() throws TelefonBulunamadiException, GecersizSeriNumarasıException, IsletimSistemiBulunamadıException, GecersizTelefonNumarasıException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
        	System.out.println("-------- AKILLI TELEFON YÖNETİM UYGULAMASI --------");

            System.out.println("\n1. Telefon Ekle");
            System.out.println("2. Uygulama Ekle");
            System.out.println("3. Kişi Ekle");
            System.out.println("4. Verileri Yedekle");
            System.out.println("5. Verileri Geri Yükle");
            System.out.println("6. Telefon Bul");
            System.out.println("7. Kişi sil");
            System.out.println("8. Telefon Sil");
            System.out.println("9. Telefonları listele");
            System.out.println("10. Kişileri Listele");
            System.out.println("11. Uygulama kütüphanesindeki uygulamaları Listele");
            System.out.println("12. Telefonları Markalarına göre filtrele ");
            System.out.println("13. Telefonları Depolama alanına göre filtrele");
            System.out.println("14. Telefonları işletim sistemine göre filtrele ");
            System.out.println("15. Seçilen telefonun depolama alanını görüntüle");
            System.out.println("16. Seçilen telefondaki uygulamaların kapladığı toplam alanı görüntüle ");
            System.out.println("17. Telefondaki uygulamayı güncelle ");
            System.out.println("18. Telefondaki uygulamaları listele");
            System.out.println("0. Çıkış");

            System.out.print("\nSeçiminizi yapın: ");
            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    scanner.nextLine(); 
                    try {
                        System.out.print("Telefon markası: ");
                        String markaStr = scanner.nextLine();
                        TelefonMarkasi marka = TelefonMarkasi.valueOf(markaStr.toUpperCase());

                        System.out.print("Telefon modeli: ");
                        String model = scanner.nextLine();

//                        System.out.print("Seri numarası: ");
//                        String seriNumarasi = scanner.nextLine();
//                        
//                        if (seriNumarasi.length()!=9 || !seriNumarasi.matches("[0-9]+")) {
//                        	throw new GecersizSeriNumarasıException("geçersiz seri numarası");
//                        }
                        System.out.print("Depolama alanı (GB): ");
                        int depolamaAlani = scanner.nextInt();
//                        scanner.nextLine();

                        if (depolamaAlani <= 8) {
                            throw new IllegalArgumentException("Geçersiz giriş! Depolama alanı pozitif bir tamsayı olmalıdır.");
                        }

                        System.out.print("İşletim sistemi: ");
                        String isletimSistemi = scanner.nextLine();

                        Telefon telefon = new Telefon(marka, model, depolamaAlani, isletimSistemi);
                        telefonEkle(telefon);
                    } catch (InputMismatchException e) {
                        System.out.println("Hatalı giriş! Depolama alanı için geçerli bir tamsayı girilmelidir.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                	scanner.nextLine();
                	
                	System.out.println("Hangi seri numaralı telefona uygulama eklemek istersiniz? ");
                	String seriNoString=scanner.nextLine();
                	System.out.println("Hangi Uygulamayı eklemek istersiniz: ");
                	String eklenmekIstenenUygulamaStr=scanner.nextLine();
                	UygulamaEnum eklenmekIstenenUygulamaEnum = UygulamaEnum.valueOf(eklenmekIstenenUygulamaStr.toUpperCase());
                	uygulamaEkleEnum(seriNoString, eklenmekIstenenUygulamaEnum);
                	break;
                	
                case 3:
                    scanner.nextLine(); 
                    
                    try {
                    System.out.println("Hangi seri numaralı telefona kişi eklemek istersiniz? ");
                	String telSeriNo=scanner.nextLine();
                    System.out.print("Kişi adı: ");
                    String adi = scanner.nextLine();
                    System.out.print("Soyadı: ");
                    String soyadi = scanner.nextLine();
                    System.out.print("Telefon numarası: ");
                    String telefonNumarasi = scanner.nextLine();
                    
                    
                    System.out.print("E-posta adresi: ");
                    String epostaAdresi = scanner.nextLine();

                    Kisi kisi = new Kisi(adi, soyadi, telefonNumarasi, epostaAdresi);
                    kisiEkle(telSeriNo,kisi);
                    } catch (IllegalArgumentException e) {
						System.out.println(e.getMessage());
					}
                 
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.print("Yedek dosya adı: ");
                    String yedekDosyaAdi = scanner.nextLine();
                    DosyaIslemleri dosyaIslemleri = new DosyaIslemleri();
                    dosyaIslemleri.verileriYedekle(this, yedekDosyaAdi);
                    break;
                case 5:
                    scanner.nextLine(); 
                    System.out.print("Geri yükleme dosya adı: ");
                    String geriYuklemeDosyaAdi = scanner.nextLine();
                    DosyaIslemleri dosyaIslemleri1 = new DosyaIslemleri();
                    dosyaIslemleri1.verileriGeriYukle(this, geriYuklemeDosyaAdi);
                    break;
                case 6: 
                	scanner.nextLine(); 
                    System.out.print("Seri numarasını girin: ");
                    String seriNumarasi2= scanner.nextLine();
                    try {
                        Telefon bulunanTelefon = telefonuBul(seriNumarasi2);
                        System.out.println("Bulunan Telefon: " + bulunanTelefon);
                    } catch (TelefonBulunamadiException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                	scanner.nextLine();
                	System.out.print("Silinecek kişinin telefon numarasını  girin: ");
                    String silinecekKisininTelNo = scanner.nextLine();
                    try {
                        kisiSil(silinecekKisininTelNo);
                    } catch (KisiBulunamadiException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                	scanner.nextLine();
                	System.out.print("Silinecek telefonun seri numarasını girin: ");
                    String silinecekSeriNumarasi = scanner.nextLine();
                    try {
                        telefonSil(silinecekSeriNumarasi);
                    } catch (TelefonBulunamadiException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                	scanner.nextLine();
                	telefonlariListele();
                	break;
                case 10:
                	scanner.nextLine();
                	System.out.println("Hangi telefondaki uygulamaları listelemek istiyorsunuz? O telefonun seri numarasını giriniz:  ");
                	String seriNumarası111=scanner.nextLine();
                	try {
                	kisileriListele(seriNumarası111);
                	}catch (TelefonBulunamadiException e) {
						System.out.println(e.getMessage());
					}
                	break;
                case 11:
                	scanner.nextLine();
                	butunUygulamalariListele();
                	break;
                case 12:
                	scanner.nextLine();
                	System.out.println("Hangi markanın telefonlarını görmek istiyorsunuz: ");
                	String filtrelenmekIstenenMarkaStr=scanner.nextLine();
                	try {
                	TelefonMarkasi filtrelenmekIstenenMarka = TelefonMarkasi.valueOf(filtrelenmekIstenenMarkaStr.toUpperCase());
                	
                	telefonlariFiltreleMarkayaGore( filtrelenmekIstenenMarka).forEach(System.out::println);
                	}catch (IllegalArgumentException e) {
						System.out.println("Geçersiz marka: " + filtrelenmekIstenenMarkaStr);
					}
                	
                	break;
                case 13:
                	scanner.nextLine();
                	int filtrelenmekIstenenDepolamaAlani = 0;
                	boolean validInput = false;

                	while (!validInput) {
                	    try {
                	        System.out.println("Minimum depolama alanını giriniz: ");
                	        filtrelenmekIstenenDepolamaAlani = scanner.nextInt();
                	        validInput = true;
                	    } catch (InputMismatchException e) {
                	        System.out.println("Geçerli bir tamsayı girişi yapın.");
                	        scanner.nextLine(); 
                	    }
                	}

                	List<Telefon> filtrelenmisTelefonlar = telefonlariFiltreleDepolamaAlaniBuyukOlanlar(filtrelenmekIstenenDepolamaAlani);
                	filtrelenmisTelefonlar.forEach(System.out::println);
                	
                	break;
                case 14:
                	scanner.nextLine();
                	
                	System.out.println("Hangi işletim sistemini filtrelemek istiyorsunuz? ");
                	String filtrelenmekIstenenIsletimSistemi = scanner.nextLine();

                	boolean isletimSistemiBulundu = false;

                	try {
                	    List<Telefon> filtrelenmisTelefonlar1 = telefonlariFiltreleIsletimSistemineGore(filtrelenmekIstenenIsletimSistemi);
                	    filtrelenmisTelefonlar1.forEach(System.out::println);
                	    isletimSistemiBulundu = true;
                	} catch (IsletimSistemiBulunamadıException e) {
                	    System.out.println(e.getMessage());
                	    continue;
                	}

                	if (!isletimSistemiBulundu) {
                	    System.out.println("Geçerli bir işletim sistemi girmediniz. Lütfen tekrar deneyin.");
                	}
                	
                	break;
                case 15:
                	scanner.nextLine();
                	System.out.println("Hangi seri numaralı telefonun depolama alanını görmek istiyorsunuz");
                	String goruntulenmekIstenenTelefon=scanner.nextLine();
                	try {
                	depolamaAlaniniGoruntule(goruntulenmekIstenenTelefon);
                	}catch (TelefonBulunamadiException e) {
						System.out.println(e.getMessage());
						System.out.println();
					}
                	break;
                case 16:
                	scanner.nextLine();
                	System.out.println("Hangi seri numaralı telefondaki uygulamaların toplam boyutunu görmek istiyorsunuz? ");
                	String seriNumarası1=scanner.nextLine();
                	try {
                	uygulamaBoyutunuHesapla(seriNumarası1);
                	}catch (TelefonBulunamadiException e) {
						System.out.println(e.getMessage());
						System.out.println();
					}
                	break;
                case 17:
                	scanner.nextLine();
                	System.out.println("Hangi seri numaralı telefondaki uygulamayı güncellemek istiyorsunuz? ");
                	String seriNumarası11=scanner.nextLine();
                	System.out.println("Hangi uygulamayı güncellemek istiyorsunuz? ");
                	String guncellenecekUygulama=scanner.nextLine();
                	System.out.println("Hangi sürüme güncellenecek? ");
                	String guncellenecekSurum=scanner.nextLine();
                	uygulamaGuncelle(seriNumarası11,guncellenecekUygulama,guncellenecekSurum);
                	break;
                case 18:
                	
                	scanner.nextLine();
                	System.out.println("Hangi telefondaki uygulamaları listelemek istiyorsunuz? O telefonun seri numarasını giriniz:  ");
                	String seriNumarası1111=scanner.nextLine();
                	try {
                	uygulamalariListele(seriNumarası1111);
                	} catch (TelefonBulunamadiException e) {
						System.out.println(e.getMessage());
					}
                	break;
                	
                case 0:
                    System.out.println("Uygulamadan çıkılıyor...");
                    System.exit(0);
                default:
                    System.out.println("Geçersiz bir seçim yaptınız. Tekrar deneyin.");
                    break;
            }
        }
    
    }
    
    public void telefonlariListele() {
        if (telefonlar.isEmpty()) {
            System.out.println("Kayıtlı telefon bulunmamaktadır.");
        } else {
            System.out.println("Telefonlar:");
            for (Telefon telefon : telefonlar) {
                telefon.telefonBilgileriniGoster();
                System.out.println("-----------------------------");
            }
        }
    }
    
    public void butunUygulamalariListele() {
        System.out.println("Uygulamalar:");
        for (UygulamaEnum uygulama : UygulamaEnum.values()) {
            System.out.println("Ad: " + uygulama.getAd());
            System.out.println("Sürüm: " + uygulama.getSurum());
            System.out.println("Boyut: " + uygulama.getBoyut() + " MB");
            System.out.println("-----------------------------");
        }
    }

    public void uygulamalariListele(String seriNumarası) throws TelefonBulunamadiException {
    	
    	Telefon telefon=telefonuBul(seriNumarası);
        if (telefon!=null) {
        	List <Uygulama>uygulamalar=telefon.getUygulamalar();
           if(uygulamalar.isEmpty()) {
        	   System.out.println("Belirtilen telefona ait kayıtlı uygulama bulunmamaktadır.");
           } else {
            System.out.println("Uygulamalar:");
            for (Uygulama uygulama : uygulamalar) {
                uygulama.uygulamaBilgileriniGoster();
                System.out.println("-----------------------------");
            }
        }
        }  else {
        	   throw new TelefonBulunamadiException("Belirtilen seri numarasına sahip telefon bulunamadı. ");
           }
    }
    
    public void kisileriListele(String seriNo) throws TelefonBulunamadiException {
    	Telefon telefon=telefonuBul(seriNo);
        if (telefon!=null) {
        	List <Kisi>kisiler=telefon.getKisiler();
           if(kisiler.isEmpty()) {
        	   System.out.println("Belirtilen telefona ait kayıtlı kişi bulunmamaktadır.");
           } else {
            System.out.println("kişiler:");
            for (Kisi kisi : kisiler) {
               kisi.kisiBilgileriniGoster();
                System.out.println("-----------------------------");
            }
        }
        }  else {
        	   throw new TelefonBulunamadiException("Belirtilen seri numarasına sahip telefon bulunamadı. ");
           }
    }
    
    public List<Telefon> telefonlariFiltreleMarkayaGore(TelefonMarkasi marka) {
        EnumSet<TelefonMarkasi> markalar = EnumSet.allOf(TelefonMarkasi.class);
        if (!markalar.contains(marka)) {
            throw new IllegalArgumentException("Geçersiz marka: " + marka.name());
        }

        return telefonlar.stream()
                .filter(t -> t.getMarka().equals(marka))
                .collect(Collectors.toList());
    }
    public List<Telefon> telefonlariFiltreleDepolamaAlaniBuyukOlanlar(int depolamaAlani) {
    	
    	
        return telefonlar.stream()
                .filter(telefon -> telefon.getDepolamaAlani() >= depolamaAlani)
                .collect(Collectors.toList());
    }

    public List<Telefon> telefonlariFiltreleIsletimSistemineGore(String isletimSistemi) throws IsletimSistemiBulunamadıException {
    	if (isletimSistemi == null) {
            throw new IsletimSistemiBulunamadıException("Geçersiz işletim sistemi girdiniz.");
        }

        List<Telefon> filtrelenmisTelefonlar = telefonlar.stream()
                .filter(telefon -> telefon.getIsletimSistemi().equalsIgnoreCase(isletimSistemi))
                .collect(Collectors.toList());

        if (filtrelenmisTelefonlar.isEmpty()) {
            throw new IsletimSistemiBulunamadıException("Belirtilen işletim sistemine ait telefon bulunamadı.");
        }

        return filtrelenmisTelefonlar;
    }
    
    public List<Telefon> telefonlarıSeriNumarasınaGöreFiltrele(String seriNumarası){
		return telefonlar.stream()
				.filter(telefon-> telefon.getSeriNumarasi() == seriNumarası)
				.collect(Collectors.toList());
    	
		
    }
    
    public void uygulamalariSirala() {
        List<Uygulama> siraliUygulamalar = uygulamalar.stream()
                .sorted(Comparator.comparing(Uygulama::getAd))
                .collect(Collectors.toList());

        for (Uygulama uygulama : siraliUygulamalar) {
            System.out.println(uygulama.getAd());
        }
    }
    
    public void uygulamaGuncelle(String seriNumarası, String uygulamaAdı, String yeniSurum) throws TelefonBulunamadiException {
    	Telefon telefon=telefonuBul(seriNumarası);
    	if(telefon!=null) {
        for (Uygulama uygulama : uygulamalar) {
            if (uygulama.getAd().equalsIgnoreCase(uygulamaAdı)) {
                uygulama.setSurum(yeniSurum);
                System.out.println("Uygulama güncellendi: " + uygulamaAdı);
                return;
            }
        }
    	}
        System.out.println("Uygulama bulunamadı: " + uygulamaAdı);
    }
    
    public void uygulamaBoyutunuHesapla(String seriNumarası) throws TelefonBulunamadiException {
    	
    	Telefon telefon=telefonuBul(seriNumarası);
        if (telefon!=null) {
        	if(!telefon.getUygulamalar().isEmpty()) {
        	int toplamBoyut = telefon.getUygulamalar().stream()
                    .mapToInt(Uygulama::getBoyut)
                    .sum();
        		
            System.out.println("Toplam uygulama boyutu: " + toplamBoyut + " MB");
        	}else {
        	   System.out.println("Belirtilen telefona ait kayıtlı uygulama bulunmamaktadır.");
            
        } } else {
        	   throw new TelefonBulunamadiException("Belirtilen seri numarasına sahip telefon bulunamadı. ");
           }
        }

       
    
    
    public void verileriSifirla() {
        telefonlar.clear();
        uygulamalar.clear();
        kisiler.clear();

        System.out.println("Veriler sıfırlandı.");
    }
    
    public void telefonSil(String seriNumarasi) throws TelefonBulunamadiException {
        Iterator<Telefon> iterator = telefonlar.iterator();
        while (iterator.hasNext()) {
            Telefon telefon = iterator.next();
            if (telefon.getSeriNumarasi().equalsIgnoreCase(seriNumarasi)) {
                iterator.remove();
                System.out.println("Telefon silindi: " + telefon.getMarka() + " " + telefon.getModel());
                return;
            }
        }

        throw new TelefonBulunamadiException("Telefon bulunamadı: " + seriNumarasi);
    }
    


    public void kisiAra(String ad) {
        List<Kisi> bulunanKisiler = kisiler.stream()
                .filter(kisi -> kisi.getAd().equalsIgnoreCase(ad))
                .collect(Collectors.toList());

        if (bulunanKisiler.isEmpty()) {
            System.out.println("Kişi bulunamadı: " + ad);
        } else {
            System.out.println("Bulunan kişiler:");
            for (Kisi kisi : bulunanKisiler) {
                System.out.println(kisi.getAd() + " " + kisi.getSoyad());
            }
        }
    }
    
    public void kisiSil(String telefonNumarasi) throws KisiBulunamadiException {
        Optional<Kisi> kisiOptional = kisiler.stream()
                .filter(kisi -> kisi.getTelefonNumarasi().equals(telefonNumarasi))
                .findFirst();

        if (kisiOptional.isPresent()) {
            Kisi kisi = kisiOptional.get();
            kisiler.remove(kisi);
            System.out.println("Kişi silindi: " + kisi.getAd() + " " + kisi.getSoyad());
        } else {
            throw new KisiBulunamadiException("Girdiğiniz telefon numarasına ait bir kişi bulunamadı. ");
        }
    }
    
    public void depolamaAlaniniGoruntule(String SeriNumarası) throws TelefonBulunamadiException{
    	Optional<Telefon> telefonOptional=telefonlar.stream()
    			.filter(telefon ->telefon.getSeriNumarasi().equals(SeriNumarası))
    			.findFirst();
    	
    	if(telefonOptional.isPresent()) {
    		Telefon filteredtelefon=telefonOptional.get();
    		System.out.println(filteredtelefon.getDepolamaAlani());
    	}else {
    		throw new TelefonBulunamadiException("Girilen seri numaralı telefon bulunamadı.");
    	}
    }
    
}

