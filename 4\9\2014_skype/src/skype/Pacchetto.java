package skype;

public class Pacchetto {
	 Utente mittente;
	 Utente destinatario;
	 int identificativo;
	 String dati;
	 boolean ultimo;
	 
	 public Pacchetto(int identificativo, String dati, boolean ultimo) {
		 this.mittente = new Utente();
		 this.destinatario = new Utente();
		 this.identificativo = identificativo;
		 this.dati = dati;
		 this.ultimo = ultimo;
	 }
	 
	 public int id() {
		return identificativo;
	}
	 
	public String toString() {
		return dati;
		 
	 }
	 
}
