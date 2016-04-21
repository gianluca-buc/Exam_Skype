package skype;

import java.util.Iterator;

import lista.IndexdLL;
import lista.IndexedList;

public class Skype implements Comparable {
	
	private IndexedList<Pacchetto> comunicazione = new IndexdLL<Pacchetto>();
	
	public Skype() {
		
	}
	
	public void addPacchetto(Pacchetto p) {
		comunicazione.addItem(p, p.identificativo);
	}
	
	public boolean complete() {
		int indiceUltimo = comunicazione.numberItems() - 1;
		
		if (comunicazione.getItem(indiceUltimo).ultimo == false || comunicazione.getItem(0).id() != 0) {
			return false;
		}
		
		int pred = 0;
		Iterator<Pacchetto> it = comunicazione.iterator();
		it.next(); //incremento perchè ho già fatto il controllo sul primo
		while(it.hasNext()) {
			if (it.next().id() != pred + 1) {
				return false;
			}
			pred++;
		}
		
		
		return true;
	}
	
	public String toString() {
		String dati = "";
		
		for ( Pacchetto p : comunicazione) {
			dati = dati + p.dati + " ";
		}
		
		return dati;
	}

	@Override
	public int compareTo(Object o) {
		if (this.complete() == true && ((Skype) o).complete() == true ) {
			if (this.toString().compareTo(((Skype) o).toString()) == 0) {
				return 0;
			} else if (this.toString().compareTo(((Skype) o).toString()) < 0) {
				return - 1;
			} else {
				return 1;
			}
		}
		
		throw new EccezioneConversaziniNonConfrontabili("Le conversazioni non sono comparabili");
	}
}
