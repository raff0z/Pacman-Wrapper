package it.uniroma3.giw;

import it.uniroma3.giw.wrapper.Wrapper;
import it.uniroma3.giw.wrapper.WrapperMyMovies;
import it.uniroma3.giw.wrapper.WrapperSpazioGames;
import it.uniroma3.giw.wrapper.WrapperTuttoMercatoWeb;

public class Main {
	public static void main(String[] args) {
		DocumentIO docio = new DocumentIO();
		docio.cleanPath();
		
		Wrapper wrapperTuttoMercatoWeb = new WrapperTuttoMercatoWeb();
		wrapperTuttoMercatoWeb.doWrapping(docio.getId2urlSport());
		
		Wrapper wrapperMyMovies = new WrapperMyMovies();
		wrapperMyMovies.doWrapping(docio.getId2urlMovies());
		
		Wrapper wrapperSpazioGames = new WrapperSpazioGames();
		wrapperSpazioGames.doWrapping(docio.getId2urlGames());
	}

}
