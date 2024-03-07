package biblioteka;

import java.util.LinkedList;

import biblioteka.interfejs.BibliotekaInterface;

public class Biblioteka implements BibliotekaInterface {

	private LinkedList<Knjiga> knjige = new LinkedList<Knjiga>();
	@Override
	public void dodajKnjigu(Knjiga k) {
		knjige.add(k);
	}

	@Override
	public void obrisiKnjigu(Knjiga k) {
		knjige.remove(k);
	}

	@Override
	public LinkedList<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	@Override
	public LinkedList<Knjiga> pronadjiKnjigu(Autor autor, String isbn, String naslov, String izdavac) {
		LinkedList<Knjiga> rezultat = new LinkedList<Knjiga>();
		for(Knjiga knjiga : knjige) {
			if(knjiga.getNaslov().toLowerCase().contains(naslov.toLowerCase()))
				rezultat.add(knjiga);
		}
		return rezultat;
	}

}
