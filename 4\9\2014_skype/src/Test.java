import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.SingleSelectionModel;

import skype.Pacchetto;
import skype.Skype;

public class Test {

	public static void main(String[] args) {
		
		//prima comunicazione
		Pacchetto c1p1 = new Pacchetto(0, "Asd", false);
		Pacchetto c1p2 = new Pacchetto(1, "è", false);
		Pacchetto c1p3 = new Pacchetto(2, "un", false);
		Pacchetto c1p4 = new Pacchetto(3, "esame", false);
		Pacchetto c1p5 = new Pacchetto(4, "utile", false);
		Pacchetto c1p6 = new Pacchetto(5, "ed", false);
		Pacchetto c1p7 = new Pacchetto(6, "appassionante", true);
		
		ArrayList<Pacchetto> packC1 = new ArrayList<Pacchetto>();
		packC1.add(c1p1);
		packC1.add(c1p2);
		packC1.add(c1p3);
		packC1.add(c1p4);
		packC1.add(c1p5);
		packC1.add(c1p6);
		packC1.add(c1p7);
		Collections.shuffle(packC1);  ///////////////////////
		System.out.println(packC1.toString());
		
		Skype comunicazione1 = new Skype();
		for (int i = 0; i < packC1.size(); i++) {
			for (Iterator iterator = packC1.iterator(); iterator.hasNext();) {
				Pacchetto pacchetto = (Pacchetto) iterator.next();
				if(pacchetto.id() == i) {
					comunicazione1.addPacchetto(pacchetto);
				}
			}
		}
		
		if(comunicazione1.complete())
			System.out.println("Comunicazione1: " + comunicazione1.toString());
		System.out.println("");
		
		
		//seconda comunicazione
		Pacchetto c2p1 = new Pacchetto(0, "Asd", false);
		Pacchetto c2p2 = new Pacchetto(1, "è", false);
		Pacchetto c2p3 = new Pacchetto(2, "un", false);
		Pacchetto c2p4 = new Pacchetto(3, "esame", false);
		Pacchetto c2p5 = new Pacchetto(4, "utile", false);
		Pacchetto c2p6 = new Pacchetto(5, "ed", false);
		Pacchetto c2p7 = new Pacchetto(6, "appassionante", false);
		Pacchetto c2p8 = new Pacchetto(7, "presente nel", false);
		Pacchetto c2p9 = new Pacchetto(8, "piano di studi", true);
		
		ArrayList<Pacchetto> packC2 = new ArrayList<Pacchetto>();
		packC2.add(c2p1);
		packC2.add(c2p2);
		packC2.add(c2p3);
		packC2.add(c2p4);
		packC2.add(c2p5);
		packC2.add(c2p6);
		packC2.add(c2p7);
		packC2.add(c2p8);
		packC2.add(c2p9);
		Collections.shuffle(packC2);  ///////////////////////
		System.out.println(packC2.toString());
		
		Skype comunicazione2 = new Skype();
		for (int i = 0; i < packC2.size(); i++) {
			for (Iterator iterator = packC2.iterator(); iterator.hasNext();) {
				Pacchetto pacchetto = (Pacchetto) iterator.next();
				if(pacchetto.id() == i) {
					comunicazione2.addPacchetto(pacchetto);
				}
			}
		}
		
		if(comunicazione2.complete())
			System.out.println("Comunicazione2: " + comunicazione2.toString());
		System.out.println("");
		
		System.out.println("Confronto fra Comunicazione1 e Comunicazione2: ");
		if (comunicazione1.compareTo(comunicazione2) == 0) {
			System.out.println("Sono uguali!");
		} else if (comunicazione1.compareTo(comunicazione2) < 0) {
			System.out.println("Il primo è più piccolo");
		} else {
			System.out.println("Il secondo è più piccolo");
		}

	}

}
