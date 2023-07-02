
public class KisiBulunamadiException extends Exception {
    public KisiBulunamadiException(String telefonNumarasi) {
        super("Kişi bulunamadı: " + telefonNumarasi);
    }
}
