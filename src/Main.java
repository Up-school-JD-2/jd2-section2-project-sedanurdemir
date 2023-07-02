
import java.util.List;


import java.util.Scanner;


//projeyi yaparken öncelikle telefon markalarını kişi telefon eklerken kendi yazabilecek şekilde düşünmüştüm fakat sonrasında markalar default olarak enum classında tutulsun istedim.
//sonrasında uygulamarı da ilk başta kullanıcılar oluşturabiliyordu fakat sonrasında bunu appstore gibi düşünerek uygulama kütüphanesi enum classı olsun
//ve bundan sonra geliştirilecek veya eklenmek istenen uygulamalar oraya eklensin istedim. Bu yüzden ilk başta normal bir şekilde telefona uygulama eklenebiliyorken
//sonrasınd enum kütüphanesinden seçilen uygulama eklensin diye ikisini ayrı metodlar halinde yazdım fakat ilk yazdığımı ypruma aldım.
//ama sonrasında baktığımda anlamam için yine de dursun istedim. 
//telefonların seri numarasını tanımlarken seri numarası tekrarı olmasın diye rent a car uygulamasında kullandığımız UUID classını kullandım. 
//btün metotlarda telefona özgü olması için öncelikle telefon seri numarası kontrolü yapmakta olup sonrasında o telefona ait özellikleri gösteriyor. 
//kişi eklerken telefon numarasının "+" ile başlaması ve 13 karakter olması lazım aynı şekilde email adresinin de "@" içerip içermediğini kontrol ediyor. 
//

public class Main {
	public static void main(String[] args) throws GecersizSeriNumarasıException, IsletimSistemiBulunamadıException, TelefonBulunamadiException, GecersizTelefonNumarasıException {
		AkıllıTelefonYonetimUygulamasi uygulama = new AkıllıTelefonYonetimUygulamasi();

//        Aşağıdaki telefonları, kişileri ve uygulamaları denemek için yazdım. 
        Telefon telefon1 = new Telefon(TelefonMarkasi.SAMSUNG, "Galaxy S21", 128, "Android");
        Telefon telefon2 = new Telefon(TelefonMarkasi.APPLE, "iPhone 11", 256, "iOS");
        
        uygulama.telefonEkle(telefon1);
        uygulama.telefonEkle(telefon2);

//        Uygulama uygulama1 = new Uygulama("WhatsApp", "2.0", 50);
//        Uygulama uygulama2 = new Uygulama("Instagram", "3.5", 100);

//        uygulama.uygulamaEkle("123456789", uygulama1);
//        uygulama.uygulamaEkle("123456789",uygulama2);

//        Kisi kisi1 = new Kisi("Sedanur", "Demir", "5551234567", "seda@gmail.com");
//        Kisi kisi2 = new Kisi("İdil", "Ertop", "5559876543", "idil@gmail.com");
//
//        uygulama.kisiEkle(kisi1);
//        uygulama.kisiEkle(kisi2);
        
        uygulama.kullaniciGirisiAl();
}	
}
