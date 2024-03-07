package biblioteka;

import java.util.LinkedList;

import javax.management.RuntimeErrorException;

import biblioteka.interfejs.BibliotekaInterface;

public class Biblioteka implements BibliotekaInterface {

	private LinkedList<Knjiga> knjige = new LinkedList<Knjiga>();
	@Override
	public void dodajKnjigu(Knjiga k) {
		if(k == null)
			throw new NullPointerException("Knjiga ne sme biti null");
		if(knjige.contains(k))
			throw new RuntimeException("Knjiga vec postoji");
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
		if(autor == null && isbn == null && naslov == null && izdavac == null)
			return knjige;
		LinkedList<Knjiga> rezultat = new LinkedList<Knjiga>();
		for(Knjiga knjiga : knjige) {
			if(knjiga.getNaslov().toLowerCase().contains(naslov.toLowerCase()))
				rezultat.add(knjiga);
		}
		return rezultat;
	}

}
