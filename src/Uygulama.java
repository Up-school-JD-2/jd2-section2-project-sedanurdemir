
import java.io.Serializable;

class Uygulama implements Serializable{
    private String ad;
    private String surum;
    private int boyut;
   

    public Uygulama(String ad, String surum, int boyut) {
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

    
	public void setAd(String ad) {
		this.ad = ad;
	}

	public void setSurum(String surum) {
		this.surum = surum;
	}

	public void setBoyut(int boyut) {
		this.boyut = boyut;
	}

	
	
	
    
	@Override
	public String toString() {
		return "Uygulama [ad=" + ad + ", surum=" + surum + ", boyut=" + boyut +  "]";
	}

	public void uygulamaBilgileriniGoster() {
        System.out.println("Uygulama Bilgileri:");
        System.out.println("Ad: " + ad);
        System.out.println("Sürüm: " + surum);
        System.out.println("Boyut: " + boyut + " MB");
       
    }
}
