package it.uniroma3.giw.wrapper;

import java.util.LinkedList;
import java.util.List;

import it.uniroma3.giw.DocumentIO;

import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class WrapperRepubblica extends Wrapper {


	public WrapperRepubblica() {
		super();

		DocumentIO dio = new DocumentIO();
		this.CVSPath = dio.getCsvpath();

		this.header = "id,titolo,links".split(",");

		this.csvName = "news";
	}

	@Override
	public String[] getRowCSV(HtmlPage page) {

		String title = page.getTitleText();

		String[] idArray = page.getUrl().toString().split("/");

		String id = idArray[idArray.length-1]; 

		HtmlElement elem = page.getFirstByXPath("//div[@class = 'body-text']");

		String lastPosition;

		if(elem == null) {
			lastPosition = null;

		}else {


			List<HtmlElement> list = ((HtmlElement) elem).getHtmlElementsByTagName("dd");

			if(list!= null) {
				List<String> hrefList = new LinkedList<String>();

				for (HtmlElement htmlElement : list) {

					HtmlElement he = htmlElement.getHtmlElementsByTagName("a").get(0);

					if(he != null){

						hrefList.add(he.getAttribute("href").toString());

					}
				}

				lastPosition = hrefList.toString();

			} else 
				lastPosition = null;
		}
		String[] elementRow = {id,title,lastPosition};
		return elementRow;
	}
}
