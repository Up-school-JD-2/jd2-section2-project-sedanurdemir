
public class IsletimSistemiBulunamadıException extends Exception {
	
	public IsletimSistemiBulunamadıException(String ısletimSistemi) {
		super("Işletim Sistemi bulunmadı. " + ısletimSistemi);
	}

}
