
import java.io.Serializable;

public enum UygulamaEnum implements Serializable{
    WHATSAPP("WhatsApp", "2.0", 50),
    INSTAGRAM("Instagram", "3.5", 100),
    SPOTIFY("Spotify", "4.1",150);
   

    private final String ad;
    private final String surum;
    private final int boyut;

    private UygulamaEnum(String ad, String surum, int boyut) {
        this.ad = ad;
        this.surum = surum;
        this.boyut = boyut;
    }

    public String getAd() {
        return ad;
    }

    public String getSurum() {
        return surum;
    }

    public int getBoyut() {
        return boyut;
    }
    
    public void uygulamaBilgileriniGoster() {
        System.out.println("Uygulama Bilgileri:");
        System.out.println("Ad: " + ad);
        System.out.println("Sürüm: " + surum);
        System.out.println("Boyut: " + boyut + " MB");
       
    }
}

