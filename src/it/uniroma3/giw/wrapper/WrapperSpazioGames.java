package it.uniroma3.giw.wrapper;

import it.uniroma3.giw.DocumentIO;

import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class WrapperSpazioGames extends Wrapper {

	public WrapperSpazioGames() {
		super();
		DocumentIO dio = new DocumentIO();
		this.CVSPath = dio.getCsvpath();

		this.header = "id,titolo,img,positive comments,negative comments".split(",");

		this.csvName = "game";
	}

	@Override
	public String[] getRowCSV(HtmlPage page) {
		String title = page.getTitleText();

		String img = null;
		DomElement idImgCopertina = page.getElementById("imgCopertina");
		if(idImgCopertina != null) {
			img = page.getElementById("imgCopertina").getAttribute("src");
		}
	

		String positive_comments = null;
		String negative_comments = null;
		DomElement idGruppo2 = page.getElementById("gruppo2");
		if(idGruppo2 != null) {
			positive_comments = idGruppo2.getElementsByTagName("td").get(0).asText();
			negative_comments = idGruppo2.getElementsByTagName("td").get(1).asText();
		}

		String[] idArray = page.getUrl().toString().split("/");
		String id = idArray[idArray.length-1]; 


		String[] elementRow = {id,title,img, positive_comments, negative_comments};

		System.out.println(title);

		return elementRow;
	}

}
