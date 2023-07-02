import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Kisi implements Serializable{
    private String ad;
    private String soyad;
    private String telefonNumarasi;
    private String eposta;
    
  

    public Kisi(String ad, String soyad, String telefonNumarasi, String eposta) {
        this.ad = ad;
        this.soyad = soyad;
        this.telefonNumarasi = telefonNumarasi;
        this.eposta = eposta;
        
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public String getTelefonNumarasi() {
        return telefonNumarasi;
    }

    public String getEposta() {
        return eposta;
    }

   
	@Override
	public String toString() {
		return "Kisi [ad=" + ad + ", soyad=" + soyad + ", telefonNumarasi=" + telefonNumarasi + ", eposta=" + eposta
				+ "]";
	}
	
	
	public void kisiBilgileriniGoster() {
        System.out.println("Kişi Bilgileri:");
        System.out.println("Ad: " + ad);
        System.out.println("Soyad: " + soyad);
        System.out.println("Telefon Numarası: " + telefonNumarasi);
        System.out.println("E-posta: " + eposta);
    }
}
