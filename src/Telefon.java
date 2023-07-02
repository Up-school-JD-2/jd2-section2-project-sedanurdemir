
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;



class Telefon implements Serializable{
    private TelefonMarkasi marka;
    private String model;
    private final String seriNumarası;
    private double depolamaAlani;
    private String isletimSistemi;
    private List<Uygulama> uygulamalar;
    private List<Kisi>kisiler;

    public Telefon(TelefonMarkasi marka, String model, int depolamaAlani, String isletimSistemi) {
       this.seriNumarası=UUID.randomUUID().toString();
    	this.marka = marka;
        this.model = model;
        
        this.depolamaAlani = depolamaAlani;
        this.isletimSistemi = isletimSistemi;
        this.uygulamalar=new ArrayList<>();
        this.kisiler=new ArrayList<>();
    }

    public TelefonMarkasi getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public String getSeriNumarasi() {
        return seriNumarası;
    }

    public double getDepolamaAlani() {
        return depolamaAlani;
    }

    public String getIsletimSistemi() {
        return isletimSistemi;
    }
    
    

    public List<Uygulama> getUygulamalar() {
		return uygulamalar;
	}

	public void setUygulamalar(List<Uygulama> uygulamalar) {
		this.uygulamalar = uygulamalar;
	}

	public void setMarka(TelefonMarkasi marka) {
		this.marka = marka;
	}

	public void setModel(String model) {
		this.model = model;
	}

	
	public void setDepolamaAlani(double depolamaAlani) {
		this.depolamaAlani = depolamaAlani;
	}

	public void setIsletimSistemi(String isletimSistemi) {
		this.isletimSistemi = isletimSistemi;
	}
	
	

	public List<Kisi> getKisiler() {
		return kisiler;
	}

	public void setKisiler(List<Kisi> kisiler) {
		this.kisiler = kisiler;
	}

	@Override
	public String toString() {
		return "Telefon [marka=" + marka + ", model=" + model + ", seriNumarasi=" + seriNumarası + ", depolamaAlani="
				+ depolamaAlani + ", isletimSistemi=" + isletimSistemi + "]";
	}

	public void telefonBilgileriniGoster() {
        System.out.println("Marka: " + marka);
        System.out.println("Model: " + model);
        System.out.println("Seri Numarası: " + seriNumarası);
        System.out.println("Depolama Alanı: " + depolamaAlani + " GB");
        System.out.println("İşletim Sistemi: " + isletimSistemi);
    }
	
	
	
//	public void uygulamaEkle(Uygulama uygulama) {
//        uygulamalar.add(uygulama);
//    }
	public void uygulamaEkleEnum(UygulamaEnum uygulama) {
		Uygulama yeniUygulama=new Uygulama(uygulama.getAd(),uygulama.getSurum(),uygulama.getBoyut());
        uygulamalar.add(yeniUygulama);
    }
	
    public void uygulamaSil(Uygulama uygulama) {
        uygulamalar.remove(uygulama);
    }
    
    public void kisiEkle(Kisi kisi) {
        kisiler.add(kisi);
       
    }
}