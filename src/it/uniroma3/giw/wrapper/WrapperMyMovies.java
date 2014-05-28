package it.uniroma3.giw.wrapper;

import java.util.List;

import it.uniroma3.giw.DocumentIO;

import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class WrapperMyMovies extends Wrapper {

	public WrapperMyMovies() {
		super();
		DocumentIO dio = new DocumentIO();
		this.CVSPath = dio.getCsvpath();

		this.header = "id,titolo,video,rating".split(",");

		this.csvName = "movie";
	}

	@Override
	public String[] getRowCSV(HtmlPage page) {
		String title = page.getTitleText();
		
		String video = null;
		List<HtmlElement> anchorsBgcover = page.getHtmlElementById("bgcover").getHtmlElementsByTagName("a");

		if(!anchorsBgcover.isEmpty()) {
			 video = anchorsBgcover.get(0).getAttribute("href");
		}
		
		String rating = null;
		List<HtmlElement> spansBgcover = page.getHtmlElementById("bgcover").getHtmlElementsByTagName("span");
		if(!spansBgcover.isEmpty()) {
			rating = spansBgcover.get(0).asText();
			if(rating.equals("MYMO NET RO?")){
				rating = null;
			}
		}

		String[] idArray = page.getUrl().toString().split("/");
		String id = idArray[idArray.length-1]; 

		
		String[] elementRow = {id,title,video,rating};

		System.out.println(title);

		return elementRow;
	}

}
