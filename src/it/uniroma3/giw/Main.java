package it.uniroma3.giw;

public class Main {
	public static void main(String[] args) {
		DocumentIO docio = new DocumentIO();
		
		Wrapper wrapperTuttoMercatoWeb = new WrapperTuttoMercatoWeb();
		wrapperTuttoMercatoWeb.doWrapping(docio.getId2urlSport());
	}

}
