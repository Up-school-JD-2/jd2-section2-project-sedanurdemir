
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

class DosyaIslemleri {
	public void verileriYedekle(AkıllıTelefonYonetimUygulamasi uygulama, String dosyaAdi) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(dosyaAdi))) {
            outputStream.writeObject(uygulama.getKisiler());
            outputStream.writeObject(uygulama.getTelefonlar());
            outputStream.writeObject(uygulama.getUygulamalar());
            System.out.println("Veriler dosyaya yedeklendi: " + dosyaAdi);
        } catch (IOException e) {
            System.out.println("Veriler yedeklenirken bir hata oluştu: " + e.getMessage());
        }
    }

    public void verileriGeriYukle(AkıllıTelefonYonetimUygulamasi uygulama, String dosyaAdi) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(dosyaAdi))) {
            List<Kisi> kisiler = (List<Kisi>) inputStream.readObject();
            List<Telefon> telefonlar = (List<Telefon>) inputStream.readObject();
            List<Uygulama> uygulamalar = (List<Uygulama>) inputStream.readObject();
            uygulama.setKisiler(kisiler);
            uygulama.setTelefonlar(telefonlar);
            uygulama.setUygulamalar(uygulamalar);
            System.out.println(kisiler);
            System.out.println();
            System.out.println(telefonlar);
            System.out.println("Veriler dosyadan geri yüklendi: " + dosyaAdi);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Veriler geri yüklenirken bir hata oluştu: " + e.getMessage());
        }
    }
}
