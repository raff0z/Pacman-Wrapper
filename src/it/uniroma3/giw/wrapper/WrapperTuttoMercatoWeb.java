package it.uniroma3.giw.wrapper;

import it.uniroma3.giw.DocumentIO;

import com.gargoylesoftware.htmlunit.html.DomAttr;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class WrapperTuttoMercatoWeb extends Wrapper{

	public WrapperTuttoMercatoWeb(){
		super();
		DocumentIO dio = new DocumentIO();
		this.CVSPath = dio.getCsvpath();

		this.header = "id,titolo,img,link".split(",");
		
		this.csvName = "sport";
	}

	@Override
	public String[] getRowCSV(HtmlPage page) {

		String title = page.getTitleText();
		
		String img = null;
		DomAttr imgDomAttr = page.getFirstByXPath("//img/@src[contains(.,'jpg') or contains(.,'jpeg')]");
		if(imgDomAttr != null) {
			img = imgDomAttr.getValue();
		}
		
		String link = null;
		HtmlAnchor anchor = (HtmlAnchor) page.getFirstByXPath("//*[contains(@class, 'correlati')]/li/a");
		if(anchor != null) {
			link = anchor.getHrefAttribute();
		}

		String[] idArray = page.getUrl().toString().split("/");

		String id = idArray[idArray.length-1]; 

		
		String[] elementRow = {id,title,img,link};

		System.out.println(title);

		return elementRow;
	}

}