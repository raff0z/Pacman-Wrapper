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
		DomAttr img = page.getFirstByXPath("//img/@src[contains(.,'jpg') or contains(.,'jpeg')]");
		HtmlAnchor anchor = (HtmlAnchor) page.getByXPath("//*[contains(@class, 'correlati')]/li/a").get(0);

		String[] idArray = page.getUrl().toString().split("/");

		String id = idArray[idArray.length-1]; 

		String[] elementRow = {id,title,img.getValue(),anchor.getHrefAttribute()};

		System.out.println(title);

		return elementRow;
	}

}